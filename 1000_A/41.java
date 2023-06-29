// //package ;
import java.io.*;
import java.util.*;

public class A
{
	public static int sol(String n,String p)
	{
		int sol=0;
		for(int i=0;i<n.length();i++)
		{
			if(n.charAt(i)!=p.charAt(i))
				sol++;
		}
		return sol;
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n=sc.nextInt();
		ArrayList<String>p=new ArrayList<>();
		ArrayList<String>ne=new ArrayList<>();
		for(int i=0;i<n;i++)
			p.add(sc.nextLine());
		for(int i=0;i<n;i++)
		{	
			String t=sc.nextLine();
			if(p.contains(t))
				p.remove(t);
			else
				ne.add(t);
		}
		Collections.sort(p);
		Collections.sort(ne);
		int ans=0;
		for(int i=0;i<ne.size();i++)
		{
			ans+=sol(ne.get(i),p.get(i));
		}
		System.out.println(ans);
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
		boolean hasnext() throws IOException{
			return br.ready();
		}
		
	}
}
