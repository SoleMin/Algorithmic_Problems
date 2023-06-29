import java.util.*;
import java.io.*;
public class D {
  
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);
  
  public static void main(String[] args) {
    boolean even = true;
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      for (int j = 0; j < i; j++) {
        if (a[j] > a[i]) {
          even = !even;
        }
      }
    }
    int m = in.nextInt();
    for (int i = 0; i < m; i++) {
      if ((1 - in.nextInt() + in.nextInt()) / 2 % 2 == 1) {
        even = !even;
      }
      if (even)
        out.println("even");
      else
        out.println("odd");
    }
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