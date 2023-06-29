import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) {new Main().run();}

	FastReader in = new FastReader();
	PrintWriter out = new PrintWriter(System.out);
	void run(){
		out.println(work());
		out.flush();
	}
	long mod=1000000007;
	long gcd(long a,long b) {
		return b==0?a:gcd(b,a%b);
	}
	long work() {
		int n=in.nextInt();
		int m=in.nextInt();
		String str=in.next();
		long[] dp=new long[1<<m];
		long[][] cnt=new long[m][m];
		long[] rec=new long[1<<m];//记录每次移动的一位怎加的值，减少重复计算
		for(int i=1;i<n;i++) {
			int n1=str.charAt(i-1)-'a';
			int n2=str.charAt(i)-'a';
			cnt[n1][n2]++;
			cnt[n2][n1]++;
		}
		for(int i=1;i<1<<m;i++) {
			dp[i]=9999999999L;
			long v=0;
			int b=0;//最低位的1
			for(int j=0;j<m;j++) {
				if((i&(1<<j))>0) {
					b=j;
					break;
				}
			}
			for(int j=0;j<m;j++) {
				if((i&(1<<j))==0) {
					v+=cnt[b][j];
				}else {
					if(b!=j)v-=cnt[b][j];
				}
			}
			v+=rec[i-(1<<b)];
			for(int j=0;j<m;j++) {
				if((i&(1<<j))>0) {
					dp[i]=Math.min(dp[i], dp[i-(1<<j)]+v);
				}
			}
			rec[i]=v;
		}
		
		return dp[(1<<m)-1];
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