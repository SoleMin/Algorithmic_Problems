import java.util.*;
import java.io.*;

public class P911d {

  private static void solve() {
    int n = nextInt();

    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] > a[j]) {
          cnt++;
        }
      }
    }

    cnt %= 2;

    int m = nextInt();
    for (int i = 0; i < m; i++) {
      int l = nextInt();
      int r = nextInt();

      int size = r - l + 1;
      long sum = ((long)size * (size - 1)) / 2;

      sum %= 2;

      cnt += sum;
      cnt %= 2;

      System.out.println(cnt == 0 ? "even" : "odd");
    }
  }

  private static void run() {
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    solve();

    out.close();
  }

  private static StringTokenizer st;
  private static BufferedReader br;
  private static PrintWriter out;

  private static String next() {
    while (st == null || !st.hasMoreElements()) {
      String s;
      try {
        s = br.readLine();
      } catch (IOException e) {
        return null;
      }
      st = new StringTokenizer(s);
    }
    return st.nextToken();
  }

  private static int nextInt() {
    return Integer.parseInt(next());
  }

  private static long nextLong() {
    return Long.parseLong(next());
  }

  public static void main(String[] args) {
    run();
  }
}