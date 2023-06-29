import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author MaxHeap
 */
public class Main {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    F1SameSumBlocksEasy solver = new F1SameSumBlocksEasy();
    solver.solve(1, in, out);
    out.close();
  }

  static class F1SameSumBlocksEasy {

    Map<Long, List<IntPair>> sums = new HashMap<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      long[] arr = in.nextLongArray(n);
      long[] pref = ArrayUtils.prefixSum(arr);
      for (int i = 0; i < n; ++i) {
        for (int j = i; j >= 0; --j) {
          long sum = pref[i + 1] - pref[j];
          if (sums.containsKey(sum)) {
            sums.get(sum).add(Factories.makeIntPair(j, i));
          } else {
            List<IntPair> pairs = new ArrayList<>();
            pairs.add(Factories.makeIntPair(j, i));
            sums.put(sum, pairs);
          }
        }
      }

      int best = 0;
      List<IntPair> res = new ArrayList<>();
      for (long sum : sums.keySet()) {
        List<IntPair> pairs = sums.get(sum);
        List<IntPair> temp = new ArrayList<>();
        int last = -1;
        for (IntPair cur : pairs) {
          if (cur.first > last) {
            last = cur.second;
            temp.add(cur);
          }
        }
        if (temp.size() > best) {
          best = temp.size();
          res = temp;
        }
      }
      out.println(best);
      for (IntPair pair : res) {
        out.println((pair.first + 1) + " " + (pair.second + 1));
      }
    }

  }

  static class ArrayUtils {

    public static long[] prefixSum(long[] arr) {
      long[] acc = new long[arr.length + 1];
      for (int i = 1; i <= arr.length; ++i) {
        acc[i] = acc[i - 1] + arr[i - 1];
      }
      return acc;
    }

  }

  static interface FastIO {

  }

  static final class Factories {

    private Factories() {
    }

    public static IntPair makeIntPair(int first, int second) {
      return new IntPair(first, second);
    }

  }

  static class IntPair implements Comparable<IntPair> {

    public int first;
    public int second;

    public IntPair() {
      first = second = 0;
    }

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    public int compareTo(IntPair a) {
      if (first == a.first) {
        return Integer.compare(second, a.second);
      }
      return Integer.compare(first, a.first);
    }

    public String toString() {
      return "<" + first + ", " + second + ">";
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      IntPair a = (IntPair) o;

      if (first != a.first) {
        return false;
      }
      return second == a.second;
    }

    public int hashCode() {
      int result = first;
      result = 31 * result + second;
      return result;
    }

  }

  static class InputReader implements FastIO {

    private InputStream stream;
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int EOF = -1;
    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == EOF) {
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
            return EOF;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public long nextLong() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      long res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10L;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }
      throw new InputMismatchException();
    }

    public static boolean isSpaceChar(int c) {
      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
    }

    public long[] nextLongArray(int n) {
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = nextLong();
      }
      return arr;
    }

  }
}

