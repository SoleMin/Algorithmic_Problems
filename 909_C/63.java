import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CFC {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {1, 0, -1, 0};

    void solve() throws IOException {
        int n = nextInt();
        long[] dp0 = new long[10 + n];
        long[] dp1 = new long[10 + n];
        long[] pre = new long[10 + n];
        dp0[0] = 1;
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextString();
        }
        String s = "s";
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1, 0);

            if (i == 0) {
                dp0[0] = 1;
                dp1[0] = 1;
            }
            else {
                if (arr[i - 1].equals(s)) {
                    for (int j = 0; j <= n + 5; j++) {
                        dp1[j] = pre[j];
                    }
                }
                else {
                    for (int j = 1; j <= n + 5; j++) {
                        dp1[j] = dp0[j - 1];
                    }
                }
            }

            Arrays.fill(pre, 0);
            pre[n + 5] = dp1[n + 5];
            for (int j = n + 4; j >= 0; j--) {
                pre[j] = pre[j + 1] + dp1[j];
                pre[j] %= MOD;
            }

            for (int j = 0; j <= n + 5; j++) {
                dp0[j] = dp1[j];
            }
        }

        long res = 0;
        for (int j = 0; j <= n + 5; j++) {
            res += dp0[j];
            res %= MOD;
        }

        out(res);
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    int gcd(int a, int b) {
        while(a != 0 && b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    public CFC() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFC();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
