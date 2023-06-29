import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A {

	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner("input.txt");
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);

		int N = sc.nextInt(), M = sc.nextInt();
		int[][] dist = new int[N][M];
		Queue<Integer> q = new LinkedList<>();
		int K = sc.nextInt();
		while(K-->0)
		{
			int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
			q.add(x * M + y);
			dist[x][y] = 1;
		}
		
		int max = 0, ansX = -1, ansY = -1;
		while(!q.isEmpty())
		{
			int u = q.remove(), x = u / M, y = u % M;
			if(dist[x][y] > max) 
				max = dist[ansX = x][ansY = y];
			for(int k = 0; k < 4; ++k)
			{
				int nx = x + dx[k], ny = y + dy[k];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && dist[nx][ny] == 0)
				{
					dist[nx][ny] = dist[x][y] + 1;
					q.add(nx * M + ny);
				}
				
			}
		}
		out.printf("%d %d\n", ansX + 1, ansY + 1);
		out.close();
	}
	

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		
		public Scanner(String s) throws FileNotFoundException{	br = new BufferedReader(new FileReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();} 
	}
}