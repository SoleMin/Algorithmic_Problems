import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
  FastScanner in;
  PrintWriter out;

  public void run() {
    try {
      in = new FastScanner(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      solve();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void solve() throws IOException {
    long l = new Long(in.next());
    long r = new Long(in.next());
    if (r - l < 2 || (r - l == 2 && l % 2 != 0)) {
      out.println("-1");
    } else {
      if (l % 2 != 0) {
        l++;
      }
      out.println(l);
      out.println(l+1);
      out.println(l+2);
    }
  }

  class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStreamReader in) {
      br = new BufferedReader(in);
    }

    String nextLine() {
      String str = null;
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }

      return str;
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }

  public static void main(String[] arg) {
    A o = new A();
    o.run();
  }

}
