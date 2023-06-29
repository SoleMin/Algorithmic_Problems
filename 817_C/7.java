import java.util.*;
import java.io.*;

public class CFEdu23C 
{
	static long sum(long n)
	{
		long ans=0;
		while(n>0)
		{
			ans+=(n%10);
			n/=10;
		}
		return ans;
	}
	static long BS(long l,long h,long s)
	{
		if(l<=h)
		{
			long m=(l+h)/2l;
			if(m-sum(m)>=s && (m==1 || (m-1)-sum(m-1)<s))
				return m;
			else if(m-sum(m)>=s)
				return BS(l, m-1, s);
			else
				return BS(m+1, h, s);
		}
		return (h+1);
	}
	public static void main(String args[]) {
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		/*------------------------------My Code starts here------------------------------*/
		long n=in.nextLong(),s=in.nextLong();
		long x=BS(0,n,s);
		out.print(n-x+1);
		out.close();
		/*------------------------------The End------------------------------------------*/
	}

	public static final long l = (int) (1e9 + 7);

	private static int[] nextIntArray(InputReader in, int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		return a;
	}

	private static long[] nextLongArray(InputReader in, int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextLong();
		return a;
	}

	private static int[][] nextIntMatrix(InputReader in, int n, int m) {
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				a[i][j] = in.nextInt();
		}
		return a;
	}

	private static void show(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	private static void show2DArray(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j]);
			System.out.println();
		}
	}

	static class Pair {
		private int first;
		private int second;

		public Pair(int i, int j) {
			this.first = i;
			this.second = j;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}

		public void setFirst(int k) {
			this.first = k;
		}

		public void setSecond(int k) {
			this.second = k;
		}
	}

	static int modPow(int a, int b, int p) {
		int result = 1;
		a %= p;
		while (b > 0) {
			if ((b & 1) != 0)
				result = (result * a) % p;
			b = b >> 1;
			a = (a * a) % p;
		}
		return result;
	}

	public static void SieveOfEratosthenes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[1] = false;
		int i, j;
		for (i = 2; i * i <= n; i++) {
			if (prime[i]) {
				for (j = i; j <= n; j += i) {
					if (j != i)
						prime[j] = false;
				}
			}
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine() {
			String fullLine = null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine = reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}

}
