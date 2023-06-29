import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class Main {

    public static void deal(int n,int m,int k,int[][] d1,int[][] d2) {
        if(k % 2 == 1) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    System.out.print("-1 ");
                }
                System.out.println();
            }
            return;
        }
        int[][][] dp = new int[k/2+1][n][m];
        for(int i=0;i<k/2;i++) {
            for(int j=0;j<n;j++) {
                for(int l=0;l<m;l++) {
                    int min = Integer.MAX_VALUE;
                    if(j>0) min = Math.min(min,d2[j-1][l]+dp[i][j-1][l]);
                    if(j<n-1) min = Math.min(min,d2[j][l]+dp[i][j+1][l]);
                    if(l>0) min = Math.min(min,d1[j][l-1]+dp[i][j][l-1]);
                    if(l<m-1) min = Math.min(min,d1[j][l]+dp[i][j][l+1]);
                    dp[i+1][j][l] = min;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(dp[k/2][i][j]*2);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] d1 = new int[n][m-1];
        int[][] d2 = new int[n-1][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m-1;j++) {
                d1[i][j] = scanner.nextInt();
            }
        }
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<m;j++) {
                d2[i][j] = scanner.nextInt();
            }
        }
        deal(n,m,k,d1,d2);
    }
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
                while (st == null || !st.hasMoreElements()) {
                        try {
                                st = new StringTokenizer(br.readLine());
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                return st.nextToken();
        }
        
        int nextInt() {
                return Integer.parseInt(next());
        }
        
        long nextLong() {
                return Long.parseLong(next());
        }
        
        double nextDouble() {
                return Double.parseDouble(next());
        }
        
        String nextLine(){
                String str = "";
    try {
            str = br.readLine();
    } catch (IOException e) {
            e.printStackTrace();
    }
    return str;
        }
        
    }
}