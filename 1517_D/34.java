//Template with FastScanner

// jzzhao

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
       
        //int tc = sc.ni();
        int tc = 1;
        for (int rep = 0; rep < tc; rep++) {
            solve(sc,pw);
            //pw.println(solve(sc,pw));
           
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

          
    public static void solve(FastScanner sc, PrintWriter pw) {

        int n = sc.ni();
        int m = sc.ni();
        int k = sc.ni();

        int[][] arr = sc.to2di(n,m-1); 
        int[][] arr2 = sc.to2di(n-1,m); 
        
        if(k%2==1){
            String s ="";
            for(int j = 0;j<m;j++){
                s+="-1";
                if(j!=m-1){
                    s+=" ";
                }
            }
            for(int i = 0;i<n;i++){
                pw.println(s);
            }
            return;
        }

        
        Integer[][][] dp = new Integer[n][m][k+1];

        // edge info
        // for(int i= 0;i<n;i++){
        //     for(int j = 0;j<m-1;j++){
                
        //         int l = i*1000+j;
        //         int r = i*1000+j+1;
        //         String cur = l+" "+r;
        //         String cur2 = r+" "+l;
        //         map.put(cur,arr[i][j]);
        //         map.put(cur2,arr[i][j]);
                
        //     }
        // }

        // for(int i= 0;i<n-1;i++){
        //     for(int j = 0;j<m;j++){
                
        //         int l = i*1000+j;
        //         int r = (i+1)*1000+j;
        //         String cur = l+" "+r;
        //         String cur2 = r+" "+l;
        //         map.put(cur,arr2[i][j]);
        //         map.put(cur2,arr2[i][j]);
                
        //     }
        // }

        //dp fill

        for(int i= 0;i<n;i++){
            for(int j = 0;j<m;j++){
                
                fill(dp,i,j,k,n,m,arr,arr2);
                
            }
        }

        for(int i= 0;i<n;i++){
            String s = "";
            for(int j = 0;j<m;j++){
                
                s+=dp[i][j][k];
                if(j!=m-1){
                    s+=" ";
                }
                
            }
            pw.println(s);
        }

        



    }

    public static int fill(Integer[][][] dp, int x, int y, int k, int n,int m,int[][] arr, int[][] arr2){
        
        

        if(dp[x][y][k]!=null){
            return dp[x][y][k];
        }

        if(k==0){
            dp[x][y][k]= 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;

        

        if(x>0){
            

            int curVal = 2*arr2[x-1][y]+fill(dp,x-1,y,k-2,n,m,arr,arr2);
            min = Math.min(min,curVal);
        }

        if(y>0){
            
            int curVal = 2*arr[x][y-1]+fill(dp,x,y-1,k-2,n,m,arr,arr2);
            min = Math.min(min,curVal);
        }

        if(x<n-1){
            
            int curVal = 2*arr2[x][y]+fill(dp,x+1,y,k-2,n,m,arr,arr2);
            min = Math.min(min,curVal);
        }

        if(y<m-1){
            
            int curVal = 2*arr[x][y]+fill(dp,x,y+1,k-2,n,m,arr,arr2);
            min = Math.min(min,curVal);
        }

        dp[x][y][k]=min;
        return min;


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
