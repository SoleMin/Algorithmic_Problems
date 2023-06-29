import java.io.*;
import java.util.*;

public class C {

    MyScanner in;
    PrintWriter out;

    public static void main(String[] args) throws Exception {
        new C().run();
    }

    public void run() throws Exception {
        in = new MyScanner();
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    public void solve() throws Exception {
        int n = in.nextInt();
        char[] a = in.next().toCharArray();
        int h = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'H') h++;
        }
        char[] b = new char[2 * a.length - 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i % a.length];
        }
        int maxh = 0;
        int hh = 0;
        for (int i = 0; i < b.length - h; i++) {
            hh = 0;
            for (int j = 0; j < h; j++) {
                if (b[i + j] == 'H') hh++;
            }
            maxh = Math.max(maxh, hh);
        }
        /*for (int i = 0; i < b.length; i++) {
            out.print(b[i]);
        }
        out.println();*/
        //out.println(h + " " + maxh);
        out.println(h - maxh);
    }
    class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() throws Exception {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            if ((st == null) || (!st.hasMoreTokens())) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        boolean nextBoolean() throws Exception {
            return Boolean.parseBoolean(next());
        }

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }
    }
}

