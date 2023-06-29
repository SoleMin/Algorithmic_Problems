import java.util.*;
import java.lang.*;
import java.io.*;

// Created by @thesupremeone on 23/04/21
public class ExplorerSpace {
    int[][] horizontal, vertical;
    int n, m;
    long[][][] dp;
    int large = Integer.MAX_VALUE;

    boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }

    long getMin(int i, int j, int k){
        if(k==0)
            return 0;
        if(dp[i][j][k]!=-1)
            return dp[i][j][k];
        long ans = large;
        for (int a = 0; a < 2; a++) {
            for (int d = 0; d < 2; d++) {
                int dx = a==0 ? (d==0 ? +1 : -1) : 0;
                int dy = a==1 ? (d==0 ? +1 : -1) : 0;
                int x = i+dx;
                int y = j+dy;
                if(isValid(x, y)){
                    if(dx==0){
                        ans = Math.min(horizontal[i][Math.min(j, y)]+getMin(x, y, k-1), ans);
                    }else {
                        ans = Math.min(vertical[Math.min(i, x)][j]+getMin(x, y, k-1), ans);
                    }
                }
            }
        }
        dp[i][j][k] = ans;
        return ans;
    }

    void solve() throws IOException {
        n = getInt();
        m = getInt();
        dp = new long[n+1][m+1][11];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                for (int k = 0; k < 11; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int k = getInt();
        horizontal = new int[n][m-1];
        vertical = new int[n-1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                horizontal[i][j] = getInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                vertical[i][j] = getInt();
            }
        }
        if(k%2!=0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    print("-1 ");
                }
                println("");
            }
        }else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long ans = 2*getMin(i, j, k/2);
                    print(ans+" ");
                }
                println("");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (isOnlineJudge()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            new ExplorerSpace().solve();
            out.flush();
        } else {
            Thread judge = new Thread();
            in = new BufferedReader(new FileReader("input.txt"));
            out = new BufferedWriter(new FileWriter("output.txt"));
            judge.start();
            new ExplorerSpace().solve();
            out.flush();
            judge.suspend();
        }
    }
    static boolean isOnlineJudge(){
        try {
            return System.getProperty("ONLINE_JUDGE")!=null
                    || System.getProperty("LOCAL")==null;
        }catch (Exception e){
            return true;
        }
    }
    // Fast Input & Output
    static BufferedReader in;
    static StringTokenizer st;
    static BufferedWriter out;
    static String getLine() throws IOException{
        return in.readLine();
    }
    static String getToken() throws IOException{
        if(st==null || !st.hasMoreTokens())
            st = new StringTokenizer(getLine());
        return st.nextToken();
    }
    static int getInt() throws IOException {
        return Integer.parseInt(getToken());
    }
    static long getLong() throws IOException {
        return Long.parseLong(getToken());
    }
    static void print(Object s) throws IOException{
        out.write(String.valueOf(s));
    }
    static void println(Object s) throws IOException{
        out.write(String.valueOf(s));
        out.newLine();
    }
}