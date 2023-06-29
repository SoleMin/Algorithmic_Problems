import java.io.*;
import java.util.*;

public class B{

	static long []sum;
	
	static int n;

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner();
		PrintWriter out=new PrintWriter(System.out);
		n=sc.nextInt();
		sum=new long [n+1];
		for(int i=1;i<=n;i++)
			sum[i]=sc.nextInt()+sum[i-1];
		HashMap<Long,Integer> map=new HashMap();
		ArrayList<int []>[]adj=new ArrayList[n*n+10];
		for(int i=0;i<adj.length;i++)
			adj[i]=new ArrayList();
		for(int r=1;r<=n;r++) 
			for(int l=1;l<=n;l++) {
				if(r<l)
					continue;
				long x=sum[r]-sum[l-1];
				map.put(x, map.getOrDefault(x, map.size()));
				adj[map.get(x)].add(new int [] {l,r});
			}
		int ans=0;
		int bestIdx=0;
		for(int idx=0;idx<adj.length;idx++)
		{
			ArrayList<int[]>list=adj[idx];
			if(list.isEmpty())
				continue;
			int curr=1;
			int R=list.get(0)[1];
			for(int i=1;i<list.size();i++)
			{
				int []tmp=list.get(i);
				if(tmp[0]>R)
				{
					R=tmp[1];
					curr++;
				}
			}
			if(curr>=ans) {
				ans=curr;
				bestIdx=idx;
			}
		}
		out.println(ans);
		ArrayList<int[]>list=adj[bestIdx];
		int R=list.get(0)[1];
		out.println(list.get(0)[0]+" "+R);
		for(int i=1;i<list.size();i++)
		{
			int []tmp=list.get(i);
			if(tmp[0]>R)
			{
				R=tmp[1];
				out.println(tmp[0]+" "+tmp[1]);
			}
		}
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
