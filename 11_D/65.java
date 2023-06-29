import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A{
	static int n,m,start;
	static boolean [][] adj;
	static long [][] mem;
	public static void main(String[] args)throws Throwable {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		adj=new boolean [n][n];
		for(int i=0;i<m;i++){
			int u=sc.nextInt()-1;
			int v=sc.nextInt()-1;
			adj[u][v]=true;
			adj[v][u]=true;
		}
		mem=new long [n+1][(1<<n)];
		for(int i=0;i<=n;i++)
			Arrays.fill(mem[i], -1);
		long ans=0;
		for(int i=0;i<n;i++){
			start=i;
			ans+=dp(i, (1<<i));
		}
		System.out.println(ans/2);
	}
	
	public static long dp(int i,int msk){
		if(mem[i][msk]!=-1)
			return mem[i][msk];
		long ans=0;
		if(adj[i][start] && Integer.bitCount(msk)>2)
			ans++;
		for(int j=start+1;j<n;j++){
			if(adj[i][j] && (msk & (1<<j))==0){
				ans+=dp(j, msk | (1<<j));
			}
		}
		return mem[i][msk]=ans;
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.nextToken();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException { return Double.parseDouble(next()); }
		public boolean ready() throws IOException {return br.ready();} 
	}
}