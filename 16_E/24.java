/**
 * Codeforces Beta Round 16
 * 
 * @author ProjectYoung
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CF16E {
  private void solve(InputReader in, PrintWriter out) {
    int n = in.nextInt();
    double[][] prob = new double[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        prob[i][j] = in.nextDouble();
      }
    }
    int[] fish = new int[n];
    for (int i = 0; i < n; i++) {
      fish[i] = 1 << i;
    }

    double[] res = new double[1 << n];
    res[0] = 1.0;
    for (int mask = 1; mask < (1 << n) - 1; mask++) {
      for (int i = 0; i < n; i++) {
        if ((mask & fish[i]) == 0) {
          continue;
        }
        int lastMask = mask ^ fish[i];
        int live = n;
        for (int j = 0; j < n; j++) {
          if ((lastMask & fish[j]) != 0) {
            live--;
          }
        }
        double p = 0.0;
        for (int j = 0; j < n; j++) {
          if ((lastMask & fish[j]) != 0 || j == i) {
            continue;
          }
          p += prob[j][i];
        }
        res[mask] += res[lastMask] * p * 2 / live / (live - 1);
      }
    }
    for (int i = 0; i < n; i++) {
      out.printf("%.6f ", res[((1 << n) - 1) ^ fish[i]]);
    }
  }

  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    new CF16E().solve(in, out);
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }
}
