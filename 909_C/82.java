import java.util.*;
import java.io.*;
public class C {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    int n = in.nextInt();
    int[] sol = new int[n];
    sol[0] = 1;
    int mod = 1000000007;
    int maxind = 0;
    boolean f = true;
    for (int i = 0; i < n; i++) {
      if (!f) {
        //int accum = sol[0];
        for (int j = 1; j <= maxind; j++) {
          sol[j] += sol[j-1];
          sol[j] %= mod;
        }
        //out.println(Arrays.toString(sol));
      }
      if (in.next().equals("f")) {
        maxind++;
        f = true;
      }
      else {
        f = false;
      }
    }
    int ans = 0;
    for (int i = 0; i <= maxind; i++) {
      ans += sol[i];
      ans %= mod;
    }
    out.println(ans);
    finish();
  }
  
  public static void finish() {
    out.close();
    in.close();
    System.exit(0);
  }

  static class InputReader implements Iterator<String>, Closeable {
    // Fast input reader. Based on Kattio.java from open.kattis.com
    // but has method names to match Scanner

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    public InputReader(InputStream i) {
      r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasNext() {
      return peekToken() != null;
    }

    public int nextInt() {
      return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
      return Double.parseDouble(nextToken());
    }

    public long nextLong() {
      return Long.parseLong(nextToken());
    }

    public String next() {
      return nextToken();
    }
    
    public String nextLine() {
      try {
        line = r.readLine();
      } catch (IOException e) {
        line = null;
      }
      token = null;
      st = null;
      return line;
    }
    
    public void close() {
      try {
        r.close();
      } catch (IOException e) {
      }
    }

    private String peekToken() {
      if (token == null)
        try {
          while (st == null || !st.hasMoreTokens()) {
            line = r.readLine();
            if (line == null)
              return null;
            st = new StringTokenizer(line);
          }
          token = st.nextToken();
        } catch (IOException e) {
        }
      return token;
    }

    private String nextToken() {
      String ans = peekToken();
      token = null;
      return ans;
    }
    
  }

}