/**
 * Created by Baelish on 6/18/2018.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class C_3 {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        long mod = (long) 1e9 + 7;

        long xx = in.nextLong(), kk = in.nextLong();

        if(xx == 0){
            pw.println(0); pw.close();
            return;
        }

        BigInteger x = BigInteger.valueOf(xx), k = BigInteger.valueOf(kk);

       // long a = bigMod(2, k+1, mod );long b = bigMod(2, k, mod);

        BigInteger MOD = BigInteger.valueOf(mod);
        BigInteger a = BigInteger.valueOf(2).modPow(BigInteger.valueOf(kk+1), MOD);
        BigInteger b = BigInteger.valueOf(2).modPow(BigInteger.valueOf(kk), MOD);


        BigInteger s = (a.multiply(x)).mod(MOD);
        s = s.subtract(b.mod(MOD));
        s = s.add(BigInteger.ONE);
        s = s.mod(MOD);
        s = s.add(MOD);
        s = s.mod(MOD);

       // debug(a, b, x);

       // long s = ((a * x) % mod - b % mod + 1 + mod) % mod;

        pw.println(s);


        pw.close();
    }


    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        static final int ints[] = new int[128];
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            for (int i = '0'; i <= '9'; i++) ints[i] = i - '0';
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

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
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
                    num = (num << 3) + (num << 1) + ints[b];
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
                    num = (num << 3) + (num << 1) + ints[b];
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
       /* public char nextChar() {
            return (char)skip();
        }*/

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        /*private char buff[] = new char[1005];
        public char[] nextCharArray(){
            int b = skip(), p = 0;
            while(!(isSpaceChar(b))){
                buff[p++] = (char)b;
                b = readByte();
            }
            return Arrays.copyOf(buff, p);
        }*/
    }
}