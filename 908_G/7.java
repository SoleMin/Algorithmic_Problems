import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jialin Ouyang (Jialin.Ouyang@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    QuickScanner in = new QuickScanner(inputStream);
    QuickWriter out = new QuickWriter(outputStream);
    TaskG solver = new TaskG();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskG {
    static int MAXL = 700 + 1;
    static IntModular MOD = new IntModular();
    int n;
    char[] digits;
    int[] pow10;
    int[] ones;
    int[][][] way;

    public void solve(int testNumber, QuickScanner in, QuickWriter out) {
      digits = new char[MAXL];
      n = in.next(digits);
      initPow();
      int res = MOD.mul(calc(9), 9);
      for (int digit = 0; digit < 9; ++digit) {
        res = MOD.sub(res, calc(digit));
      }
      out.println(res);
    }

    void initPow() {
      pow10 = new int[n + 1];
      ones = new int[n + 1];
      pow10[0] = 1;
      for (int i = 1; i <= n; ++i) {
        pow10[i] = MOD.mul(pow10[i - 1], 10);
        ones[i] = MOD.add(MOD.mul(ones[i - 1], 10), 1);
      }
    }

    int calc(int targetDigit) {
      if (way == null) {
        way = new int[2][2][n + 1];
      }
      int t = 0;
      clearCnt(t);
      way[t][0][0] = 1;
      for (int i = 0; i < n; ++i) {
        int digit = digits[i] - '0';
        clearCnt(t ^ 1);
        // not free
        for (int cnt = 0; cnt <= n; ++cnt)
          if (way[t][0][cnt] > 0) {
            // not free
            int newCnt = targetDigit < digit ? cnt + 1 : cnt;
            way[t ^ 1][0][newCnt] = MOD.add(
                way[t ^ 1][0][newCnt],
                way[t][0][cnt]);
            // free
            way[t ^ 1][1][cnt] = MOD.add(
                way[t ^ 1][1][cnt],
                MOD.mul(
                    Math.min(targetDigit + 1, digit),
                    way[t][0][cnt]));
            way[t ^ 1][1][cnt + 1] = MOD.add(
                way[t ^ 1][1][cnt + 1],
                MOD.mul(
                    Math.max(digit - targetDigit - 1, 0),
                    way[t][0][cnt]));
          }
        // free
        for (int cnt = 0; cnt <= n; ++cnt)
          if (way[t][1][cnt] > 0) {
            way[t ^ 1][1][cnt] = MOD.add(
                way[t ^ 1][1][cnt],
                MOD.mul(
                    targetDigit + 1,
                    way[t][1][cnt]));
            way[t ^ 1][1][cnt + 1] = MOD.add(
                way[t ^ 1][1][cnt + 1],
                MOD.mul(
                    9 - targetDigit,
                    way[t][1][cnt]));
          }
        t ^= 1;
      }
      int res = 0;
      for (int cnt = 0; cnt <= n; ++cnt) {
        res = MOD.add(
            res,
            MOD.mul(MOD.mul(
                ones[n - cnt],
                pow10[cnt]),
                MOD.add(way[t][0][cnt], way[t][1][cnt])));
      }
      return res;
    }

    void clearCnt(int t) {
      for (int free = 0; free < 2; ++free) {
        Arrays.fill(way[t][free], 0);
      }
    }

  }

  static class QuickWriter {
    private final PrintWriter writer;

    public QuickWriter(OutputStream outputStream) {
      this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public QuickWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; ++i) {
        if (i > 0) {
          writer.print(' ');
        }
        writer.print(objects[i]);
      }
    }

    public void println(Object... objects) {
      print(objects);
      writer.println();
    }

    public void close() {
      writer.close();
    }

  }

  static class IntModular {
    private static final int MOD = 1000000007;
    public final int mod;
    private final int[] x;

    public IntModular() {
      this(MOD);
    }

    public IntModular(int mod) {
      this.mod = mod;
      this.x = new int[2];
    }

    public int add(int a, int b) {
      return fix(a + b, mod);
    }

    public int sub(int a, int b) {
      return fix(a - b, mod);
    }

    public int mul(int a, int b) {
      return mul(a, b, mod);
    }

    public static int mul(int a, int b, int mod) {
      return a > 0
          ? (b < mod / a ? a * b : (int) ((long) a * b % mod))
          : 0;
    }

    public static int fix(int a, int mod) {
      a = slightFix(a, mod);
      return 0 <= a && a < mod ? a : slightFix(a % mod, mod);
    }

    private static int slightFix(int a, int mod) {
      return a >= mod
          ? a - mod
          : a < 0 ? a + mod : a;
    }

  }

  static class QuickScanner {
    private static final int BUFFER_SIZE = 1024;
    private InputStream stream;
    private byte[] buffer;
    private int currentPosition;
    private int numberOfChars;

    public QuickScanner(InputStream stream) {
      this.stream = stream;
      this.buffer = new byte[BUFFER_SIZE];
      this.currentPosition = 0;
      this.numberOfChars = 0;
    }

    public int next(char[] s) {
      return next(s, 0);
    }

    public int next(char[] s, int startIdx) {
      int b = nextNonSpaceChar();
      int res = 0;
      do {
        s[startIdx++] = (char) b;
        b = nextChar();
        ++res;
      } while (!isSpaceChar(b));
      return res;
    }

    public int nextNonSpaceChar() {
      int res = nextChar();
      for (; isSpaceChar(res) || res < 0; res = nextChar()) ;
      return res;
    }

    public int nextChar() {
      if (numberOfChars == -1) {
        throw new RuntimeException();
      }
      if (currentPosition >= numberOfChars) {
        currentPosition = 0;
        try {
          numberOfChars = stream.read(buffer);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        if (numberOfChars <= 0) {
          return -1;
        }
      }
      return buffer[currentPosition++];
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\t' || isEndOfLineChar(c);
    }

    public boolean isEndOfLineChar(int c) {
      return c == '\n' || c == '\r' || c < 0;
    }

  }
}

