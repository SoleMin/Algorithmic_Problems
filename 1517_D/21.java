import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
public class Main{
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
        long[] nextArray(long n) {
            long[] a = new long[(int) n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static class FastWriter extends PrintWriter {
            FastWriter(){
                super(System.out);
            }
            void println(int[] array) {
                for(int i=0; i<array.length; i++) {
                    print(array[i]+" ");
                }
                println();
            }
            void println(long [] array) {
                for(int i=0; i<array.length; i++) {
                    print(array[i]+" ");
                }
                println();
            }
        }
    static int x,y;
    public static void main(String[] args){
        FastScanner in = new FastScanner();
        FastWriter out = new FastWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        int[][] right=new int[n][m-1];
        int[][] down=new int[n-1][m];
        for (int i = 0; i < n; i++) {
            right[i]=in.nextArray(m-1);
        }
        for (int i = 0; i < n - 1; i++) {
            down[i]=in.nextArray(m);
        }
        if(k%2!=0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print("-1 ");
                }
                out.println();
            }
        }else {
            int[][] dp=new int[n][m];
            int[][] dp1=new int[n][m];
            for (int i = 0; i < k / 2; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < m; l++) {
                        int ans=Integer.MAX_VALUE;
                        if(j>0){
                            ans=Math.min(ans,dp[j-1][l]+down[j-1][l]);
                        }
                        if(l>0){
                            ans=Math.min(ans,dp[j][l-1]+right[j][l-1]);
                        }
                        if(j!=n-1){
                            ans=Math.min(ans,dp[j+1][l]+down[j][l]);
                        }
                        if(l!=m-1){
                            ans=Math.min(ans,dp[j][l+1]+right[j][l]);
                        }
                        dp1[j][l]=ans;
                    }
                }
                dp=dp1;
                dp1=new int[n][m];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.println((2*dp[i][j])+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}