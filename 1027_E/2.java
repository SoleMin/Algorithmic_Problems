import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyInput in = new MyInput(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        static final int mod = 998244353;

        public void solve(int testNumber, MyInput in, PrintWriter out) {
            int n = in.nextInt();
            int K = in.nextInt();

            long[][] dp = new long[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= i && k <= j; k++) {
                        dp[i][j] += dp[i][j - k];
                        if (dp[i][j] >= mod) dp[i][j] -= mod;
                    }
                }
            }

            long ans = 0;
            long[][] dp2 = new long[n + 1][n + 1];
            for (int i = 1; i <= n; i++)
                if (i < K) {
                    for (long[] d : dp2) Arrays.fill(d, 0L);
                    dp2[0][0] = ((dp[i][n] - dp[i - 1][n]) * 2 % mod + mod) % mod;
                    for (int j = 1; j <= n; j++) {
                        for (int k = 1; k <= j; k++) {
                            if (k * i < K) {
                                dp2[j][k] += dp2[j - 1][k - 1];
                                if (dp2[j][k] >= mod) dp2[j][k] -= mod;
                            }
                            if (j > 1) {
                                dp2[j][1] += dp2[j - 1][k - 1];
                                if (dp2[j][1] >= mod) dp2[j][1] -= mod;
                            }
                        }
                    }
//            dump(i, dp2);
                    for (int k = 1; k <= n; k++) {
                        ans += dp2[n][k];
                    }
                }

            out.println((ans % mod + mod) % mod);
        }

    }

    static class MyInput {
        private final BufferedReader in;
        private static int pos;
        private static int readLen;
        private static final char[] buffer = new char[1024 * 8];
        private static char[] str = new char[500 * 8 * 2];
        private static boolean[] isDigit = new boolean[256];
        private static boolean[] isSpace = new boolean[256];
        private static boolean[] isLineSep = new boolean[256];

        static {
            for (int i = 0; i < 10; i++) {
                isDigit['0' + i] = true;
            }
            isDigit['-'] = true;
            isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
            isLineSep['\r'] = isLineSep['\n'] = true;
        }

        public MyInput(InputStream is) {
            in = new BufferedReader(new InputStreamReader(is));
        }

        public int read() {
            if (pos >= readLen) {
                pos = 0;
                try {
                    readLen = in.read(buffer);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (readLen <= 0) {
                    throw new MyInput.EndOfFileRuntimeException();
                }
            }
            return buffer[pos++];
        }

        public int nextInt() {
            int len = 0;
            str[len++] = nextChar();
            len = reads(len, isSpace);
            int i = 0;
            int ret = 0;
            if (str[0] == '-') {
                i = 1;
            }
            for (; i < len; i++) ret = ret * 10 + str[i] - '0';
            if (str[0] == '-') {
                ret = -ret;
            }
            return ret;
        }

        public char nextChar() {
            while (true) {
                final int c = read();
                if (!isSpace[c]) {
                    return (char) c;
                }
            }
        }

        int reads(int len, boolean[] accept) {
            try {
                while (true) {
                    final int c = read();
                    if (accept[c]) {
                        break;
                    }
                    if (str.length == len) {
                        char[] rep = new char[str.length * 3 / 2];
                        System.arraycopy(str, 0, rep, 0, str.length);
                        str = rep;
                    }
                    str[len++] = (char) c;
                }
            } catch (MyInput.EndOfFileRuntimeException e) {
            }
            return len;
        }

        static class EndOfFileRuntimeException extends RuntimeException {
        }

    }
}

