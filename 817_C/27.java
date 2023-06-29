import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
	
	long sum(long n){
		long sm = 0;
		
		while(n!=0){
			sm+=(n%10);
			n/=10;
		}
		
		return sm;
		
	}
	
	void solve() throws IOException{
		
		long n = in.nextLong();
		long s = in.nextLong();
		
		long l = 0;
		long h = n+1;
		long ans = -1;
		
		while(l<h){
			 long mid = (l + h)/2;
			 
			 long sum = sum(mid);
			 
			 if(mid - sum >= s){
				 ans = mid;
				 h = mid;
			 }
			 else
				 l = mid+1;
			 
			// System.out.println(mid);
			 
			// ans = (mid+1);
			
		}
		
	//	System.out.println(ans);
		
		if(ans==-1)
			out.println("0");
		else
			out.println(n+1-ans);
		
		
				
			
		
		
		
		
		
		
	} // solve

	class FastScanner{
		BufferedReader br;
		StringTokenizer st;
	
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		
		public int nextInt() throws IOException{
			 if(st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else{
				st = new StringTokenizer(br.readLine());
				return nextInt();
			}			
		}
		
		public long nextLong() throws IOException{
			 if(st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else{
				st = new StringTokenizer(br.readLine());
				return nextLong();
			}			
		}
		
		public String readLine() throws IOException{
			return br.readLine();
		}
	}
	
	FastScanner in = new FastScanner();
	static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 
	
	
	public static void main(String args[])throws IOException{
		 new Solution().solve();
		 out.close();
	}

}
