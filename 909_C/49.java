import java.io.*;
import java.util.*;

/*
TASK: CFC
LANG: JAVA
 */
public class CFC {
    static int n;
    static int[][] dp;
    static boolean[] s;
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in); //new FileInputStream(new File("CFC.in")));
        //PrintWriter out = new PrintWriter(new File("CFC.out"));
        n = in.nextInt();
        if(n == 1){
            System.out.println(1);
            return;
        }
        dp = new int[n][n+1];
        s = new boolean[n];
        for(int i = 0;i <n; i++)s[i] = in.next().equals("s");
        for(int j = 0;j < n; j++){
            if(s[n-2])dp[n-1][j] = j+1;
            else dp[n-1][j] = 1;
        }
        int suma , sumb;
        for(int i = n-2; i >= 0; i--){
            if(i == 0 ? true : s[i-1]){
                if(s[i]) {
                    for (int j = 0; j < n; j++) {
                        dp[i][j] = ((j == 0 ? 0 : dp[i][j - 1]) + dp[i + 1][j]) % 1000000007;
                    }
                }
                else{
                    for(int j = 0;j < n; j++){
                        dp[i][j] = ((j == 0 ? 0 : dp[i][j-1]) + dp[i+1][j+1]) % 1000000007;
                    }
                }
            }
            else{
                if(s[i]){
                    for(int j = 0;j < n; j++){
                        dp[i][j] = dp[i+1][j];
                    }
                }
                else{
                    for(int j = 0;j < n; j++){
                        dp[i][j] = dp[i+1][j+1];
                    }
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    private static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}