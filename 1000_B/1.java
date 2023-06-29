import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
//        out = new PrintWriter(new File("output.txt"));
//        br = new BufferedReader(new FileReader(new File("input.txt")));
        int JOPI = 1;
        for (int NASRAL = 0; NASRAL < JOPI; NASRAL++) {
            int n = nextInt() + 2;
            int m = nextInt();
            int[] a = new int[n];
            for (int i = 1; i < n - 1; i++) {
                a[i] = nextInt();
            }
            a[n - 1] = m;
            boolean on = true;
            if (n % 2 == 1) on = false;
            int[] suf_on = new int[n];
            int[] suf_off = new int[n];
            for (int i = n - 2; i >= 0; i--) {
                suf_off[i] = suf_off[i + 1];
                suf_on[i] = suf_on[i + 1];
                if (on) {
                    suf_on[i] += a[i + 1] - a[i];
                } else {
                    suf_off[i] += a[i + 1] - a[i];
                }
                on = !on;
            }
            int ans = suf_on[0];
            on = true;
            int now = 0;
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, suf_on[i]);
                if (on) {
                    int can = a[i] - a[i - 1] - 1;
                    int plus = suf_on[i];
                    if (can > 0) ans = Math.max(ans, can + plus + now);
                    now += a[i] - a[i - 1];
                } else {
                    int plus = 0;
                    plus = suf_off[i];
                    int can = a[i] - a[i - 1] - 1;
                    if (can > 0) ans = Math.max(ans, can + plus + now);
                }
                on = !on;
            }
            out.println(ans);
        }
        out.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static StringTokenizer in = new StringTokenizer("");


    public static String next() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}

class Point {
    long i;
    long j;
    long x;

    public Point(long i, long j, long x) {
        this.i = i;
        this.j = j;
        this.x = x;
    }
}