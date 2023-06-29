
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * CodeForces 8C - Looking for Order
 * Created by Darren on 14-10-1.
 */
public class Main {
    Reader in = new Reader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    int n;
    int[] x, y;
    int[][] time;
    int status;
    int[] dp;
    int[] pre;


    void run() throws IOException {
        int xs = in.nextInt(), ys = in.nextInt();
        n = in.nextInt();
        x = new int[n+1];
        y = new int[n+1];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        x[n] = xs;
        y[n] = ys;

        computeTime();

        status = (1<<n);
        dp = new int[1<<n];
        pre = new int[1<<n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < status; i++) {
            if (dp[i] == -1)
                continue;
            for (int j = 0; j < n; j++) {
                if (((1<<j) & i) == 0) {
                    int t1 = ((1<<j) | i), temp1 = dp[i] + 2 * time[n][j];
                    if (dp[t1] == -1 || dp[t1] > temp1) {
                        dp[t1] = temp1;
                        pre[t1] = i;
                    }
                    for (int k = 0; k < n; k++) {
                        if (((1<<k) & t1) == 0) {
                            int t2 = ((1<<k) | t1),
                                    temp2 = dp[i] + time[n][j] + time[j][k] + time[k][n];
                            if (dp[t2] == -1 || dp[t2] > temp2) {
                                dp[t2] = temp2;
                                pre[t2] = i;
                            }
                        }
                    }
                    break;
                }
            }
        }

        int cur = (1 << n) - 1;
        out.println(dp[cur]);
        out.print(0);
        while (cur > 0) {
            int last = pre[cur], diff = cur ^ last;
            int obj1 = -1, obj2 = -1;
            for (int i = 0; i < n; i++) {
                if (((1<<i) & diff) > 0) {
                    obj2 = obj1;
                    obj1 = i;
                }
            }
            if (obj2 >= 0)
                out.printf(" %d %d %d", obj1+1, obj2+1, 0);
            else
                out.printf(" %d %d", obj1+1, 0);
            cur = last;
        }
        out.flush();
    }

    void computeTime() {
        time = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = i+1; j <= n; j++)
                time[i][j] = time[j][i] = (x[i]- x[j])*(x[i]- x[j]) +
                        (y[i]- y[j])*(y[i]- y[j]);
        }
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        String nextToken() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer( reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        String readLine() throws IOException {
            return reader.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt( nextToken() );
        }

        long nextLong() throws IOException {
            return Long.parseLong( nextToken() );
        }

        double nextDouble() throws IOException {
            return Double.parseDouble( nextToken() );
        }
    }
}
