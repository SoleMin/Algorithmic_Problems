import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class E {
    public static void main(String[] args) throws Exception {
        new Thread(null ,new Runnable(){
            public void run(){
                try{solveIt();} catch(Exception e){e.printStackTrace(); System.exit(1);}
            }
        },"Main",1<<28).start();
    }

    static int dp[][], a[][], rows, cols;

    public static void solveIt() throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            rows = in.nextInt();
            cols = in.nextInt();
            dp = new int[cols][1 << rows];
            for (int x[] : dp) Arrays.fill(x, -1);
            a = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    a[j][i] = in.nextInt();
                }
            }
            debug(a);
            pw.println(solve(0, 0));
        }

        pw.close();
    }

    static int solve(int pos, int mask) {
        if (pos >= cols) return 0;
        if (dp[pos][mask] != -1) return dp[pos][mask];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < (1 << rows); k++) {
                if ((mask & k) != 0) continue;
                int sum = 0;
                for (int bit = 0; bit < rows; bit++) {
                    if (check(k, bit)) sum += a[pos][bit];
                }
                res = max(res, sum + solve(pos + 1, mask | k));
            } 
            cyclicShift(pos);
        }
        return dp[pos][mask] = res;
    }

    static boolean check(int N, int pos) {
        return (N & (1 << pos)) != 0;
    }

    static void cyclicShift(int col) {
        int m = a[col].length;
        int last = a[col][m - 1];
        for (int i = m - 1; i >= 1; i--) {
            a[col][i] = a[col][i - 1];
        }
        a[col][0] = last;
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }


        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}