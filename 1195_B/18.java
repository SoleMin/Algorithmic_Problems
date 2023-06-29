import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        n = sc.nextInt();
        k = sc.nextInt();
        long l = 0;
        long r = n + 1;
        while (l + 1 != r) {
            long m = (r + l) / 2;
            if (check(m))
                l = m;
            else
                r = m;
        }
        pw.print(l * (l + 1L) / 2L - k);
        pw.close();
    }

    public static boolean check(long m) {
        return m * (m + 1) / 2 - (n - m) <= k;
    }
}

class FastScanner {
    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}