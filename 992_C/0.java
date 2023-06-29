import java.util.*;
import java.io.*;
public class A{
	public static final long MOD = 1000*1000*1000+7;
	static long mod(long n)
	{
		return (n%MOD+MOD)%MOD;
	}
	static long fastExp(long x, long n)
	{
		if(n==0)return 1;
		long t = fastExp(x,n/2);
		if(n%2==0)return mod(t*t);
		else return mod(mod(t*t)*x);
	}
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		long n = fs.nextLong(); long k = fs.nextLong();
		if(n==0)
		{
			System.out.println(0);
			return;
		}
		if(k==0)
		{
			System.out.println(mod(2*n));
			return;
		}
		long highestValue = mod(mod(n)*fastExp(2,k+1));
		long ans =mod (highestValue - fastExp(2,k)+1);
		System.out.println(ans);
	}
	
	
	
	
	
	
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}


