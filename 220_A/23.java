
import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class A {
    public void run() throws IOException {
        final int n = IOFast.nextInt();
        int[] xs = new int[n];
        for(int i = 0; i < n; i++) {
            xs[i] = IOFast.nextInt();
        }
        int[] ys = xs.clone();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            final int j = random.nextInt(i + 1);
            final int t = ys[j]; ys[j] = ys[i]; ys[i] = t;
        }
        Arrays.sort(ys);
        
        int diff = 0;
        for(int i = 0; i < ys.length; i++) {
            if(xs[i] != ys[i]) {
                diff++;
            }
        }
        
        IOFast.out.println(diff > 2 ? "NO" : "YES");
    }
    
    public static void main(String[] args) throws IOException {
        new A().run();
        IOFast.out.flush();
    }

    static public class IOFast {
        private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        private static PrintWriter out = new PrintWriter(System.out);

//      private static final int BUFFER_SIZE = 50 * 200000;
        private static int pos, readLen;
        private static final char[] buffer = new char[1024 * 8];
        private static final StringBuilder buf = new StringBuilder();
        private static boolean[] isDigit = new boolean[256];
        private static boolean[] isSpace = new boolean[256];

        static {
            for(int i = 0; i < 10; i++) {
                isDigit['0' + i] = true;
            }
            isDigit['-'] = true;
            isSpace[' '] = isSpace['\r'] = isSpace['\n'] = isSpace['\t'] = true;
        }
        
        static boolean endInput;
        
        private static int read() throws IOException {
            if(readLen == -1) {
                return -1;
            }
            
            if(pos >= readLen) {
                readLen = in.read(buffer);
                pos = 0;
                
                if(readLen <= 0) {
                    return -1;
                }
            }
            
            return buffer[pos++];
        }

        private static int nextInt() throws IOException {
            boolean plus = false;
            int ret = 0;
            while(true) {
                final int c = read();
                
                if(c == -1) {
                    endInput = true;
                    return Integer.MIN_VALUE;
                }
                
                if(isDigit[c]) {
                    if(c != '-') {
                        plus = true;
                        ret = c - '0';
                    }
                    break;
                }
            }
            
            while(true) {
                final int c = read();
                if(c == -1 || !isDigit[c]) {
                    break;
                }
                ret = ret * 10 + c - '0';
            }
            
            return plus ? ret : -ret;
        }
        
        private static long nextLong() throws IOException {
            boolean plus = false;
            long ret = 0;
            while(true) {
                final int c = read();
                
                if(c == -1) {
                    endInput = true;
                    return Integer.MIN_VALUE;
                }
                
                if(isDigit[c]) {
                    if(c != '-') {
                        plus = true;
                        ret = c - '0';
                    }
                    break;
                }
            }
            
            while(true) {
                final int c = read();
                if(c == -1 || !isDigit[c]) {
                    break;
                }
                ret = ret * 10 + c - '0';
            }
            
            return plus ? ret : -ret;
        }

        private static char nextChar() throws IOException {
            while(true) {
                final int c = read();
                
                if(c == -1) {
                    endInput = true;
                    return '\0';
                }
                
                if(!isSpace[c]) {
                    return (char)c;
                }
            }
        }

        private static int next(char[] cs) throws IOException {
            int n = 0;
            while(true) {
                final int c = read();
                
                if(c == -1) {
                    endInput = true;
                    return n;
                }
                
                if(!isSpace[c]) {
                    cs[n++] = (char)c;
                    break;
                }
            }
            
            while(true) {
                final int c = read();
                
                if(c == -1 || isSpace[c]) {
                    break;
                }
                cs[n++] = (char)c;
            }
            
            return n;
        }

        private static String next() throws IOException {
            buf.setLength(0);

            while(true) {
                final int c = read();
                
                if(c == -1) {
                    endInput = true;
                    return "-1";
                }
                
                if(!isSpace[c]) {
                    buf.append((char)c);
                    break;
                }
            }
            
            while(true) {
                final int c = read();
                
                if(c == -1 || isSpace[c]) {
                    break;
                }
                buf.append((char)c);
            }

            return buf.toString();
        }

        private static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

    }

}
