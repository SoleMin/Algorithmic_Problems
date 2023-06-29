import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {
  static int len(long n) {
    int res = 0;
    while (n > 0) {
      n /= 10;
      res++;
    }
    return res;
  }
  static long big(int len) {
    long p = 1;
    while (len-- > 0) p *= 10;
    return p - 1;
  }
  static long small(int len) {
    return big(len - 1) + 1;
  }
  static long cnt(long n) {
    int len = len(n);
    long cnt = 0;
    for (int l = 1; l < len; l++)
      cnt += 1l * l * (big(l) - small(l) + 1);
    cnt += 1l * len * (n - small(len));
    return cnt;
  }
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    long k = sc.nextLong();
    if (k == 1) {
      System.out.println(1);
      return;
    }
    long lo = 1, hi = k, res = 1;
    while(lo <= hi) {
      long mid = lo + hi >> 1L;
      if(cnt(mid) < k) {
        res = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    ArrayList<Integer> digits = new ArrayList<>();
    long tmp = res;
    while (tmp > 0) {
      digits.add((int)(tmp % 10));
      tmp /= 10;
    }
//    System.err.println("RES " + res);
//    System.err.println("DIGITS " + digits);
//    System.err.println("Cnt Res " + cnt(res));
    Collections.reverse(digits);
    out.println(digits.get((int)(k - cnt(res) - 1)));
    out.flush();
  }

  static class Scanner {
    StringTokenizer st;
    BufferedReader br;

    public Scanner(InputStream s) {
      br = new BufferedReader(new InputStreamReader(s));
    }

    public Scanner(FileReader f) {
      br = new BufferedReader(f);
    }

    public String next() throws IOException {
      while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
      return st.nextToken();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
      return br.readLine();
    }

    public double nextDouble() throws IOException {
      String x = next();
      StringBuilder sb = new StringBuilder("0");
      double res = 0, f = 1;
      boolean dec = false, neg = false;
      int start = 0;
      if (x.charAt(0) == '-') {
        neg = true;
        start++;
      }
      for (int i = start; i < x.length(); i++)
        if (x.charAt(i) == '.') {
          res = Long.parseLong(sb.toString());
          sb = new StringBuilder("0");
          dec = true;
        } else {
          sb.append(x.charAt(i));
          if (dec)
            f *= 10;
        }
      res += Long.parseLong(sb.toString()) / f;
      return res * (neg ? -1 : 1);
    }

    public boolean ready() throws IOException {
      return br.ready();
    }

  }
}
