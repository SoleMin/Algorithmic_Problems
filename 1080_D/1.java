import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		int q=in.nextInt();
		for(int i=0;i<q;i++) {
			work();
		}
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return a==0?b:b>a?gcd(b%a,a):gcd(b,a);
	}
	void work() {
		long n=in.nextLong();
		long k=in.nextLong();
		if(k==0) {
			out.println("YES"+" "+n);
		}
		long a=0,b=0,c=1,d=1;
		while(--n>=0&&a<=k) {
			b+=c;
			c*=4;
			a+=d;
			d=d*2+1;
			long t=count(c-d,n);
			if(a<=k&&b>=k-t) {
				out.println("YES"+ " "+n);
				return;
			}
		}
		out.println("NO");
	}
	private long count(long l, long n) {
		if(n==0)return 0;
		n--;
		long ret=l;
		for(int i=1;i<=n;i++) {
			long t=ret;
			ret*=4;
			if(ret/4!=t)return Long.MAX_VALUE;
		}
		return ret;
	}
}	



class FastReader
{
	BufferedReader br;
	StringTokenizer st;

	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public String next() 
	{
		if(st==null || !st.hasMoreElements())
		{
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	public int nextInt() 
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}
}