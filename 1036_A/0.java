import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author El Mehdi ASSALI
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    AFunctionHeight solver = new AFunctionHeight();
    solver.solve(1, in, out);
    out.close();
  }

  static class AFunctionHeight {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
      long n = in.nextLong(), k = in.nextLong();
      out.println(k / n + (k % n == 0 ? 0 : 1));
    }

  }

  static class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream inputStream) {
      reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return tokenizer.nextToken();
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

  }
}

