import java.io.*;
import java.util.*;

/*
polyakoff
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int oo = (int) 1e9 + 10;
    static final long OO = (long) 1e18 + 10;
    static final int MOD = (int) 1e9 + 7;

    static boolean isSq(int x) {
        int sq = (int) Math.sqrt(x);
        return sq * sq == x;
    }

    static void solve() {
        int n = in.nextInt();
        if ((n % 2 == 0 && isSq(n / 2)) || (n % 4 == 0 && isSq(n / 4)))
            out.println("YES");
        else
            out.println("NO");

    }

    public static void main(String[] args) {
        in = new FastReader();
        out = new PrintWriter(System.out);

        int t = 1;
        t = in.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            this(System.in);
        }
        FastReader(String file) throws FileNotFoundException {
            this(new FileInputStream(file));
        }
        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }
        String nextLine() {
            String line;
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
    }
}
