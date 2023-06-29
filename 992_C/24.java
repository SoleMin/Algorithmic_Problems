import java.io.*;
import java.util.*;

public class C
{	
	static long mod=(long)(1e9+7);
	public static long powMod(long e,long b)
	{
		/*e=e%mod;*/
		long res=1;
		
		while(e>0)
		{
			if(e%2==1)
				res=res*b%mod;
			e/=2;
			b=b*b%mod;
		}
		return res;
	}

		public static void main(String[] args) throws IOException 
		{
			Scanner sc=new Scanner(System.in);
			PrintWriter pw=new PrintWriter(System.out);
			long x=sc.nextLong(),k=sc.nextLong();
			if(x==0)
			{
				System.out.println(0);
				return;
			}
			
			if(k==0)
			{
				pw.println((2*x)%mod);
				
				
				pw.close();return;
			}
			
			long ans=2*x-1;
			ans=ans%mod;
			
			long b=powMod(k,2);
			ans=((ans*b)+1)%mod;
			
			
			pw.println(ans);
			
			pw.close();
		
			
		}
		
		
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}