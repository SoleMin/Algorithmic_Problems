import java.io.*;
import java.util.*;

public class A
{	
	
	
		public static void main(String[] args) throws IOException 
		{
				
				Scanner sc=new Scanner(System.in);
				PrintWriter pw=new PrintWriter(System.out);
				int n=sc.nextInt();
				String []a=new String[n];
				String []b=new String[n];
				
				TreeMap<String,Integer> map1=new TreeMap(),map2=new TreeMap();
				for(int i=0;i<n;i++)
				{
					String s=sc.next();
					map1.put(s, map1.getOrDefault(s, 0)+1);
					
				}
				for(int i=0;i<n;i++)
				{
					String s=sc.next();
					map2.put(s, map2.getOrDefault(s, 0)+1);
					
				}
				int ans=0;
				for(String s:map2.keySet())
				{
					int cnt=map1.getOrDefault(s, 0);
					ans+=Math.max(0, map2.get(s)-cnt);
				}
				pw.println(ans);
				pw.close();
		}
		
		
		
		static class Scanner
		{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

		
		
}