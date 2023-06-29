import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeSet;

public class r568p8{

    private static InputReader sc;
    private static PrintWriter pw;
    private static long mod;

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        InputReader(InputStream stream) {
            this.stream = stream;
        }

        int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) {
        sc = new InputReader(System.in);
        pw = new PrintWriter(System.out);

        int t = 1;
        while(t-->0)
            solve();

        pw.flush();
        pw.close();
    }

    private static void fill_matrix(long dp[][][][], int a, int b, int c, int end){

        if((a == 0 && b == 0 && c == 0) || (a == 0 && end == 0) || (b == 0 && end == 1) || (c == 0 && end == 2)){
            dp[a][b][c][end] = 0;
            return;
        }

        if(a > 1 && b == 0 && c == 0){
            dp[a][b][c][end] = 0;
            return;
        }

        if(b > 1 && a == 0 && c == 0){
            dp[a][b][c][end] = 0;
            return;
        }

        if(c > 1 && a == 0 && b == 0){
            dp[a][b][c][end] = 0;
            return;
        }

        if(a == 1 && end == 0 && b == 0 && c == 0){
            dp[a][b][c][end] = 1;
            return;
        }
        if(b == 1 && end == 1 && a == 0 && c == 0){
            dp[a][b][c][end] = 1;
            return;
        }
        if(c == 1 && end == 2 && b == 0 && a == 0){
            dp[a][b][c][end] = 1;
            return;
        }

        if(end == 0){
            fill_matrix(dp, a-1, b, c, 1);
            fill_matrix(dp, a-1, b, c, 2);

            dp[a][b][c][0] = (dp[a-1][b][c][1]%mod + dp[a-1][b][c][2]%mod)%mod;
        }
        else if(end == 1){
            fill_matrix(dp, a, b-1, c, 0);
            fill_matrix(dp, a, b-1, c, 2);

            dp[a][b][c][1] = (dp[a][b-1][c][0]%mod + dp[a][b-1][c][2]%mod)%mod;
        }
        else{
            fill_matrix(dp, a, b, c-1, 0);
            fill_matrix(dp, a, b, c-1, 1);

            dp[a][b][c][2] = (dp[a][b][c-1][0]%mod + dp[a][b][c-1][1]%mod)%mod;
        }
    }

    private static long cal(int count[]){
        int a = count[0], b = count[1], c = count[2];
        long dp[][][][] = new long[a+1][b+1][c+1][3];

        long factorial[] = new long[20];

        factorial[0] = 1;
        factorial[1] = 1;

        for(int i=2; i<20; i++)
            factorial[i] = (factorial[i-1]%mod*i%mod)%mod;

        fill_matrix(dp, a, b, c, 0);
        fill_matrix(dp, a, b, c, 1);
        fill_matrix(dp, a, b, c, 2);

         long p = (dp[a][b][c][0]%mod + dp[a][b][c][1]%mod + dp[a][b][c][2]%mod)%mod;

         long ans = (((p%mod * factorial[a]%mod)%mod * factorial[b]%mod)%mod * factorial[c]%mod)%mod;

         return ans;
    }

    private static void solve(){
        int n = sc.nextInt(), T = sc.nextInt();

        int len[] = new int[n], genre[] = new int[n];

        for(int i=0; i<n; i++){
            len[i] = sc.nextInt();
            genre[i] = sc.nextInt();
        }

        int sum[] = new int[(1<<n)];

        mod = (long)1e9 + 7;
        long ans = 0;

        for(int i=1; i<(1<<n); i++){
            for(int j=0; j<15; j++){
                if((i&(1<<j)) != 0){
                    sum[i] = sum[i^(1<<j)] + len[j];
                    break;
                }
            }

            if(sum[i] == T) {
                int count[] = {0, 0, 0};

                for (int j = 0; j < 15; j++) {
                    if ((i & (1 << j)) != 0)
                        count[genre[j] - 1]++;
                }

                ans = (ans % mod + cal(count) % mod) % mod;
            }
        }

        pw.println(+ans);
    }
}