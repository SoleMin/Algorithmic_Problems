import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.*;
 
public class LightItUp {
	
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
	

	
	public static long solution(int[] arr, int n)
			
	{	
		long[] on = new long[n];
		long[] off = new long[n];
		on[0] = 0;
		off[0] = 0;
		
		for(int i = 1; i<n; i++)
		{
		    if(i%2==1)
		      { on[i] = on[i-1] + arr[i]-arr[i-1]; off[i] = off[i-1]; }
		    if(i%2==0)
		      { off[i] = off[i-1] + arr[i]-arr[i-1]; on[i] = on[i-1]; }
		}
		    
		long max = on[n-1];
		
		for(int i = 1; i<n; i++)
		{
		    long curr = on[i-1] + (off[n-1]-off[i]) + arr[i]-arr[i-1]-1;
		    if(curr>max)
		    	max = curr;
		}
		
		return max;
	}
        
private static PrintWriter out = new PrintWriter(System.out);

public static void main (String[] args)
{
	MyScanner s =  new MyScanner();
     
    int n = s.nextInt();
    int m = s.nextInt();
    int[] arr = new int[n+2];
    arr[0] = 0;
    
    for(int j = 1; j<n+1 ; j++)
       arr[j] = s.nextInt();
    
    arr[n+1] = m;
      
    out.println(solution(arr,n+2));
      
    out.flush();
    out.close();
    
}
}
