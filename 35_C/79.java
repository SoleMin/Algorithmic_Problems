import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {

	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	static boolean isValid(int r, int c) {
		if (r >= n || r < 0 || c >= m || c < 0)
			return false;

		return true;
	}

	static int grid[][];
	static int n, m;

	public static void main(String[] args) throws IOException {
		FastReader input = new FastReader();
		PrintWriter out = new PrintWriter("output.txt");

		n = input.nextInt();
		m = input.nextInt();
		grid = new int[n][m];

		int k = input.nextInt();

		for (int i = 0; i < n; i++) {
			Arrays.fill(grid[i], Integer.MAX_VALUE);
		}

		Queue<Pair> q = new LinkedList<Pair>();

		for (int i = 0; i < k; i++) {
			int x = input.nextInt() - 1;
			int y = input.nextInt() - 1;

			q.add(new Pair(x, y));
			grid[x][y] = 0;

			while (!q.isEmpty()) {
				Pair cur = q.poll();
				for (int j = 0; j < dr.length; j++) {
					int r = cur.x;
					int c = cur.y;
					int nr = r + dr[j];
					int nc = c + dc[j];
					int dist = grid[r][c] + 1;

					if (isValid(nr, nc) && grid[nr][nc] > dist) {
						grid[nr][nc] = dist;

						q.add(new Pair(nr, nc));
					}

				}
			}
		}

		int max = -1;
		int x = -1;
		int y = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] > max) {
					max = grid[i][j];
					x = i + 1;
					y = j + 1;
				}
			}
		}
		out.println(x + " " + y);
		out.flush();
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File("input.txt")));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		String nextLine() throws IOException {
			String str = "";
			str = br.readLine();
			return str;
		}
	}

	static class con {
		static int IINF = (int) 1e9;
		static int _IINF = (int) -1e9;
		static long LINF = (long) 1e15;
		static long _LINF = (long) -1e15;
		static double EPS = 1e-9;
	}

	static class Triple implements Comparable<Triple> {
		int x;
		int y;
		int z;

		Triple(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Triple o) {
			if (x == o.x && y == o.y)
				return z - o.z;
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;

		}

		@Override
		public int compareTo(Pair o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}

		@Override
		public String toString() {

			return "(" + x + ", " + y + ")";
		}

	}

	static void shuffle(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int r = i + (int) (Math.random() * (a.length - i));
			int tmp = a[r];
			a[r] = a[i];
			a[i] = tmp;
		}
	}

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

}