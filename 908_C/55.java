import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class C {
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();

    int n = sc.nextInt();
    long r = sc.nextInt();
    double d = 2 * r;
    long[] xs = sc.readLongArray(n);
    P[] points = new P[n];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i > 0) sb.append(' ');
      double y = r;
      for (int j = 0; j < i; j++) {
        long diff = Math.abs(xs[i] - points[j].x);
        if (diff <= 2 * r) {
          double dy = Math.sqrt(d * d - diff * diff);
          double testY = points[j].y + dy;
          y = Math.max(y, testY);
        }
      }

      sb.append(y);
      points[i] = new P(xs[i], y);
    }
    System.out.println(sb);
  }

  static class P {
    final long x;
    final double y;

    public P(long x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  static void shuffle(int[] arr) {
    Random rng = new Random();
    int length = arr.length;
    for (int idx = 0; idx < arr.length; idx++) {
      int toSwap = idx + rng.nextInt(length - idx);
      int tmp = arr[idx];
      arr[idx] = arr[toSwap];
      arr[toSwap] = tmp;
    }
  }

  public static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    public FastScanner(Reader in) {
      br = new BufferedReader(in);
    }

    public FastScanner() {
      this(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
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

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String readNextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

    int[] readIntArray(int n) {
      int[] a = new int[n];
      for (int idx = 0; idx < n; idx++) {
        a[idx] = nextInt();
      }
      return a;
    }

    long[] readLongArray(int n) {
      long[] a = new long[n];
      for (int idx = 0; idx < n; idx++) {
        a[idx] = nextLong();
      }
      return a;
    }
  }
}
