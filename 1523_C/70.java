import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dauom
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    CCompressionAndExpansion solver = new CCompressionAndExpansion();
    int testCount = Integer.parseInt(in.next());
    for (int i = 1; i <= testCount; i++)
      solver.solve(i, in, out);
    out.close();
  }

  static class CCompressionAndExpansion {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();

      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      ArrayList<Integer> start = new ArrayList<>();
      start.add(in.nextInt());
      ans.add(start);
      out.println("1");
      for (int i = 1; i < n; i++) {
        ArrayList<Integer> lastList = ans.get(ans.size() - 1);
        ArrayList<Integer> curList = (ArrayList<Integer>) lastList.clone();
        ans.add(curList);

        int curLast = in.nextInt();
        for (int j = lastList.size() - 1; j >= 0; j--) {
          int last = lastList.get(j);
          if (curLast == 1) {
            curList.add(1);
            break;
          } else if (curLast == last + 1) {
            curList.set(j, curLast);
            break;
          } else {
            curList.remove(j);
          }
        }
        for (int j = 0; j < curList.size(); j++) {
          if (j > 0) out.print(".");
          out.print(curList.get(j));
        }
        out.println();
      }
    }

  }

  static final class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1 << 18];
    private int curChar;
    private int numChars;

    public InputReader() {
      this.stream = System.in;
    }

    public InputReader(final InputStream stream) {
      this.stream = stream;
    }

    private int read() {
      if (this.numChars == -1) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return -1;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public final int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) { // 45 == '-'
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) { // 48 == '0', 57 == '9'
        res *= 10;
        res += c - 48; // 48 == '0'
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public final String next() {
      int c;
      while (isSpaceChar(c = this.read())) {
      }

      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);

      while (!isSpaceChar(c = this.read())) {
        result.appendCodePoint(c);
      }

      return result.toString();
    }

    private static boolean isSpaceChar(final int c) {
      return c == 32 || c == 10 || c == 13 || c == 9
          || c == -1; // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    }

  }
}

