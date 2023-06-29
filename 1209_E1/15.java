import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {
  static PrintWriter writer =
      new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

  static int readInt() {
    int ans = 0;
    boolean neg = false;
    try {
      boolean start = false;
      for (int c = 0; (c = System.in.read()) != -1; ) {
        if (c == '-') {
          start = true;
          neg = true;
          continue;
        } else if (c >= '0' && c <= '9') {
          start = true;
          ans = ans * 10 + c - '0';
        } else if (start) break;
      }
    } catch (IOException e) {
    }
    return neg ? -ans : ans;
  }

  static long readLong() {
    long ans = 0;
    boolean neg = false;
    try {
      boolean start = false;
      for (int c = 0; (c = System.in.read()) != -1; ) {
        if (c == '-') {
          start = true;
          neg = true;
          continue;
        } else if (c >= '0' && c <= '9') {
          start = true;
          ans = ans * 10 + c - '0';
        } else if (start) break;
      }
    } catch (IOException e) {
    }
    return neg ? -ans : ans;
  }

  static String readLine() {
    StringBuilder b = new StringBuilder();
    try {
      boolean start = false;
      for (int c = 0; (c = System.in.read()) != -1; ) {
        if (Character.isLetterOrDigit(c)) {
          start = true;
          b.append((char) c);
        } else if (start) break;
      }
    } catch (IOException e) {
    }
    return b.toString();
  }

  public static void main(String[] args) {
    Test te = new Test();
    te.start();
    writer.flush();
  }

  int[] buf = new int[10];

  int best(int[][] a, int c) {
    int ans = 0;
    if (c == a[0].length) {
      for (int i = 0; i < a.length; i++)
        ans += Arrays.stream(a[i]).max().getAsInt();
      return ans;
    }
    for (int r = 0; r <= a.length; r++) {
      for (int i = 0; i < a.length; i++)
        buf[(i+1) % a.length] = a[i][c];
      for (int i = 0; i < a.length; i++)
        a[i][c] = buf[i];
      ans = Math.max(ans, best(a, c+1));
    }
    return ans;
  }

  void start() {
    int t = readInt();
    while (t-- > 0) {
      int n = readInt(), m = readInt();
      int[][] a = new int[n][m];
      int[][] e = new int[n*m][];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
          a[i][j] = readInt();
          e[i*m+j] = new int[]{a[i][j], j};
        }
      Arrays.sort(e, (x, y) -> x[0] == y[0] ? Integer.compare(x[1], y[1])
          : Integer.compare(y[0], x[0]));
      Set<Integer> cols = new HashSet<>();
      for (int[] x : e) {
        cols.add(x[1]);
        if (cols.size() >= n) break;
      }
      int[] cs = cols.stream().mapToInt(Integer::intValue).toArray();
      int[][] na = new int[n][cs.length];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < cs.length; j++)
          na[i][j] = a[i][cs[j]];
      writer.println(best(na, 0));
    }
  }
}
