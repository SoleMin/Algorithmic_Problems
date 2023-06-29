import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    TaskC solver = new TaskC();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskC {
    private long MOD = (long) (1e9 + 7);
    int[][] dp = new int[5001][5001];

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      ArrayList<Character> commands = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        char ch = in.next().charAt(0);
        commands.add(ch);
      }
      for (int a[] : dp) Arrays.fill(a, -1);

      out.println(count(0, commands, 0));

    }

    public int count(int index, ArrayList<Character> commands, int deepCount) {
      if (deepCount < 0) {
        return 0;
      }
      if (index == commands.size()) {
        return 1;
      } else {

        if (dp[index][deepCount] != -1) return dp[index][deepCount];
        long result = 0;
        char ch = commands.get(index);
        result = count(index, commands, deepCount - 1);
        if (ch == 's') {
          result += count(index + 1, commands, deepCount);
        } else {
          result += count(index + 1, commands, deepCount + 1);
          result -= count(index + 1, commands, deepCount);
        }
        if (result >= MOD) {
          result -= MOD;
        }
        if (result < 0) {
          result += MOD;
        }
        return dp[index][deepCount] = (int) result;
      }
    }

  }

  static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (numChars == -1) {
        throw new InputMismatchException();
      }
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0) {
          return -1;
        }
      }
      return buf[curChar++];
    }

    public int readInt() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = read();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9') {
          throw new InputMismatchException();
        }
        res *= 10;
        res += c - '0';
        c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
    }

    public String readString() {
      int c = read();
      while (isSpaceChar(c)) {
        c = read();
      }
      StringBuilder res = new StringBuilder();
      do {
        if (Character.isValidCodePoint(c)) {
          res.appendCodePoint(c);
        }
        c = read();
      } while (!isSpaceChar(c));
      return res.toString();
    }

    public boolean isSpaceChar(int c) {
      if (filter != null) {
        return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
      return readString();
    }

    public int nextInt() {
      return readInt();
    }

    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);

    }

  }
}

