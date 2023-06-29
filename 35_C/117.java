import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class P {

	static int N, M, K;
	static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static Pair[] b;

	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	static class Pair {
		int x, y;

		Pair(int i, int j) {
			x = i;
			y = j;
		}
	}

	static Pair bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				dist[i][j] = -1;
		for (int i = 0; i < K; i++) {
			dist[b[i].x][b[i].y] = 0;
			q.add(b[i]);
		}

		while (!q.isEmpty()) {
			Pair cur = q.remove();
			for (int d = 0; d < 4; d++) {
				int X = cur.x + dx[d];
				int Y = cur.y + dy[d];
				if (isValid(X, Y) && dist[X][Y] == -1) {
					dist[X][Y] = dist[cur.x][cur.y] + 1;
					Pair P = new Pair(X, Y);
					q.add(P);
				}
			}
		}
		int max = -1;
		Pair MX = null;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (dist[i][j] > max) {
					max = dist[i][j];
					MX = new Pair(i + 1, j + 1);
				}
			}

		return MX;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner("input.txt");
		PrintWriter out = new PrintWriter("output.txt");
		// Scanner sc = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		b = new Pair[K];
		for (int i = 0; i < K; i++)
			b[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);

		Pair last = bfs();
		out.println((last.x) + " " + (last.y));
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(String f) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(f));
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] nextIntArray1(int n) throws IOException {
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextInt();
			return a;
		}

		public int[] nextIntArraySorted(int n) throws IOException {
			int[] a = nextIntArray(n);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			Arrays.sort(a);
			return a;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArray1(int n) throws IOException {
			long[] a = new long[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = nextLong();
			return a;
		}

		public long[] nextLongArraySorted(int n) throws IOException {
			long[] a = nextLongArray(n);
			Random r = new Random();
			for (int i = 0; i < n; i++) {
				int j = i + r.nextInt(n - i);
				long t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
			Arrays.sort(a);
			return a;
		}
	}
}