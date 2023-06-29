import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.awt.Point;

public class CodeForces {
    static boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private final long MOD = 1000000009;

    long power(long a, long b)
    {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= a;
                if (res >= MOD)
                    res %= MOD;
            }
            a *= a;
            if (a >= MOD)
                a %= MOD;
            b >>= 1;
        }
        return res;
    }

    void runCase(int caseNum) throws IOException {
        long n = nextLong();
        long m = nextLong();
        long k = nextLong();

        if (n - m >= n / k) {
            System.out.println(m);
            return;
        }
        long res = 0;
        long rem = (k - 1) * (n - m);
        m -= rem;
        long bound = m / k;
        res = (power(2, bound + 1) + MOD - 2) % MOD;
        res *= k;
        res %= MOD;
//        for (long i = 0; i < bound; ++i) {
//            res += k;
//            res <<= 1;
//            if (res >= MOD)
//                res %= MOD;
//        }
        res += rem;
        res += m % k;
        res %= MOD;
        System.out.println(res);
    }


    public static void main(String[] args) throws IOException {
        if (ONLINE_JUDGE){
            System.out.println();
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }else{
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(System.out);
            //out = new PrintWriter("output.txt");
        }
        new CodeForces().runIt();
        out.flush();
        out.close();
        return;
    }

    static BufferedReader in;
    private StringTokenizer st;
    static PrintWriter out;

    static int pos;
    static String curInput = "";

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }


    void runIt() throws IOException {
        st = new StringTokenizer("");

//        int N = nextInt();
//        for (int i = 0; i < N; i++) {
//            runCase(i + 1);
//        }
        runCase(0);
        out.flush();
    }

}
