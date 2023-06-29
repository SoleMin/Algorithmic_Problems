import java.io.*;
import java.util.*;
 
 
 
public class Main {
	
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	static int oo = (int)1e9;
	static int mod = 1000000007;
	
	public static void main(String[] args) throws IOException {
 
		int n = in.nextInt();
		int[] a = in.nextIntArray(n);
		Arrays.sort(a);
		boolean[] color = new boolean[n];
		int cnt = 0;
		for(int i = 0; i < n; ++i) {
			if(!color[i]) {
				cnt++;
				for(int j = i; j < n; j++) {
					if(a[j] % a[i] == 0)
						color[j] = true;
				}
			}
		}
		System.out.println(cnt);
		
		out.close();
	}
	
	
	static class SegmentTree {
		int n;
		long[] a, seg;
		int DEFAULT_VALUE = 0;
		
		public SegmentTree(long[] a, int n) {
			super();
			this.a = a;
			this.n = n;
			seg = new long[n * 4 + 1];
			build(1, 0, n-1);
		}
		
		private long build(int node, int i, int j) {
			if(i == j)
				return seg[node] = a[i];
			long first = build(node * 2, i, (i+j) / 2);
			long second = build(node * 2 + 1, (i+j) / 2 + 1, j);
			return seg[node] = combine(first, second);
		}
		
		long update(int k, long value) {
			return update(1, 0, n-1, k, value);
		}
		
		private long update(int node, int i, int j, int k, long value) {
			if(k < i || k > j)
				return seg[node];
			if(i == j && j == k) {
				a[k] = value;
				seg[node] = value;
				return value;
			}
			
			int m = (i + j) / 2;
			long first = update(node * 2, i, m, k, value);
			long second = update(node * 2 + 1, m + 1, j, k, value);
			return seg[node] = combine(first, second);
		}
		
		long query(int l, int r) {
			return query(1, 0, n-1, l, r);
		}
		
		private long query(int node, int i, int j, int l, int r) {
			if(l <= i && j <= r)
				return seg[node];
			if(j < l || i > r)
				return DEFAULT_VALUE;
			int m = (i + j) / 2;
			long first = query(node * 2, i, m, l, r);
			long second = query(node * 2 + 1, m+1, j, l, r);
			return combine(first, second);
		}
 
		private long combine(long a, long b) {
			return a + b;
		}
	}
	
	static class DisjointSet {
		int n;
		int[] g;
		int[] h;
		public DisjointSet(int n) {
			super();
			this.n = n;
			g = new int[n];
			h = new int[n];
			for(int i = 0; i < n; ++i) {
				g[i] = i;
				h[i] = 1;
			}
		}
		int find(int x) {
			if(g[x] == x)
				return x;
			return g[x] = find(g[x]);
		}
		void union(int x, int y) {
			x = find(x); y = find(y);
			if(x == y)
				return;
			if(h[x] >= h[y]) {
				g[y] = x;
				if(h[x] == h[y])
					h[x]++;
			}
			else {
				g[x] = y;
			}
		}
	}
	
	
	static int[] getPi(char[] a) {
		int m = a.length;
		int j = 0;
		int[] pi = new int[m];
		for(int i = 1; i < m; ++i) {
			while(j > 0 && a[i] != a[j])
				j = pi[j-1];
			if(a[i] == a[j]) {
				pi[i] = j + 1;
				j++;
			}
		}
		return pi;
	}
	
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
	
	static boolean nextPermutation(int[] a) {
		for(int i = a.length - 2; i >= 0; --i) {
			if(a[i] < a[i+1]) {
				for(int j = a.length - 1; ; --j) {
					if(a[i] < a[j]) {
						int t = a[i];
						a[i] = a[j];
						a[j] = t;
						for(i++, j = a.length - 1; i < j; ++i, --j) {
							t = a[i];
							a[i] = a[j];
							a[j] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	static void shuffle(int[] a) {
		Random r = new Random();
		for(int i = a.length - 1; i > 0; --i) {
			int si = r.nextInt(i);
			int t = a[si];
			a[si] = a[i];
			a[i] = t;
		}
	}
	
	static void shuffle(long[] a) {
		Random r = new Random();
		for(int i = a.length - 1; i > 0; --i) {
			int si = r.nextInt(i);
			long t = a[si];
			a[si] = a[i];
			a[i] = t;
		}
	}
	
	static int lower_bound(int[] a, int n, int k) {
		int s = 0;
		int e = n;
		int m;
		while (e - s > 0) {
			m = (s + e) / 2;
			if (a[m] < k)
				s = m + 1;
			else
				e = m;
		}
		return e;
	}
	static int lower_bound(long[] a, int n, long k) {
		int s = 0;
		int e = n;
		int m;
		while (e - s > 0) {
			m = (s + e) / 2;
			if (a[m] < k)
				s = m + 1;
			else
				e = m;
		}
		return e;
	}
	
	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static class Pair implements Comparable<Pair> {
		int first, second;
 
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
 
		@Override
		public int compareTo(Pair o) {
			return this.first != o.first ? this.first - o.first : this.second - o.second;
		}
 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + first;
			result = prime * result + second;
			return result;
		}
 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (first != other.first)
				return false;
			if (second != other.second)
				return false;
			return true;
		}
	}
}
 
 
 
class InputReader {
 
	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;
 
	public InputReader(InputStream st) {
		this.stream = st;
	}
 
	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}
 
	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
 
}