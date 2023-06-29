import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 public class _908C {

 }

 */
public class _908C {
  public void solve() throws FileNotFoundException {
    InputStream inputStream = System.in;

    InputHelper in = new InputHelper(inputStream);

    // actual solution
    int n = in.readInteger();
    double r = in.readInteger();

    double[] x = new double[n];

    for (int i = 0; i < n; i++) {
      x[i] = in.readInteger();
    }

    double[] ans = new double[n];

    ans[0] = r;

    for (int i = 1; i < n; i++) {
      double cans = r;
      for (int j = 0; j < i; j++) {
        double dis = Math.abs(x[j] - x[i]);

        if (dis <= 2 * r) {

          if (dis == 2 * r) {
            cans = Math.max(cans, ans[j]);
            continue;
          } else if (x[i] == x[j]) {
            cans = Math.max(cans, ans[j] + 2 * r);
            continue;
          }
          cans = Math.max(cans, ans[j] + Math.sqrt((4 * (r * r)) - dis * dis));
        }
      }

      ans[i] = cans;
    }

    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }

    // end here
  }

  public static void main(String[] args) throws FileNotFoundException {
    (new _908C()).solve();
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
