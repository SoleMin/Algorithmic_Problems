import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test {
  static PrintWriter writer =
      new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  int[][] a = new int[12][2000];
  int[][] e = new int[12 * 2000][3];
  Integer[] se = new Integer[12 * 2000];
  boolean[] used = new boolean[2000];
  int[] dp = new int[1 << 12];
  int[] one = new int[1 << 12];

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
      for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
          a[i][j] = readInt();
          int k = i * m + j;
          e[k][0] = a[i][j];
          e[k][1] = j;
          e[k][2] = i;
        }
      for (int i = n * m - 1; i >= 0; i--) se[i] = i;
      Arrays.sort(
          se,
          0,
          n * m,
          (i, j) -> {
            int[] x = e[i], y = e[j];
            return x[0] == y[0]
                ? (x[1] == y[1] ? Integer.compare(x[2], y[2]) : Integer.compare(x[1], y[1]))
                : Integer.compare(x[0], y[0]);
          });
      Arrays.fill(used, 0, m, false);
      Arrays.fill(dp, 0, 1 << n, -1);
      dp[0] = 0;
      int cc = 0;
      for (int x = n * m - 1; x >= 0; x--) {
        int c = e[se[x]][1];
        if (used[c]) continue;
        used[c] = true;
        cc++;
        if (cc > n) break;

        Arrays.fill(one, 0, 1 << n, 0);

        for (int i = (1 << n) - 1; i > 0; i--) {
          for (int r = 0; r < n; r++) {
            int sum = 0;
            for (int j = 0; j < n; j++) if (((i >> j) & 1) != 0) sum += a[(j + r) % n][c];
            one[i] = Math.max(one[i], sum);
          }
        }

        for (int i = (1 << n) - 1; i >= 0; i--) {
          int u = (1 << n) - 1 - i;
          int p = u;
          if (dp[i] >= 0)
            while (p > 0) {
              dp[i | p] = Math.max(dp[i | p], dp[i] + one[p]);
              p = (p - 1) & u;
            }
        }
      }
      writer.println(dp[(1 << n) - 1]);
    }
  }
}
