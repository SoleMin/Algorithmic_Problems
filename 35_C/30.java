import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
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

public class Main {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner("input.txt");
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		
		int n,m;
		n = scan.nextInt();
		m = scan.nextInt();

		boolean visited[][] = new boolean[n][m];
    
		int numOfStartingPoints;
		numOfStartingPoints = scan.nextInt();
		    		
		int resX = 0, resY = 0;
		
		Queue<Point> que = new LinkedList<Point>();
		for (int i = 0; i < numOfStartingPoints; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;
			que.add(new Point(x, y));
			visited[x][y] = true;
		}
		
		while (true) {
			Point current = que.poll();

			if (current == null) {
				break;
			} else {
				resX = current.x;
				resY = current.y;
				
				if (current.x + 1 < n && !visited[current.x + 1][current.y])
				{
					que.add(new Point(current.x + 1, current.y));
					visited[current.x + 1][current.y] = true;


				}
				if (current.y + 1 < m && !visited[current.x][current.y + 1])
				{
					que.add(new Point(current.x, current.y + 1));
					visited[current.x][current.y + 1] = true;
		

				}
				if (current.x - 1 >= 0 && !visited[current.x - 1][current.y])
				{
					que.add(new Point(current.x - 1, current.y));
					visited[current.x - 1][current.y] = true;
				
				}
				if (current.y - 1 >= 0 && !visited[current.x][current.y - 1])
				{
					que.add(new Point(current.x, current.y - 1));
					visited[current.x][current.y - 1] = true;
				
				}

				
			}
		}
		
		
		out.printf("%d %d\n", ++resX, ++resY);
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

