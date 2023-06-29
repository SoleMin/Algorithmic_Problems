//package ;
import java.io.*;
import java.util.*;

public class D {
	static int dp(int i,int start,int msk)
	{
		if(Integer.bitCount(msk)==n)
			return s_e[i][start];

		if(dp[i][start][msk]!=-1)
			return dp[i][start][msk];
		
		int max=0;
		for(int k=0;k<n;k++)
		{	
			int min=Integer.MAX_VALUE;
			if((msk & (1<<k)) == 0 )
			{
				min=diff[i][k];
				min=Math.min(min, dp(k,start,msk | (1<<k)));
				max=Math.max(max, min);
			}
		}
		return dp[i][start][msk]=max;
	}
	static int n,m,a[][],dp[][][],diff[][],s_e[][];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n][m];
		diff=new int[n][n];
		s_e=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				a[i][j]=sc.nextInt();
		
		dp=new int[n][n][70000];
		int ans=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{	
				Arrays.fill(dp[i][j], -1);
				diff[i][j]=Integer.MAX_VALUE;
				s_e[i][j]=Integer.MAX_VALUE;
				for(int k=0;k<m-1;k++)
				{	
					diff[i][j]=Math.min(Math.abs(a[i][k]-a[j][k]), diff[i][j]);
					s_e[i][j]=Math.min(Math.abs(a[i][k]-a[j][k+1]), s_e[i][j]);
				}
				diff[i][j]=Math.min(Math.abs(a[i][m-1]-a[j][m-1]), diff[i][j]);
			}
		
		for(int i=0;i<n;i++)
			ans=Math.max(ans, dp(i,i,1<<i));
		
		pw.print(ans);
		pw.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean hasnext() throws IOException {
			return br.ready();
		}

	}
}
