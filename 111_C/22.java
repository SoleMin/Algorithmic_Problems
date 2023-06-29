import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution implements Runnable {

	public static void main(String[] args) {
		(new Thread(new Solution())).start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String r = in.readLine();
			if (r == null) return null;
			st = new StringTokenizer(r);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	int count(int q, int n) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (q % 3 != 1) ans++;
			q /= 3;
		}
		return ans;
	}
	
	int count2(int q, int n) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (q % 3 == 2) ans++;
			q /= 3;
		}
		return ans;
	}
	
	int sz;
	
	int[] decode(int q, int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = q % 3;
			q /= 3;
		}
		return res;
	}
	
	boolean[][] precalc(int n, int m) {
		boolean[][] res = new boolean[sz][sz];
		for (int i = 0; i < sz; i++) {
			int[] ai = decode(i, n);
			for (int j = 0; j < sz; j++) {
				int[] aj = decode(j, n);
				boolean f = true;
				for (int k = 0; k < n && f; k++) {
					if (aj[k] == 0) {
						f = false;
						if (k > 0 && aj[k - 1] == 1) f = true;
						if (k < n - 1 && aj[k + 1] == 1) f = true;
						if (ai[k] == 1) f = true;
					}
					if (f && ai[k] == 2) f = (aj[k] == 1);
				}
				res[i][j] = f;
			}
		}
		return res;
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int m = nextInt();
		if (n > m) { int t = n; n = m; m = t; }
		sz = 1;
		for (int i = 0; i < n; i++) sz *= 3;
		boolean[][] a = precalc(n, m);
		int[][] d = new int[m + 1][sz];
		Arrays.fill(d[0], -1);
		d[0][0] = 0;
		for (int i = 1; i <= m; i++) {
			Arrays.fill(d[i], -1);
			for (int j = 0; j < sz; j++) {
				if (d[i - 1][j] != -1) {
					for (int k = 0; k < sz; k++) {
						if (a[j][k]) {
							d[i][k] = Math.max(d[i][k], d[i - 1][j] + count(k, n));
						}
					}
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < sz; i++) if (count2(i, n) == 0) ans = Math.max(ans, d[m][i]);
		out.println(ans);
	}

	public void run() {
		Locale.setDefault(Locale.UK);
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
//			in = new BufferedReader(new FileReader("knights.in"));
//			out = new PrintWriter("knights.out");
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.flush();
		}
	}

}