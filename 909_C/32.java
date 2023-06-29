import java.io.*;
import java.util.*;
import  java.math.*;
public class Main {


	public static void main(String[] args) throws IOException
	{
		// StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		FastScanner sc = new FastScanner();
		int dp[][]=new int[6000][6000];
		char a[]=new char[6000];
		final int n=sc.nextInt();
		boolean flag=false;
		int cnt=0;
		char pre='f';
		for(int i=1;i<=n;i++)
		{
			 a[i]=sc.next().charAt(0);

		}
		dp[1][1]=1;
		final int mod=(int)1e9+7;
		dp[1][1]=1;
		for(int i=2;i<=n;i++)
		{
			if(a[i-1]=='s')
			{
				int now=0;
				for(int j=5050;j>=1;j--)
				{
					now=(now+dp[i-1][j])%mod;
					dp[i][j]=now;
				}
			}
			else
			{
				for(int j=5050;j>=1;j--)
				{
					dp[i][j]=dp[i-1][j-1]%mod;
				}
			}
		}
		int ans=0;
		for(int i=0;i<=5050;i++)
		{
			ans+= dp[n][i]%mod;
			ans%=mod;
		}
		out.println(ans%mod);

		out.flush();
	}
/*
6
f
s
f
s
f
s


	 */
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		private FastScanner() {
			try	{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e){e.printStackTrace();}
		}
		private boolean hasNextToken()
		{
			if(st.countTokens()!=StreamTokenizer.TT_EOF)
			{
				return true;
			}
			else
				return false;
		}
		private String next() {
			if (st.hasMoreTokens())	return st.nextToken();
			try {st = new StringTokenizer(br.readLine());}
			catch (Exception e) {e.printStackTrace();}
			return st.nextToken();
		}
		private BigInteger nextBigInteger(){return new BigInteger(next());}
		private BigDecimal nextBigDecimal(){return new BigDecimal(next());}
		private  int nextInt() {return Integer.parseInt(next());}
		private long nextLong() {return Long.parseLong(next());}
		private double nextDouble() {return Double.parseDouble(next());}
		private String nextLine() {
			String line = "";
			if(st.hasMoreTokens()) line = st.nextToken();
			else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
			while(st.hasMoreTokens()) line += " "+st.nextToken();
			return line;
		}
		private int[] nextIntArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
		private long[] nextLongArray(int n){
			long[] a = new long[n];
			for(int i = 0; i < n; i++) a[i] = nextLong();
			return a;
		}
		private double[] nextDoubleArray(int n){
			double[] a = new double[n];
			for(int i = 0; i < n; i++) a[i] = nextDouble();
			return a;
		}
		private char[][] nextGrid(int n, int m){
			char[][] grid = new char[n][m];
			for(int i = 0; i < n; i++) grid[i] = next().toCharArray();
			return grid;
		}
		private void sort(int arr[])
		{
			int cnt[]=new int[(1<<16)+1];
			int ys[]=new int[arr.length];
			for(int j=0;j<=16;j+=16){
				Arrays.fill(cnt,0);
				for(int x:arr){cnt[(x>>j&0xFFFF)+1]++;}
				for(int i=1;i<cnt.length;i++){cnt[i]+=cnt[i-1];}
				for(int x:arr){ys[cnt[x>>j&0xFFFF]++]=x;}
				{ final int t[]=arr;arr=ys;ys=t;}
			}
			if(arr[0]<0||arr[arr.length-1]>=0)return;
			int i,j,c;
			for(i=arr.length-1,c=0;arr[i]<0;i--,c++){ys[c]=arr[i];}
			for(j=arr.length-1;i>=0;i--,j--){arr[j]=arr[i];}
			for(i=c-1;i>=0;i--){arr[i]=ys[c-1-i];}
		}
	}

}


