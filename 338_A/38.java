import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class cf337c {
  static long mod,n,m,k;
  public static void main(String[] args) {
    FastIO in = new FastIO(), out = in;
    n = in.nextLong();
    m = in.nextLong();
    k = in.nextLong();
    mod = (long)1e9 + 9;
    long x = m - (n-n%k)/k * (k-1) - n%k;
    if(x < 0) x = 0;
    long ans = (pow(2,x+1)-2)*k + m-x*k;
    ans = ((ans%mod)+mod)%mod;
    out.println(ans);
    out.close();
  }
  static long pow(long x, long p) {
    if(p == 0) return 1%mod;
    long ans = pow(x,p/2);
    ans = (ans*ans)%mod;
    if(p%2 == 1) ans = (ans*x)%mod;
    return ans;
  }
  static class FastIO extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;
    
    public FastIO() {
      this(System.in,System.out);
    }
    public FastIO(InputStream in, OutputStream out) {
      super(new BufferedWriter(new OutputStreamWriter(out)));
      br = new BufferedReader(new InputStreamReader(in));
      scanLine();
    }
    public void scanLine() {
      try {
        st = new StringTokenizer(br.readLine().trim());
      } catch(Exception e) {
        throw new RuntimeException(e.getMessage());
      }
    }
    public int numTokens() {
      if(!st.hasMoreTokens()) {
        scanLine();
        return numTokens();
      }
      return st.countTokens();
    }
    public String next() {
      if(!st.hasMoreTokens()) {
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
