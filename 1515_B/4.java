//2021 global14

// jzzhao

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
       
        int tc = sc.ni();
        for (int rep = 0; rep < tc; rep++) {
            pw.println(solve(sc,pw));
            //solve(sc,pw);
        }
        
        
        pw.close();
    }
    /*

    FS Methods:

    - next(): next element in string
    - nextLine(): nextline in string
    - ni(): next Integer
    - nd(): next Double
    - nl(): next Long
    - intArray(n): 
    - longArray(n): 
    - to2di(m,n):
    - to2dl(m,n):



    */

          
    public static String solve(FastScanner sc, PrintWriter pw) {

        int n = sc.ni();

        long cur1 = 2;
        long cur2 = 4;

        long block = 2;
        long block2 = 4;

        int tmp = 3;

        while(cur1<=n||cur2<=n){
            if(cur1==n||cur2==n){
                return "YES";
            }
            if(cur1<n){
                cur1+=block*tmp;

            }
            if(cur2<n){
                cur2+=block2*tmp;
            }
            tmp+=2;

        }
        return "NO";


        //return "NO";


    }

    /*
        - The following are helping method so pls do not do anything to them.
    
    */

    // public static int[][] to2d(Scanner scanner, int m, int n){
    //     int[][] ans = new int[m][n];
    //     for(int i = 0;i<m;i++){
    //         String[] r = scanner.nextLine().split("[ ]");
    //         for(int j = 0;j<n;j++){
    //             ans[i][j] = stoi(r[j]);
    //         }
    //     }
    //     return ans;
    // }

    // public static int[] toArray(Scanner scanner, int m){
    //     int[] ans = new int[m];
    //     String[] r = scanner.nextLine().split("[ ]");
    //     for(int i = 0;i<m;i++){
    //         ans[i] = stoi(r[i]);
    //     }
        
    //     return ans;
    // }

    public static void printArr(PrintWriter pw,int[] a){
        for(int i = 0;i<a.length;i++){
            pw.print(a[i]);
            if(i!=a.length-1){
                pw.print(" ");
            }
        }
        pw.println();
    }

    public static void print2d(PrintWriter pw,int[][] a){
        for(int j=0;j<a.length;j++){
            for(int i = 0;i<a[j].length;i++){
                pw.print(a[j][i]);
                if(i!=a[j].length-1){
                    pw.print(" ");
                }
            }
            pw.println(" ");
        }
        pw.println();
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b; 
        return gcd(b % a, a); 
    }
    static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}

class FastScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in), 32768);
        st = null;
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
 
    int ni() {
        return Integer.parseInt(next());
    }
 
    int[] intArray(int N) {
        int[] ret = new int[N];
        for (int i = 0; i < N; i++)
            ret[i] = ni();
        return ret;
    }

    int[][] to2di(int m, int n){
        int[][] ans = new int[m][n];
        for(int i = 0;i<m;i++){
            String[] r = nextLine().split("[ ]");
            for(int j = 0;j<n;j++){
                ans[i][j] = Integer.parseInt(r[j]);
            }
        }
        return ans;
    }

    long[][] to2dl(int m, int n){
        long[][] ans = new long[m][n];
        for(int i = 0;i<m;i++){
            String[] r = nextLine().split("[ ]");
            for(int j = 0;j<n;j++){
                ans[i][j] = Long.parseLong(r[j]);
            }
        }
        return ans;
    }
 
    long nl() {
        return Long.parseLong(next());
    }
 
    long[] longArray(int N) {
        long[] ret = new long[N];
        for (int i = 0; i < N; i++)
            ret[i] = nl();
        return ret;
    }
 
    double nd() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
