import java.io.*;
import java.util.*;


public class f{

   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] arr = new int[n][m];
      for(int i=0; i<n; i++) {
          for(int j=0; j<m; j++) {
              arr[i][j] = sc.nextInt();
          }
      }
      if(n==1) {
          int min = Integer.MAX_VALUE;
          for(int i=0; i<m-1; i++) {
              min = Math.min(min, Math.abs(arr[0][i]-arr[0][i+1]));
          }
          out.println(min);
          out.close();
      }
      int[][] adj = new int[n][n];
      int[][] edgeadj = new int[n][n];
      for(int i=0; i<n; i++) {
          for(int j=i+1; j<n; j++) {
              int min = Integer.MAX_VALUE;
              for(int k=0; k<m; k++) {
                  min = Math.min(min, Math.abs(arr[i][k]-arr[j][k]));
              }
              adj[i][j]=min;
              adj[j][i]=min;
              int min1 = Integer.MAX_VALUE;
              int min2 = Integer.MAX_VALUE;
              for(int k=0; k<m-1; k++) {
                  min1 = Math.min(min1, Math.abs(arr[i][k]-arr[j][k+1]));
                  min2 = Math.min(min2, Math.abs(arr[i][k+1]-arr[j][k]));
              }
              edgeadj[i][j]=min1;
              edgeadj[j][i]=min2;
          }
      }
      int power = (int)Math.pow(2,n);
      int[][][] dp = new int[power][n][n];
      for(int i=0; i<n; i++) {
          dp[(int)Math.pow(2,i)][i][i] = Integer.MAX_VALUE;
      }
      for(int bit=0; bit<power; bit++) {
          for(int j=0; j<n; j++) {
              for(int k=0; k<n; k++) {
                  if((bit & (1<<j))>0 && (bit & (1<<k))>0 && j!=k) {
                      int temp = bit;
                      temp &= ~(1<<k);
                      int ans = 0;
                      for(int l=0; l<n; l++) {
                          if((temp & (1<<l))>0) {
                              int min = Math.min(dp[temp][j][l], adj[l][k]);
                              ans = Math.max(ans, min);
                          }
                      }
                      if(j!=k) {
                          dp[bit][j][k] = ans;
                      }
                    // out.println(bit + " " + j + " " + k + " " + dp[bit][j][k]);
                  }
              }
          }
      }
      int answer = 0;
      for(int i=0; i<n; i++) {
          for(int j=0; j<n; j++) {
              if(i!=j) {
                int ans = Math.min(dp[power-1][i][j], edgeadj[i][j]);
                answer = Math.max(answer, ans);
              }
          }
      }
    //   for(int i=0; i<n; i++) {
    //       for(int j=0; j<n; j++) {
    //           out.println(dp[power-1][i][j]+" "+edgeadj[i][j]);
    //       }
    //   }
      out.println(answer);
      
      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

      // Stop writing your solution here. -------------------------------------
      out.close();
   }

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
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
   //--------------------------------------------------------
}