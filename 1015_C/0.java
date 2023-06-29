import java.io.*;
import java.math.*;
import java.sql.Array;
import java.util.*;

public class A {

	static int INF = 1000000007;

	public static void main(String[] args) {
		// int test = fs.nextInt();
		int test = 1;
		for (int cases = 0; cases < test; cases++) {
			int n = fs.nextInt();
			long m = fs.nextLong();
			long sum = 0;
			LongPair ar[] = new LongPair[n];
			for (int i = 0; i < n; i++) {
				ar[i] = new LongPair(fs.nextLong(), fs.nextLong());
				sum += ar[i].first;
			}
			if (sum <= m) {
				System.out.println(0);
			} else {
				Arrays.sort(ar, new Comparator<LongPair>() {
					@Override
					public int compare(LongPair o1, LongPair o2) {
						return (int) ((o1.first - o1.second) - (o2.first - o2.second));
					}
				});
				int end = n - 1;
				int moves = 0;
				while (end >= 0) {
					if (sum <= m) {
						break;
					}
					sum -= ar[end].first;
					sum += ar[end].second;
					--end;
					++moves;
				}
				if (sum > m) {
					System.out.println(-1);
				} else {
					System.out.println(moves);
				}
			}

		}

	}

	static void sort(double[] a) {
		ArrayList<Double> l = new ArrayList<>();
		for (double i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

	static long modInverse(long n, long p) {
		return power(n, p - 2, p);
	}

	static long nCrModPFermat(long n, long r, long p) {
		long ans1 = 1;
		long i = n;
		long k = r;
		while (k > 0) {
			ans1 = mul(ans1, i, p);
			i--;
			k--;
		}
		long ans2 = 1;
		while (r > 0) {
			ans2 = mul(ans2, r, p);
			r--;
		}
		r = modInverse(ans2, p);
		ans1 = mul(ans1, r, p);
		return ans1;
	}

	static long facCalc(long total) {
		long ans = 1;
		for (long i = 2; i <= total; i++) {
			ans = mul(ans, i, INF);
		}
		return ans;
	}

	static long mul(long a, long b, long p) {
		return ((a % p) * (b % p)) % p;
	}

	static void sieve() {
		boolean prime[] = new boolean[101];
		Arrays.fill(prime, true);
		prime[1] = false;
		for (int i = 2; i * i <= prime.length - 1; i++) {
			for (int j = i * i; j <= prime.length - 1; j += i) {
				prime[j] = false;
			}
		}
	}

	public static int[] radixSort(int[] f) {
		return radixSort(f, f.length);
	}

	public static int[] radixSort(int[] f, int n) {
		int[] to = new int[n];
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] & 0xffff)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] & 0xffff]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		{
			int[] b = new int[65537];
			for (int i = 0; i < n; i++)
				b[1 + (f[i] >>> 16)]++;
			for (int i = 1; i <= 65536; i++)
				b[i] += b[i - 1];
			for (int i = 0; i < n; i++)
				to[b[f[i] >>> 16]++] = f[i];
			int[] d = f;
			f = to;
			to = d;
		}
		return f;
	}

	static class Pair {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

	static class LongPair {
		long first;
		long second;

		LongPair(long a, long b) {
			this.first = a;
			this.second = b;
		}

		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

	static long expmodulo(long a, long b, long c) {
		long x = 1;
		long y = a;
		while (b > 0) {
			if (b % 2 == 1) {
				x = (x * y) % c;
			}
			y = (y * y) % c; // squaring the base
			b /= 2;
		}
		return (long) x % c;
	}

	// static int modInverse(int a, int m) {
	// int m0 = m;
	// int y = 0, x = 1;
	//
	// if (m == 1)
	// return 0;
	//
	// while (a > 1) {
	// int q = a / m;
	// int t = m;
	// m = a % m;
	// a = t;
	// t = y;
	// y = x - q * y;
	// x = t;
	// }
	// if (x < 0)
	// x += m0;
	// return x;
	// }

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	static void sortMyMapusingValues(HashMap<Integer, Integer> hm) {

		List<Map.Entry<Integer, Integer>> capitalList = new LinkedList<>(hm.entrySet());

		Collections.sort(capitalList, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		HashMap<Integer, Integer> result = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : capitalList) {
			result.put(entry.getKey(), entry.getValue());
		}
	}

	static void primeFactors(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n /= 2;
		}
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n /= i;
			}
		}
		if (n > 2)
			System.out.print(n);
	}

	static boolean isPrime(long n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		long sq = (long) Math.sqrt(n);
		for (int i = 5; i <= sq; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println() {
			writer.print("\n");
		}

		public void printLine(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}

	}

	private static final FastReader fs = new FastReader();
	private static final OutputWriter op = new OutputWriter(System.out);
}