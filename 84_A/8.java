import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main implements Runnable {
  private final String problemname = "";
  private final String FILE_IN  = problemname + ".in";
  private final String FILE_OUT = problemname + ".out";

  public void run() {
//    in = new BufferedReader(new FileReader(FILE_IN));
//    out = new PrintWriter(FILE_OUT);
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    _st = new StringTokenizer("");

    // TODO: type your code here
    int n = nextInt();

    int best = n + n / 2;
    /*
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n - i; j++) {
        best = Math.max(best, i + j + Math.min(n - i, n - j));
      }
    }*/

    out.println(best);

    try {
      in.close();
      out.close();
    }
    catch (Exception e) {
      System.err.println("Epic fail");
    }
  }

  BufferedReader in;
  PrintWriter out;
  StringTokenizer _st;

  public static void main(String[] args) {
    new Thread(new Main()).start();
  }

  private void seek() {
    while (!_st.hasMoreTokens()) {
      String s;
      try {
        s = in.readLine();
        _st = new StringTokenizer(s);
      } catch (Exception e) {
        return;
      }
    }
  }

  private String next() {
    seek();
    return _st.nextToken();
  }

  private int nextInt() {
    return Integer.parseInt(next());
  }

  private long nextLong() {
    return Long.parseLong(next());
  }

  private double nextDouble() {
    return Double.parseDouble(next());
  }

  private BigInteger nextBigInteger() {
    return new BigInteger(next());
  }
}
