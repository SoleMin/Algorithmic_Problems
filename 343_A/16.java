import java.io.*;
import java.util.*;

public class cf343a {
  static FastIO in = new FastIO(), out = in;

  public static void main(String[] args) {
    out.println(go(in.nextLong(),in.nextLong()));
    out.close();
  }
  static long go(long a, long b) {
    return b==0?0:(go(b,a%b) + a/b);
  }

  static class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    public FastIO() {
      this(System.in, System.out);
    }

    public FastIO(InputStream in, OutputStream out) {
      super(new BufferedWriter(new OutputStreamWriter(out)));
      br = new BufferedReader(new InputStreamReader(in));
      scanLine();
    }

    public void scanLine() {
      try {
        st = new StringTokenizer(br.readLine().trim());
      } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
      }
    }

    public int numTokens() {
      if (!st.hasMoreTokens()) {
        scanLine();
        return numTokens();
      }
      return st.countTokens();
    }

    public String next() {
      if (!st.hasMoreTokens()) {
        scanLine();
        return next();
      }
      return st.nextToken();
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
