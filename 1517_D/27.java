import java.util.*;
import java.io.*;
public class B{
	static int[][] hor;
	static int[][] ver;
	static int n;
	static int m;
	static int k;
	static long[][][] dp;
	
	static long dist(int row, int col)
	{
		if(k%2==1)return Integer.MAX_VALUE;
		return 2*make(row,col,k/2);
	}
	
	static long make(int row, int col, int moves)
	{
		if(moves == 0)
		{
			return 0;
		}
		
		if(dp[row][col][moves]!=-1)return dp[row][col][moves];
		
		long ans = Long.MAX_VALUE;
		
		if(col-1>=0)
		{
			ans = Math.min(ans, hor[row][col-1]+make(row,col-1,moves-1));
		}
		if(col+1<m)
		{
			ans = Math.min(ans, hor[row][col]+make(row,col+1,moves-1));
		}
		if(row-1>=0)
		{
			ans = Math.min(ans, ver[row-1][col]+make(row-1,col,moves-1));
		}
		if(row+1<n)
		{
			ans = Math.min(ans, ver[row][col]+make(row+1,col,moves-1));
		}
		dp[row][col][moves] = ans;
		return ans;
	}
	
	public static void main(String[] args)
	{
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		n = fs.nextInt(); m = fs.nextInt(); k = fs.nextInt();
		hor = new int[n][m]; ver = new int[n][m];
		dp = new long[505][505][24];
		for(int i=0;i<505;i++)for(int j=0;j<505;j++)for(int k=0;k<24;k++)dp[i][j][k] = -1;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m-1;j++)
			{
				int a = fs.nextInt();
				hor[i][j] = a;
			}
		}
		
		for(int row=0;row<n-1;row++)
		{
			for(int col =0;col<m;col++)
			{
				int a = fs.nextInt();
				ver[row][col] = a;
			}
		}

		
		for(int row=0;row<n;row++)
		{
			for(int col=0;col<m;col++)
			{
				long d = dist(row,col);
				if(d<Integer.MAX_VALUE)
				{
					out.print(d+" ");
				}
				else out.print("-1 ");
			}
			out.println();
		}
		out.close();
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
	public static int[] sort(int[] arr)
	{
		List<Integer> temp = new ArrayList();
		for(int i:arr)temp.add(i);
		Collections.sort(temp);
		int start = 0;
		for(int i:temp)arr[start++]=i;
		return arr;
	}
}