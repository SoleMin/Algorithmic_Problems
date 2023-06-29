import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.*;
 
public class ExplorerSpace {
	
	private static class MyScanner {
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
	
    
	public static long[][][] dp; 
	
	public static boolean valid(int i, int j, int n, int m)
	{
		return i>=0 && i<n &&j>=0 && j<m;
	}
	
	public static void solution(int n, int m, int k, int[][] h, int[][] v)
			
	{
		if(k%2==1)
		{
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<m; j++)
				   out.print(-1+" ");
				
				out.println();
				
			}
			
			return;
		}
		
		dp = new long[n][m][k/2+1];
		
		for(int t = 1; t<=k/2; t++)
		{
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<m; j++)
				{
					dp[i][j][t] = Long.MAX_VALUE;
						
				}
			}
		}
		
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<m; j++)
			{
				dp[i][j][0] = 0;
					
			}
		}
		
		
		for(int t = 1; t<=k/2; t++)
		{
			for(int i = 0; i<n; i++)
			{
				for(int j = 0; j<m; j++)
				{
					if(valid(i,j+1,n,m))
						dp[i][j][t] = Math.min(dp[i][j][t], h[i][j] + dp[i][j+1][t-1]); 
				
					if(valid(i,j-1,n,m))
						 dp[i][j][t] = Math.min(dp[i][j][t], h[i][j-1] + dp[i][j-1][t-1]);
				
					if(valid(i+1,j,n,m))
						 dp[i][j][t] = Math.min(dp[i][j][t], v[i][j] + dp[i+1][j][t-1]); 
			
					if(valid(i-1,j,n,m))
						dp[i][j][t] = Math.min(dp[i][j][t], v[i-1][j] + dp[i-1][j][t-1]); 
		
				}
			}
		}
		
		
		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<m; j++)
				out.print((dp[i][j][k/2]*2)+" ");
			
			out.println();
		}
		
	}
        
private static PrintWriter out = new PrintWriter(System.out);

public static void main (String[] args)
{
	MyScanner s =  new MyScanner();
     
    int n = s.nextInt();
    int m = s.nextInt();
    int k = s.nextInt();
    
    int[][] h = new int[n][m-1];
    
    for(int i = 0; i<n; i++)
    {
    	for(int j = 0; j<m-1; j++)
    	{
    		h[i][j] = s.nextInt();
    	}
    }
    
    int[][] v = new int[n-1][m];
    
    for(int i = 0; i<n-1; i++)
    {
    	for(int j = 0; j<m; j++)
    	{
    		v[i][j] = s.nextInt();
    	}
    }
    
    
   solution(n,m,k,h,v);
    
    out.flush();
    out.close();
    
}
}
