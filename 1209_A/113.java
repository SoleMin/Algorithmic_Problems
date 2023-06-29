import java.io.*;
import java.util.*;
 
 
public class Main {
	public static void main(String[] args) throws Exception {
		MScanner sc=new MScanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int n=sc.nextInt();HashSet<Integer>nums=new HashSet<Integer>();
		int[]in=new int[n];for(int i=0;i<n;i++)in[i]=sc.nextInt();
		Arrays.sort(in);
		int ans=0;
		boolean vis[]=new boolean[n];
		for(int i=0;i<n;i++) {
			if(vis[i])continue;
			for(int j=i+1;j<n;j++) {
				if(in[j]%in[i]==0) {
					vis[j]=true;
				}
			}
			ans++;
		}
		pw.println(ans);
		
		pw.flush();
	}
    static class MScanner {
		StringTokenizer st;
		BufferedReader br;
 
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
 
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public char nextChar() throws IOException {
			return next().charAt(0);
		}
 
		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}