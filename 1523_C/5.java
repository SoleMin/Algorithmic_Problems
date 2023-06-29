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


    static void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != 1) {
                while (!st.empty() && st.peek() + 1 != a[i])
                    st.pop();
                st.pop();
            }
            st.push(a[i]);
            for (int j = 0; j < st.size(); j++) {
                out.print(st.get(j));
                if (j < st.size() - 1)
                    out.print('.');
            }
            out.println();
        }

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
