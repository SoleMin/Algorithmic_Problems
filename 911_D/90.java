import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;



public class d {
	
	
	public static void main(String args[]) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		//BEGIN HERE
		int n = in.nextInt();
		int perm[] = new int[n];
		for(int i  = 0; i < n; i++) {
			perm[i] = in.nextInt();
		}
		int q = in.nextInt();
		
		int inv[] = new int[n];
		inv[0] = 0;
		for(int i = 1; i < n; i++) {
			inv[i] = inv[i-1];
			for(int j = i - 1; j >= 0; j--) {
				if(perm[i] < perm[j]) inv[i]++;
			}
		}
		boolean parity = inv[n-1] % 2 == 0;
		
		for(int i = 0; i < q; i++) {
			int l = in.nextInt() - 1;
			int r = in.nextInt() -1; 
			if(l == r) {
				System.out.println(parity?"even":"odd");
				continue;
			}

			int s = r - l + 1;
			s = s * (s-1)/ 2;
			if(s % 2 != 0) {
				parity = !parity;
			}
			System.out.println(parity?"even":"odd");
		}
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
