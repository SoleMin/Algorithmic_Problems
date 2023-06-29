
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	static char[] arr;
	static int mod = (int) 1e9 + 7;
	static int[][] memo;
	static int n;

	static int solve(int idx, int depth) {
		if (idx == n) {
			return depth == 0 ? 1 : 0;
		}
		if (memo[idx][depth] != -1)
			return memo[idx][depth];
		int ret = 0;
		if (arr[idx] == 's') {
			if (depth > 0)
				ret = ret + solve(idx, depth - 1);
			ret = (ret + solve(idx + 1, depth)) % mod;
		}
		if (arr[idx] == 'f' || arr[idx] == 'z')
			ret = (ret + solve(idx + 1, depth + 1)) % mod;
		return memo[idx][depth] = ret;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new char[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.next().charAt(0);
		memo = new int[n + 1][n + 1];
		for (int[] x : memo)
			Arrays.fill(x, -1);
		System.out.println(solve(0, 0));
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
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
	}
}
