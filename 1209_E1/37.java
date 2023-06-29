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
      int[] dp = new int[1<<n];
      Arrays.fill(dp, -1);
      dp[0] = 0;
      for (int c : cols) {
        for (int i = (1 << n) - 1; i >= 0; i--) {
          int u = (1 << n) - 1 - i;
          int p = u;
          if (dp[i] >= 0)
            while (p > 0) {
              for (int r = 0; r < n; r++) {
                  int sum = 0;
                  for (int j = 0; j < n; j++) if (((p >> j) & 1) != 0) sum += a[(j + r) % n][c];
                  dp[i | p] = Math.max(dp[i | p], dp[i] + sum);
                }
              p = (p - 1) & u;
            }
        }
      }
      writer.println(dp[(1<<n) - 1]);
    }
  }
}
