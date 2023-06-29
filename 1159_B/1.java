import java.util.*;
import java.io.*;
 
public class File {
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
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
	}
		
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)arr[i]=sc.nextInt();
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
		    ans=Math.min(ans,arr[i]/Math.max(i,n-1-i));
		}
		out.println(ans);
		out.close();
	}
}