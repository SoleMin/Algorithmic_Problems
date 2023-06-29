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

public class A {

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner("input.txt");
		PrintWriter out = new PrintWriter("output.txt");
		int n = sc.nextInt(), m = sc.nextInt();
		int[][] grid = new int[n][m];
		for (int[] i : grid)
			Arrays.fill(i, -1);
		Queue<Pair> q = new LinkedList<>();
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
			grid[x][y] = 0;
			q.add(new Pair(x, y));
		}
		Pair p = new Pair(-1, -1);
		while (!q.isEmpty()) {
			p = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int tx = p.x + dx[i], ty = p.y + dy[i];
				if (tx >= 0 && tx < n && ty >= 0 && ty < m && grid[tx][ty] == -1) {
					grid[tx][ty] = grid[p.x][p.y] + 1;
					q.add(new Pair(tx, ty));
				}
			}
		}
		out.println(p);
		out.flush();
		out.close();
	}

	static class Pair {
		int x, y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}

		public String toString() {
			return x + 1 + " " + (y + 1);
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String r) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(r));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
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
