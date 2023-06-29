import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner("input.txt");
		PrintWriter out = new PrintWriter("output.txt");
		Queue<Pair> q = new LinkedList<Pair>();
		int n = sc.nextInt(),m = sc.nextInt() , k = sc.nextInt();
		boolean [][] vis = new boolean[n][m];
		while(k-->0)
			q.add(new Pair(sc.nextInt()-1,sc.nextInt()-1));
	
		int ansX = 1 , ansY = 1;
		
		while(!q.isEmpty())
		{
			Pair cur = q.poll();
			if(vis[cur.i][cur.j])continue;
			ansX = cur.i ; ansY = cur.j;
			vis[cur.i][cur.j] = true;
			for (int i = 0; i < di.length; i++) {
				int ni = cur.i + di[i] , nj = cur.j + dj[i];
				if(ni>=0 && ni<n && nj>=0 && nj<m && !vis[ni][nj])
					q.add(new Pair(ni,nj));
			}
		}
		
		out.append(++ansX+" "+ ++ansY);
		out.flush();
		
	}
	static class Pair
	{
		int i,j;
		public Pair(int a,int b) {
			i = a; j = b;
		}
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}		
		public long nextLong() throws IOException {return Long.parseLong(next());}		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}	
		public boolean ready() throws IOException {return br.ready();}
	}
	
}