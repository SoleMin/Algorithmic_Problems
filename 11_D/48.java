import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private FastScanner in;
	private PrintWriter out;

	public void solve() throws IOException {
		int N = in.nextInt();
		int M = in.nextInt();

		int[][] edges = new int[N][N];
		for (int i = 0; i < M; i++) {
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			edges[a][b] = 1;
			edges[b][a] = 1;
		}

		int globalCountMasks = 1 << N;
		int[][] masks = new int[N + 1][];
		int[] countMasks = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			masks[i] = new int[combinations(N, i)];
		}
		for (int i = 0; i < globalCountMasks; i++) {
			int c = countBit1(i);
			masks[c][countMasks[c]] = i;
			countMasks[c]++;
		}

		long globalCountCycles = 0;
		long[][] count = new long[globalCountMasks][N];

		for (int a = 0; a < N - 2; a++) {
			int aBit = 1 << a;
			count[aBit][a] = 1;
			long countCycles = 0;
			for (int i = 2; i <= N; i++) {
				for (int m = 0; m < countMasks[i]; m++) {
					int mask = masks[i][m];
					if ((mask & aBit) == 0)
						continue;
					if ((mask & (aBit - 1)) > 0)
						continue;
					count[mask][a] = 0;
					for (int v = a + 1; v < N; v++) {
						int vBit = 1 << v;
						if ((mask & vBit) == 0)
							continue;
						count[mask][v] = 0;
						for (int t = a; t < N; t++) {
							if ((mask & (1 << t)) == 0 || t == v
									|| edges[v][t] == 0)
								continue;
							count[mask][v] += count[mask ^ vBit][t];
						}
						if (edges[a][v] == 1 && mask != (aBit | vBit)) {
							countCycles += count[mask][v];
						}
					}
				}
			}
			globalCountCycles += countCycles / 2;
		}

		out.println(globalCountCycles);
	}

	private int countBit1(int k) {
		int c = 0;
		while (k > 0) {
			c += k & 1;
			k >>= 1;
		}
		return c;
	}

	private int combinations(int n, int k) {
		if (k > n || k < 0) {
			throw new IllegalArgumentException();
		}
		int r = 1;
		for (int i = 1; i <= k; i++) {
			r = r * (n + 1 - i) / i;
		}
		return r;
	}

	public void run() {
		try {
			in = new FastScanner(System.in);
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	public static void main(String[] arg) {
		new Main().run();
	}
}