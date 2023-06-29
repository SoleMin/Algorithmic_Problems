import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/*

2
3 5

2
6 5
1 11
-10 12

3
3 6 2


1   8   5   3
-7  9   5   3
-7  4   14  3


1   8   5   3
1   3   13  3
-2  4   13  3
   

3
1 3 6

3 3 6

5 12
-7 19


3 5 7 11 13
-2 8


5 9


5 9


3 6 7
-3 9 7

6 3 7


*/

public class c {
	static int n;
	static int[] fs;
	static int[] cfs;
	static long[][] choose = chooseTable(1001);
	static long[] fact;
	static final long MOD = (long) (1e9 + 7);
	static long[][] memo;
	public static void main(String[] args) throws IOException {
		FastScanner in = new FastScanner(System.in);
		n = in.nextInt();
		fact = new long[301];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i - 1] * i;
			fact[i] %= MOD;
		}
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		fs = new int[n];
		for (int i = 0; i < n; i++) {
			long v = in.nextLong();
			long r = 1;
			for (int d = 2; d * d <= v; d++) {
				int cnt = 0;
				while (v % d == 0) {
					v /= d;
					cnt ^= 1;
				}
				if (cnt == 1) {
					r *= d;
				}
			}
			r *= v;
			if (!map.containsKey(r)) {
				map.put(r, map.size());
			}
			fs[map.get(r)]++;
		}
		cfs = new int[n];
		for (int i = 1; i < n; i++) {
			cfs[i] = cfs[i - 1] + fs[i - 1];
		}
		memo = new long[n+1][n+1];
		for(long[] arr : memo)
			Arrays.fill(arr, -1);
		System.out.println(go(0, 0));
	}

	static long go(int color, int priorities) {
		if (color == n)
			return priorities == 0 ? 1 : 0;
//		System.out.println(color + " "+  priorities);
		if(memo[color][priorities] != -1)
			return memo[color][priorities];
		int nonpriorities = cfs[color] - priorities + 1;
		long ans = 0;
		for (int cntPrio = 0; cntPrio <= priorities && cntPrio <= fs[color]; cntPrio++) {
			for (int cntNonPrio = 0; cntNonPrio <= nonpriorities && cntNonPrio + cntPrio <= fs[color]; cntNonPrio++) {
				if(cntPrio + cntNonPrio == 0 && fs[color] != 0) continue;
				int cntExtra = fs[color] - cntPrio - cntNonPrio;
				long tmp = choose(priorities, cntPrio);
				tmp *= choose(nonpriorities, cntNonPrio);
				tmp %= MOD;
				tmp *= multichoose(cntPrio + cntNonPrio, cntExtra);
				tmp %= MOD;
				tmp *= go(color + 1, priorities - cntPrio + cntExtra);
				tmp %= MOD;
				tmp *= fact[fs[color]];
				tmp %= MOD;
				
				ans += tmp;
				ans %= MOD;
			}
		}
		return memo[color][priorities] = ans;
	}

	static long[][] chooseTable(int n) {
		long[][] table = new long[n][];
		for (int x = 0; x < n; x++) {
			table[x] = new long[x + 1];
			table[x][0] = table[x][x] = 1;
			for (int y = 1; y < x; y++) {
				table[x][y] = table[x - 1][y - 1] + table[x - 1][y];
				table[x][y] %= MOD;
			}
		}
		return table;
	}

	static long choose(int n, int k) {
		if (k == 0)
			return 1;
		if (k >= choose[n].length) {
			return 0;
		}
		return choose[n][k];
	}

	static long multichoose(int n, int k) {
		return choose(n + k - 1, k);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream i) {
			br = new BufferedReader(new InputStreamReader(i));
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

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
