import java.io.*;
import java.util.*;

public class C {

	static int n, m, a[][];
	static int[][] memo;

	static int[] getCol(int col, int shift) {
		int[] ans = new int[n];
		for (int i = 0, j = shift; i < n; i++, j = (j + 1) % n) {
			ans[i] = a[j][col];
		}
		return ans;

	}

	static int dp(int col, int msk) {
		if (col == m)
			return 0;
		if (memo[msk][col] != -1)
			return memo[msk][col];
		int ans = 0;
		for (int shift = 0; shift < n; shift++) {
			int[] currCol = getCol(col, shift);
			for (int nxtMsk = 0; nxtMsk < 1 << n; nxtMsk++) {
				if ((nxtMsk & msk) != msk)
					continue;
				int curr = 0;
				int diff = msk ^ nxtMsk;
				for (int i = 0; i < n; i++)
					if ((diff & 1 << i) != 0)
						curr += currCol[i];
				ans = Math.max(ans, dp(col + 1, nxtMsk) + curr);
			}
		}
		return memo[msk][col] = ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			memo = new int[1 << n][m];
			for (int[] x : memo)
				Arrays.fill(x, -1);
			a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					a[i][j] = sc.nextInt();
			out.println(dp(0, 0));
		}
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

	static void sort(int[] a) {
		shuffle(a);
		Arrays.sort(a);
	}

	static void shuffle(int[] a) {
		int n = a.length;
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int tmpIdx = rand.nextInt(n);
			int tmp = a[i];
			a[i] = a[tmpIdx];
			a[tmpIdx] = tmp;
		}
	}

}