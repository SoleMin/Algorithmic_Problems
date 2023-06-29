import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 public class _909C {

 }

 */
public class _909C {
  int mod = (int) 1e9 + 7;

  public void solve() throws FileNotFoundException {
    InputStream inputStream = System.in;

    InputHelper in = new InputHelper(inputStream);

    // actual solution
    int n = in.readInteger();

    char[] a = new char[n];

    for (int i = 0; i < n; i++) {
      a[i] = in.read().charAt(0);
    }

    int[][][] dp = new int[2][n + 1][2];

    dp[0][0][0] = dp[0][0][1] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = n; j >= 0; j--) {
        if (a[i - 1] == 's') {
          dp[1][j][0] = dp[1][j][1] = dp[0][j][1];
        } else {
          if (j > 0)
            dp[1][j][0] = dp[1][j][1] = dp[0][j - 1][0];
        }
      }

      for (int j = 0; j <= n; j++) {
        dp[0][j][0] = dp[1][j][0];
        dp[0][j][1] = dp[1][j][1];
        dp[1][j][0] = 0;
        dp[1][j][1] = 0;
      }
      for (int j = n - 1; j >= 0; j--) {
        dp[0][j][1] += dp[0][j + 1][1];
        dp[0][j][1] %= mod;
      }
    }

    System.out.println(dp[0][0][1]);
    // end here
  }

  public static void main(String[] args) throws FileNotFoundException {
    (new _909C()).solve();
  }

  class InputHelper {
    StringTokenizer tokenizer = null;
    private BufferedReader bufferedReader;

    public InputHelper(InputStream inputStream) {
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      bufferedReader = new BufferedReader(inputStreamReader, 16384);
    }

    public String read() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          String line = bufferedReader.readLine();
          if (line == null) {
            return null;
          }
          tokenizer = new StringTokenizer(line);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      return tokenizer.nextToken();
    }

    public Integer readInteger() {
      return Integer.parseInt(read());
    }

    public Long readLong() {
      return Long.parseLong(read());
    }
  }
}
