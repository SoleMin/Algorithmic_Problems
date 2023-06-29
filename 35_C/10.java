import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, m, k;
	static int inf = (int) 1e9;
	static class Pair {
		int x, y;
		Pair(int a, int b) {
			x = a; y = b;
		}
	}
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	static boolean valid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	static int[][] bfs(int[] xs, int[] ys) {
		int[][] dist = new int[n][m];
		for(int i = 0; i < n; i++)
			Arrays.fill(dist[i], inf);
		Queue<Pair> q = new LinkedList<>();
		for(int i = 0; i < k; i++) {
			dist[xs[i]][ys[i]] = 0;
			q.add(new Pair(xs[i], ys[i]));
		}

		while(!q.isEmpty()) {
			Pair p = q.remove();
			for(int d = 0; d < 4; d++) {
				int nx = p.x + dx[d], ny = p.y + dy[d];
				if(valid(nx, ny) && dist[nx][ny] == inf) {
					dist[nx][ny] = dist[p.x][p.y] + 1;
					q.add(new Pair(nx, ny));
				}
			}
		}

		return dist;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner();
		int n = in.nextInt() ; 
		int m = in.nextInt(); 
		int k = in.nextInt(); 
		int x[] = new int[k] ; 
		int y[] = new int[k] ; 
		int trees [][] = new int [n][m] ;


		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				trees[i][j]=Integer.MAX_VALUE ;

		for (int i = 0; i < k; i++)
		{
			x[i]=in.nextInt()-1; 
			y[i]=in.nextInt()-1;
			trees[x[i]][y[i]]=0 ;
		}

		int dis = Integer.MIN_VALUE ; ;
		int xp=0; ;
		int yp=0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if(trees[i][j] != 0)
					for (int j2 = 0; j2 < k; j2++)
						trees[i][j]=Math.min(trees[i][j], Math.abs(i-x[j2])+Math.abs(j-y[j2]));

		for (int i = 0; i <n; i++)
			for (int j = 0; j < m; j++)
				if(trees[i][j] > dis)
				{
					dis=trees[i][j];
					xp=i+1;
					yp=j+1;
				}
		PrintWriter out = new PrintWriter("output.txt");
		out.printf("%d %d\n", xp ,yp);
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;
		Scanner() throws FileNotFoundException {
			br = new BufferedReader(new FileReader("input.txt"));
		}

		String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}