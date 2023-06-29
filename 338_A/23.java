import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Date: 23.06.13 at 15:29
 *
 * @author Nickolay Polyarniy aka PolarNick
 */
public class ProblemA {

    private static long MOD = 1000000009;

    public void solve() throws Exception {
        long n = nextInt();
        long m = nextInt();
        long k = nextInt();
        long tmp = 1024 * 1024;
        long res = 0;

        long nTmp = n;
        long mTmp = m;
        while (tmp > 0) {
            while (mTmp >= (k - 1) * tmp && nTmp - k * tmp >= mTmp - (k - 1) * tmp) {
                nTmp -= k * tmp;
                mTmp -= (k - 1) * tmp;
//                res = (res + (k - 1) * tmp) % MOD;
            }
            tmp /= 2;
        }
        long fullC = mTmp / k;
//        out.println("mTmp=" + mTmp + "Full: " + fullC);

        long pow2 = getPow(2, fullC + 1, MOD);
        res = (((res + pow2 + MOD - 2) % MOD) * k) % MOD;

//        out.println("After full: " + res);

        mTmp = mTmp % k;
        res = (res + mTmp) % MOD;

        nTmp = n;
        mTmp = m - fullC * k - mTmp;
        tmp = 1024 * 1024;
        while (tmp > 0) {
            while (mTmp >= (k - 1) * tmp && nTmp - k * tmp >= mTmp - (k - 1) * tmp) {
                nTmp -= k * tmp;
                mTmp -= (k - 1) * tmp;
                res = (res + (k - 1) * tmp) % MOD;
            }
            tmp /= 2;
        }
        out.println(res);
    }

    static long[] pows = new long[1000000];

    public static long getPow(long base, long pow, long mod) {
        if (pow < pows.length && pows[(int) pow] != 0) {
            return pows[(int) pow];
        }
        if (pow == 0) {
            pows[0] = 1;
            return 1;
        }
        if (pow == 1) {
            pows[1] = base;
            return base;
        }
        long res = getPow(base, pow / 2, mod);
        res = (res * res) % mod;
        res = (res * getPow(base, pow % 2, mod)) % mod;
        if (pow < pows.length) {
            pows[(int) pow] = res;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        ProblemA problem = new ProblemA();
        problem.solve();
        problem.close();
    }

    BufferedReader in;
    PrintWriter out;
    String curLine;
    StringTokenizer tok;
    final String delimeter = " ";
    final String endOfFile = "";

    public ProblemA(BufferedReader in, PrintWriter out) throws Exception {
        this.in = in;
        this.out = out;
        curLine = in.readLine();
        if (curLine == null || curLine == endOfFile) {
            tok = null;
        } else {
            tok = new StringTokenizer(curLine, delimeter);
        }
    }

    public ProblemA() throws Exception {
        this(new BufferedReader(new InputStreamReader(System.in)),
                new PrintWriter(System.out));
    }

    public ProblemA(String filename) throws Exception {
        this(new BufferedReader(new FileReader(filename + ".in")),
                new PrintWriter(filename + ".out"));
    }

    public boolean hasMore() throws Exception {
        if (tok == null || curLine == null) {
            return false;
        } else {
            while (!tok.hasMoreTokens()) {
                curLine = in.readLine();
                if (curLine == null || curLine.equalsIgnoreCase(endOfFile)) {
                    tok = null;
                    return false;
                } else {
                    tok = new StringTokenizer(curLine);
                }
            }
            return true;
        }
    }

    public String nextWord() throws Exception {
        if (!hasMore()) {
            return null;
        } else {
            return tok.nextToken();
        }
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextWord());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextWord());
    }

    public int[] readIntArray(int n) throws Exception {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public void close() throws Exception {
        in.close();
        out.close();
    }

}
