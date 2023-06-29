//      これを翻訳している間、あなたはあなたの人生のいくつかの貴重な瞬間を無駄にしました


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    static PrintWriter fop = new PrintWriter(System.out);

    static int counter(String s){
        int cnt = 0 ;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '(')cnt++ ;
            else  cnt-- ;
            if (cnt < 0)return -1 ;
        }
        return cnt ;

    }

    static int counter2(String s){
        int cnt = 0 ;
     for(int i = s.length()-1 ; i>=0 ; i--){
         if (s.charAt(i) == ')')cnt++ ;
         else cnt-- ;
         if (cnt < 0)return -1 ;
     }
     return cnt ;

    }






    public static void main(String[] args) {

        FastScanner fsca = new FastScanner();
        int n = fsca.nextInt() ;
        String a[] = new String[n] ;
        for (int i = 0; i <n ; i++) {
            a[i] = fsca.next() ;
        }

        int dp[] = new int[400009] ;
        for (int i = 0; i <n ; i++) {
           int tt = counter(a[i]) ;
           if (tt != -1)
               dp[tt]++ ;
        }
        long cnt = 0 ;
        for (int i = 0; i <n ; i++) {
            int tt = counter2(a[i]) ;
            if (tt != -1){
                cnt += dp[tt] ;
            }
        }
        System.out.println(cnt);











        fop.flush();
        fop.close();


    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------*/


    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    static final Random random = new Random();

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }


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

        int[][] readMat(int n, int m) {
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    a[i][j] = nextInt();
            return a;
        }

        char[][] readCharMat(int n, int m) {
            char a[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = next();
                for (int j = 0; j < m; j++)
                    a[i][j] = s.charAt(j);
            }
            return a;
        }


        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static void print(int a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }

    static void print(long a[], int n) {
        for (int i = 0; i < n; i++)
            fop.append((a[i]) + " ");
        // fop.append("\n") ;
    }
}
        