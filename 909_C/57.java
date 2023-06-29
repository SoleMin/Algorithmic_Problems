import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class c {
	
	static boolean seq[];
	static long memo[][], mod = (long)1e9 + 7;
	static long go(int n, int d) {
		long ans = 0;
		if(d < 0) return 0;
		if(n == seq.length) return 1;
		int f = 1;
		if(n > 0) f = seq[n-1]?1:0;
		if(memo[n][d] != -1) return memo[n][d];
		if(f == 0) {
			ans += go(n + 1, d + (seq[n]?1:0));
			ans %= mod;
			ans += go(n, d-1);
			ans %= mod;
		}
		if(f == 1) {
			ans += go(n + 1, d + (seq[n]?1:0));
			ans %= mod;
		}
		return memo[n][d] = ans;
	}
	
	public static void main(String args[]) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		//BEGIN HERE
		int n = in.nextInt();
		seq = new boolean[n];
		for (int i = 0; i  < n; i++ ) {
			seq[i] = (in.next().charAt(0) == 'f');
		}
		memo = new long[n][n+1];
		for(int i = 0; i < n; i++) {
				Arrays.fill(memo[i], -1);
		}
		System.out.println(go(0, 0));
		out.close();
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream i) {
			br = new BufferedReader(new InputStreamReader(i));
			st = null;
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			if (st == null) {
				st = new StringTokenizer(br.readLine());
			}
			String line = st.nextToken("\n");
			st = null;
			return line;
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}

	public static class combinatorics {
		static long modInv(long a, long b) {
			return 1 < a ? b - modInv(b % a, a) * b / a : 1;
		}

		static long factorial[], mod;

		combinatorics(int n, long MOD) {
			mod = MOD;
			factorial = new long[n + 1];
			factorial[0] = 1;
			for (int i = 1; i <= n; i++) {
				factorial[i] = i * factorial[i - 1];
				factorial[i] %= mod;
			}
		}

		static long nCr(int n, int r) {
			if (r > n)
				return 0;
			return (factorial[n] * modInv((factorial[n - r] * factorial[r]) % mod, mod)) % mod;
		}
	}

	public static class DisjointSet {
		int p[], r[], s[];
		int numDisjoint;

		DisjointSet(int N) {
			numDisjoint = N;
			r = new int[N];
			s = new int[N];
			p = new int[N];
			for (int i = 0; i < N; i++)
				p[i] = i;
		}

		int findSet(int i) {
			return (p[i] == i) ? i : (p[i] = findSet(p[i]));
		}

		boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		void unionSet(int i, int j) {
			if (!isSameSet(i, j)) // if from different set
			{
				numDisjoint--;
				int x = findSet(i), y = findSet(j);
				if (r[x] > r[y]) {
					p[y] = x; // rank keeps the tree short
					s[x] += s[y];
				} else {
					p[x] = y;
					if (r[x] == r[y])
						r[y]++;
					s[y] += s[x];
				}
			}
		}

		int sizeOfSet(int i) {
			return s[findSet(i)];
		}
	};

}
