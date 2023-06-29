
import java.io.*;
import java.util.*;

public class B{

	static int a[];
	static long []sum;
	
	static long max;
	static ArrayList<Integer> []adj;
	static int dfs(int u,int p,int t)
	{
		int ans=0;
		
		sum[u]=a[u];
		for(int v:adj[u])
			if(v!=p)
			{
				ans+=dfs(v,u,t);
				if(sum[v]>0)
					sum[u]+=sum[v] ;
			}
		if(t==0)
			max=Math.max(max, sum[u]);
		else if(sum[u]==max) {
			sum[u]=0;
			
			ans++;
		}
		return ans;
		
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		
		adj=new ArrayList[n];
		sum=new long[n];
		a=new int [n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			
			adj[i]=new ArrayList();
		}
		max=-(int)1e9;
		for(int i=1;i<n;i++)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dfs(0,0,0);
		
		long cnt=dfs(0,0,1);
		out.println(cnt*max+" "+cnt);
		out.close();

	}
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		Scanner(String fileName) throws FileNotFoundException{
			br=new BufferedReader(new FileReader(fileName));
		}
		String next() throws IOException {
			while(st==null || !st.hasMoreTokens())
				st=new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		String nextLine() throws IOException {
			return br.readLine();
		}
		int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
		long nextLong()  throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
	}
}
