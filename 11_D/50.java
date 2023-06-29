
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 4 6
 * 1 2
 * 1 3
 * 1 4
 * 2 3
 * 2 4
 * 3 4
 *
 *
 *
 *
 *
 *
 * @author pttrung
 */
public class D {

    public static long [][]dp;
    public static boolean [][]map;

    public static void main(String[] args) {
        Scanner in = new Scanner();
        PrintWriter out = new PrintWriter(System.out);
//        int N = 19;
//        System.out.println(N + " " + ((N - 1) * N / 2));
//        for (int i = 1; i
//                <= N; i++) {
//            for (int j = i + 1; j <= N; j++) {
//                System.out.println(i + " " + j);
//            }
//        }
        int n = in.nextInt();
        int m = in.nextInt();
        dp = new long[n][1 << n + 1] ;

        map = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            map[a][b] = true;
            map[b][a] = true;
          
        }
        for(long []temp : dp){
            Arrays.fill(temp, -1);
        }
        long result = 0;
        for(int i = 0; i < n; i++){
            result += cal((1<<i),i,i,1);
        }
        out.println((result/2));

        out.close();
    }
    public static long cal(int mask, int from, int to, int len){
        if(dp[to][mask]!= -1){
            return dp[to][mask];
        }
        long result = 0;
        if(len > 2 && map[from][to]){
            result++;
        }
        for(int i = from+1; i< map.length; i++){
            if(map[to][i] && (mask & (1<<i)) == 0){
                result += cal(mask|(1<<i), from,i,len + 1);
            }
        }
        dp[to][mask] = result;
        return result;
        
    }
   

    public static class FT {

        int[] data;

        FT(int n) {
            data = new int[n];
        }

        public void update(int index, int value) {
            while (index < data.length) {
                data[index] += value;
                index += (index & (-index));
            }
        }

        public int get(int index) {
            int result = 0;
            while (index > 0) {
                result += data[index];
                index -= (index & (-index));
            }
            return result;

        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return val * val ;
        } else {
            return val * (val * a) ;
        }
    }

    static class Scanner {

        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {

            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}