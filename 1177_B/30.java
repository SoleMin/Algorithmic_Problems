import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class Cses {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		// int t = sc.nextInt();
		// while (t-- > 0) {
		long n = sc.nextLong();

		if (n < 10) {
			System.out.println(n);
			return;
		} else {
			long sum = 0;
			long cur = 9;
			long prev = 0;
			int count = 1;

			while (n > cur) {
				n -= cur ;
				sum += cur / count;
				prev = cur;
				cur = 9 * (count + 1) * (long)Math.pow(10, count);
				count ++;
			}

			sum = sum + (n / count);

			if (n % count == 0) {
				System.out.println(sum % 10);
			} else {
				sum++;
				n = n % count;
				String s = String.valueOf(sum);
				System.out.println(s.charAt((int)n - 1));
			}
			// }
		}
	}

	public static boolean isSafe(int[][] chess, int row, int col) {
		for (int i = row - 1, j = col; i >= 0; i--) {
			if (chess[i][j] == 1) {
				return false;
			}
		}

		for (int i = col - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] == 1) {
				return false;
			}
		}

		for (int i = col - 1, j = row + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	static String swap(String str, int i, int j) {
		char temp;
		char[] ch = str.toCharArray();
		temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;

		return String.valueOf(ch);
	}

	static String rev(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		String s = sb.toString();
		return s;
	}

	static int swap(int a, int b) {
		return a;
	}

	static class pair {
		int first;
		int second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static long power(long a, long b) {
		long res = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				res = (res * a) % 1000000007;
			}
			a = (a * a) % 1000000007;
			b = b >> 1;
		}
		return res;
	}

	public static int pow(int a, int b) {
		int res = 1;
		while (b > 0) {
			if ((b & 1) != 0) {
				res = (res * a);
			}
			a = a * a;
			b = b >> 1;
		}
		return res;
	}

	public static String catoString(char[] ch) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}

	public static boolean isPrime(long n) {
		if (n < 2) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		long d = gcd(a, b);
		return (a * b) / d;
	}

	static boolean isPowerOfTwo(long n) {
		return (long)(Math.ceil(Math.log(n) / Math.log(2)))
		       == (long)(Math.floor(Math.log(n) / Math.log(2)));
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
			String str = " ";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}