import java.awt.List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class T {
	static Scanner in = new Scanner();
	static PrintWriter out = new PrintWriter(System.out);
	static boolean adj[][];
	static int n, m, from;
	static long memo[][];
	static long Num_Cycle;

	public static void main(String[] args) throws IOException {

		n = in.nextInt();
		m = in.nextInt();
		adj = new boolean[n][n];
		memo = new long[n][1 << n];
		for (int i = 0; i < m; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			adj[u][v] = adj[v][u] = true;
		}
		for (long arr[] : memo) {
			Arrays.fill(arr, -1);
		}
		Num_Cycle = 0L;
		for (int i = 0; i < n; i++) {
			from = i;
			Num_Cycle += dp(from, (1 << i));
		}
		out.println(Num_Cycle / 2);

		out.flush();
		out.close();
	}

	static long dp(int start, int mask) {
		if (memo[start][mask] != -1) {
			return (memo[start][mask]);
		}
		long ans = 0L;
		if (adj[start][from] && Integer.bitCount(mask) >= 3) {// Cycle has
																// atleast 3
																// node and 3
																// edges
			ans++;
		}
		for (int i = from + 1; i < n; i++) {
			if (adj[start][i] && ((mask & (1 << i)) == 0)) {
				ans += dp(i, mask | (1 << i));
			}
		}
		return memo[start][mask] = ans;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

	}
}
