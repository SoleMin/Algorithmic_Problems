import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ShekharN
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        private final int MOD = (int) (1e9 + 7);

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextString();
            }
            int[] dp = new int[n];
            Arrays.parallelSetAll(dp, i -> 0);
            dp[0] = 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i].equals("f")) {
                    cnt++;
                    continue;
                }
                calc(dp, n, cnt);
                cnt = 0;
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += dp[i];
                sum %= MOD;
            }
            out.println(sum);
        }

        private void calc(int[] dp, int n, int cnt) {
            for (int i = n - 1; i >= 0; i--) {
                if (i != n - 1) dp[i] += dp[i + 1];
                dp[i] %= MOD;
            }
            //int[] tmp = new int[n];
            int prev = dp[0];
            for (int i = 0, y = 0; i < MathUtil.gcdInt(n, cnt); i++) {
                //tmp[(i+cnt)%n] = dp[i];
                y = i;
                prev = dp[i];
                do {
                    int nextId = (y + cnt) % n;
                    int tmp = dp[nextId];
                    dp[nextId] = prev;
                    prev = tmp;
                    y = nextId;
                } while (y != i);

            }
            //Arrays.parallelSetAll(dp,i->tmp[i]);
        }

    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        public String nextString() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }

    static class MathUtil {
        public static int gcdInt(int a, int b) {
            if (b == 0) return a;
            return gcdInt(b, a % b);
        }

    }
}

