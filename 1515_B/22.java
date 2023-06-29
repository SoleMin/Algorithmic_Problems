import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution1515B {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Solver1515B solver = new Solver1515B();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      solver.solve(i, in, out);
    }
    out.close();
  }

  static class Solver1515B {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      boolean f = false;
      if (n % 2 == 0) {
        int s = (int) Math.sqrt(n / 2);
        if (s * s == n / 2) {
          f = true;
        }
      }
      if (n % 4 == 0) {
        int s = (int) Math.sqrt(n / 4);
        if (s * s == n / 4) {
          f = true;
        }
      }
      if (f) {
        out.println("YES");
      } else {
        out.println("NO");
      }
    }
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
  }
}