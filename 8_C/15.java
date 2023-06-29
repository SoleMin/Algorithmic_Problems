import java.io.*;
import java.util.*;

public class Main {

    BufferedReader in = null;
    PrintWriter out = null;

    int dist(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);
        return dx * dx + dy * dy;
    }

    boolean testBit(int use, int p) {
        return ((use >> p) & 1) == 1;
    }

    int rec(int use, int a[][], int dp[], int next[]) {
        if (dp[use] != -1) {
            return dp[use];
        }
        if (use == 0) {
            return dp[use] = 0;
        }
        int n = a.length;
        int ix = -1;
        
        for (int i = 0; i < n; ++i) {
            if (testBit(use, i)) {
                if (ix == -1) {
                    ix = i;
                    break;
                }

                /*
                int t = rec(use ^ (1 << i), a, dp);
                t += a[i][i];
                r = Math.min(r, t);*/
            }
        }

        int r = rec(use ^ (1 << ix), a, dp, next) + a[ix][ix];
        next[use] = use ^ (1 << ix);
        

        for (int i = ix + 1; i < n; ++i) {
            if (!testBit(use, i)) {
                continue;
            }
            int t = rec(use ^ (1 << ix) ^ (1 << i), a, dp, next);
            t += a[ix][i];
            if (t < r) {
                r = t;
                next[use] = use ^ (1 << ix) ^ (1 << i);
            }
        }

        return dp[use] = r;
    }

    void print(int use1, int use2, int n) {
        for (int i = 0; i < n; ++i) {
            if (testBit(use1, i) ^ testBit(use2, i)) {
                int x = i + 1;
                out.print(x + " ");
            }
        }
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new FileReader("input.txt"));
        out = new PrintWriter(System.out);
        
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        int sx = Integer.valueOf(st.nextToken());
        int sy = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int n = Integer.valueOf(st.nextToken());
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(in.readLine());
            x[i] = Integer.valueOf(st.nextToken());
            y[i] = Integer.valueOf(st.nextToken());
        }
        int a[][] = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = dist(x[i], y[i], sx, sy) + dist(x[j], y[j], sx, sy) + dist(x[i], y[i], x[j], y[j]);
            }
        }

        int dp[] = new int[1 << n];
        Arrays.fill(dp, -1);
        int next[] = new int[1 << n];
        int ans = rec((1 << n) - 1, a, dp, next);

        out.println(ans);

        int use = (1 << n) - 1;
        while (true) {
            int nuse = next[use];
            out.print("0 ");
            print(use, nuse, n);
            if (nuse == 0) break;
            use = nuse;
        }
        out.println("0");
        
        in.close();
        out.close();
    }
    
    public static void main(String[] args) throws IOException {
        new Main().solve();
    }

}
