import java.io.*;
import java.util.*;


public class A {
	public static boolean ok(int []x,int d,int X)
	{
		for(int i=0;i<x.length;i++)
			if(Math.abs(x[i]-X)<d)
				return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int ans=0;
		int n=sc.nextInt(),d=sc.nextInt();
		TreeSet<Integer> set=new TreeSet();
		int []x=new int [n];
		for(int i=0;i<n;i++)
			x[i]=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int x1=x[i]+d;
			if (ok(x,d,x1))
				set.add(x1);
			x1=x[i]-d;
			if (ok(x,d,x1))
				set.add(x1);
			
			
		}
		pw.println(set.size());
			
		
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
