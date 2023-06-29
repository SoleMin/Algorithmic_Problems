import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by timur on 28.03.15.
 */

public class TaskD {
    boolean eof;
    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new TaskD().run();
    }

    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return "-1";
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }


    void run() throws IOException {
        InputStream input = System.in;
        PrintStream output = System.out;
        try {
            File f = new File("a.in");
            if (f.exists() && f.canRead()) {
                input = new FileInputStream(f);
                output = new PrintStream("a.out");
            }
        } catch (Throwable e) {
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        br.close();
        out.close();
    }

    long md(long x, long y, long x1, long y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }
    
    double md(double x, double y, double x1, double y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    double ed(double x, double y, double x1, double y1) {
        return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
    }

    void solve() {
        int t = nextInt();
        long n, k;
        int m = 34;
        long[] res = new long[m];
        res[1] = 0;
        res[2] = 1;
        for (int i = 3; i < m; i++) {
            res[i] = res[i - 1] * 4L;
        }
        long[] l = new long[m];
        long[] r = new long[m];
        l[0] = 0;
        l[1] = 1;
        r[0] = 0;
        r[1] = 1;
        for (int i = 2; i < m; i++) {
            l[i] = l[i - 1] * 2 + 1;
            r[i] = r[i - 1] * 4;
        }

        long[] mi = new long[m];
        long[] ma = new long[m];
        for (int i = 1; i < m; i++) {
            mi[i] = mi[i - 1] + l[i];
            ma[i] = ma[i - 1] + r[i];
        }

//        for (int i = 0; i < m - 1; i++) {
//            for (int j = 0; j <= i; j++) {
//                out.println(i + " " + j + " " + mi[(int)i - j] + " " + (ma[(int)i] - l[(int)i - j + 1] * ma[j]));
//            }
//        }

        for (int i = 0; i < t; i++) {
            n = nextLong();
            k = nextLong();
            if (n >= 32) {
                out.println("YES " + (n - 1));
            } else {
                if (k > ma[(int)n]) {
                    out.println("NO");
                } else {
                    for (int j = 0; j <= n; j++) {
                        if (mi[(int)n - j] <= k && ma[(int)n] - l[(int)n - j + 1] * ma[j] >= k) {
                            out.println("YES " + j);
                            break;
                        }
                        if (j == n - 1) {
                            out.println("NO");
                        }
                    }
                }
            }
        }
    }

}