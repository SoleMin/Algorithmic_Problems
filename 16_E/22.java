import java.io.*;
import java.math.*;
import java.util.*;


public class Main {

    InputReader input;
    PrintWriter output;

    void run(){
        output = new PrintWriter(new OutputStreamWriter(System.out));
        input = new InputReader(System.in);
        solve();
        output.flush();
    }

    public static void main(String[] args){
        new Main().run();
    }
    
    
    boolean isBitSet(int mask, int i) {
        return (mask&(1<<i)) != 0;
    }
    
    int unSet(int mask, int i) {
        return mask & ~(1<<i);
    }
    
    void solve() {
        int n = input.ni();
        double[][] prb = new double[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                prb[i][j] = input.readDouble();
            }
        }
        double[] dp = new double[1<<n];
        dp[0] = 1.0;
        for(int i = 0; i < 1<<n; i++) {
            int remaining = n-Integer.bitCount(i);
            double remainingProbability = remaining*(remaining-1)/2;
            for(int j = 0; j < n; j++) {
                if(!isBitSet(i, j)) {   //jth fish is alive
                    for(int k = 0; k < n; k++) {    //candidates to kill jth fish
                        if(!isBitSet(i, k))
                            dp[i|(1<<j)] += dp[i]*prb[k][j]/(remainingProbability);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            output.printf("%.7f ",dp[unSet((1<<n)-1, i)]);
        }
        output.println();
    }


    class InputReader {
        private boolean finished = false;
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
                this.stream = stream;
        }

        public int read() {
                if (numChars == -1)
                        throw new InputMismatchException();
                if (curChar >= numChars) {
                        curChar = 0;
                        try {
                                numChars = stream.read(buf);
                        } catch (IOException e) {
                                throw new InputMismatchException();
                        }
                        if (numChars <= 0)
                                return -1;
                }
                return buf[curChar++];
        }

        public int peek() {
                if (numChars == -1)
                        return -1;
                if (curChar >= numChars) {
                        curChar = 0;
                        try {
                                numChars = stream.read(buf);
                        } catch (IOException e) {
                                return -1;
                        }
                        if (numChars <= 0)
                                return -1;
                }
                return buf[curChar];
        }

        public int ni() {
                int c = read();
                while (isSpaceChar(c))
                        c = read();
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                int res = 0;
                do {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public long nl() {
                int c = read();
                while (isSpaceChar(c))
                        c = read();
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                long res = 0;
                do {
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
        }

        public String ns() {
                int c = read();
                while (isSpaceChar(c))
                        c = read();
                StringBuilder res = new StringBuilder();
                do {
                        res.appendCodePoint(c);
                        c = read();
                } while (!isSpaceChar(c));
                return res.toString();
        }

        public boolean isSpaceChar(int c) {
                if (filter != null)
                        return filter.isSpaceChar(c);
                return isWhitespace(c);
        }

        public boolean isWhitespace(int c) {
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
                StringBuilder buf = new StringBuilder();
                int c = read();
                while (c != '\n' && c != -1) {
                        if (c != '\r')
                                buf.appendCodePoint(c);
                        c = read();
                }
                return buf.toString();
        }

        public String readLine() {
                String s = readLine0();
                while (s.trim().length() == 0)
                        s = readLine0();
                return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
                if (ignoreEmptyLines)
                        return readLine();
                else
                        return readLine0();
        }

        public BigInteger readBigInteger() {
                try {
                        return new BigInteger(ns());
                } catch (NumberFormatException e) {
                        throw new InputMismatchException();
                }
        }

        public char readCharacter() {
                int c = read();
                while (isSpaceChar(c))
                        c = read();
                return (char) c;
        }

        public double readDouble() {
                int c = read();
                while (isSpaceChar(c))
                        c = read();
                int sgn = 1;
                if (c == '-') {
                        sgn = -1;
                        c = read();
                }
                double res = 0;
                while (!isSpaceChar(c) && c != '.') {
                        if (c == 'e' || c == 'E')
                                return res * Math.pow(10, ni());
                        if (c < '0' || c > '9')
                                throw new InputMismatchException();
                        res *= 10;
                        res += c - '0';
                        c = read();
                }
                if (c == '.') {
                        c = read();
                        double m = 1;
                        while (!isSpaceChar(c)) {
                                if (c == 'e' || c == 'E')
                                        return res * Math.pow(10, ni());
                                if (c < '0' || c > '9')
                                        throw new InputMismatchException();
                                m /= 10;
                                res += (c - '0') * m;
                                c = read();
                        }
                }
                return res * sgn;
        }

        public boolean eof() {
                int value;
                while (isSpaceChar(value = peek()) && value != -1)
                        read();
                return value == -1;
        }

        public String next() {
                return ns();
        }

        public SpaceCharFilter getFilter() {
                return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
                this.filter = filter;
        }
       
    }
     public interface SpaceCharFilter {
         public boolean isSpaceChar(int ch);
     }

}

