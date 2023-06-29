
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.util.Arrays.*;

public class A {
    private static final int mod = (int)1e9+9;

    final IOFast io = new IOFast();
    
    long k;
    
    long rec(long n, long m, long cur) {
        long pow = 1;
        long margin = 10;
        long p = 1000;
        for(int i = 0; i < p; i++) pow = pow * 2 % mod;
        while(true) {
            if(n + 1 >= (m / (k - 1) * k + m % (k - 1)) || m < k) { return (m + cur) % mod; }
            long q = (p + margin) * k;
            if(n - q + 1 < ((m - q) / (k - 1) * k + (m - q) % (k - 1)) && m >= q) {
                n -= p * k;
                m -= p * k;
                cur = cur * pow % mod;
                cur += (pow - 1) * 2 * k % mod;
                cur %= mod;
                continue;
            }
            n -= k;
            m -= k;
            cur += k;
            cur = cur * 2 % mod;
//          System.err.println(cur);
        }
    }
    
    public void run() throws IOException {
        long n = io.nextLong();
        long m = io.nextLong();
        k = io.nextLong();
//      io.out.println(rec(n, m, 0));
//      if(true) return;
        
        long low = -1, high = m / k + 1;
        while(high - low > 1) {
            long mid = (low + high) / 2;
            long u = mid * k;
            if(m < u) { high = mid; continue; }
            long val = u;
            val += (m - u) / (k - 1) * k;
            if((m - u) % (k - 1) == 0) val -= 1;
            else val += (m - u) % (k - 1);
            
            if(val > n) {
                low = mid;
            }
            else {
                high = mid;
            }
//          System.err.println(mid + " " + (u + (m - u - k) / (k - 1) * k + k - 1 + (m - u) % (k - 1)) + " " + n);
        }

        long pow = powmod(2, high, mod);
        long score = m - high * k;
        score = (score + (pow - 1) * 2 * k) % mod;
        io.out.println(score);
    }

    
    static long powmod(long n, long r, int m) {
        long res = 1;
        for(; r != 0; r >>>= 1, n = n * n % m) {
            if((r&1) == 1) {
                res = res * n;
                if(res >= m) {
                    res %= m;
                }
            }
        }
        return res;
    }

    void main() throws IOException {
        //      IOFast.setFileIO("rle-size.in", "rle-size.out");
        try {
            run();
        }
        catch (EndOfFileRuntimeException e) { }
        io.out.flush();
    }

    public static void main(String[] args) throws IOException {
        new A().main();
    }
    
    static class EndOfFileRuntimeException extends RuntimeException {
        private static final long serialVersionUID = -8565341110209207657L; }

    static
    public class IOFast {
        private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        private PrintWriter out = new PrintWriter(System.out);

        void setFileIO(String ins, String outs) throws IOException {
            in = new BufferedReader(new FileReader(ins));
            out = new PrintWriter(new FileWriter(outs));
        }

        //      private static final int BUFFER_SIZE = 50 * 200000;
        private static int pos, readLen;
        private static final char[] buffer = new char[1024 * 8];
        private static final char[] str = new char[500000*8*2];
        private static boolean[] isDigit = new boolean[256];
        private static boolean[] isSpace = new boolean[256];
        private static boolean[] isLineSep = new boolean[256];

        static {
            for(int i = 0; i < 10; i++) { isDigit['0' + i] = true; }
            isDigit['-'] = true;
            isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
            isLineSep['\r'] = isLineSep['\n'] = true;
        }

        public int read() throws IOException {
            if(pos >= readLen) {
                pos = 0;
                readLen = in.read(buffer);
                if(readLen <= 0) { throw new EndOfFileRuntimeException(); }
            }
            return buffer[pos++];
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }

        public char nextChar() throws IOException {
            while(true) {
                final int c = read();
                if(!isSpace[c]) { return (char)c; }
            }
        }
        
        int reads(char[] cs, int len, boolean[] accept) throws IOException {
            try {
                while(true) {
                    final int c = read();
                    if(accept[c]) { break; }
                    str[len++] = (char)c;
                }
            }
            catch(EndOfFileRuntimeException e) { ; }
            
            return len;
        }

        public char[] nextLine() throws IOException {
            int len = 0;
            str[len++] = nextChar();
            len = reads(str, len, isLineSep);
            
            try {
                if(str[len-1] == '\r') { len--; read(); }
            }
            catch(EndOfFileRuntimeException e) { ; }
            
            return Arrays.copyOf(str, len);
        }

        public String nextString() throws IOException {
            return new String(next());
        }

        public char[] next() throws IOException {
            int len = 0;
            str[len++] = nextChar();
            len = reads(str, len, isSpace);
            return Arrays.copyOf(str, len);
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextString());
        }

    }

}
