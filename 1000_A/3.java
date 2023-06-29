import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	private PrintWriter pw;
	private long mod = 1000000000 + 7;

	private StringBuilder ans_sb;
	private int size = 1000005;
	private long[] fact;
	private void soln() {
		int n = nextInt();
		HashMap<String, Integer>[] s1 = new HashMap[4];
		for(int i=0;i<=3;i++) {
			s1[i] = new HashMap<>();
		}
		int cnt = 0;
		for(int i=0;i<n;i++) {
			String s = nextLine();
			if(s1[s.length()-1].containsKey(s)) {
				s1[s.length()-1].put(s, s1[s.length()-1].get(s)+1);
			}else
				s1[s.length()-1].put(s, 1);
		}
		for(int i=0;i<n;i++) {
			String s = nextLine();
			if(s1[s.length()-1].containsKey(s)) {
				s1[s.length()-1].put(s, s1[s.length()-1].get(s)-1);
				if(s1[s.length()-1].get(s) == 0)
					s1[s.length()-1].remove(s);
			}else {
				cnt++;
			}
		}
		pw.println(cnt);
	}
	private class Pair implements Comparable<Pair>{
		long x, y; 
		int i;
		public Pair(long a,long b,int c) {
			x = a;
			y = b;
			i = c;
		}
		@Override
		public int compareTo(
				Pair o)
		{
			return Long.compare(this.x, o.x);
		}
		public String toString() {
			return ""+i;
		}
	}
	private void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	private long pow(long a, long b, long c) {
		if (b == 0)
			return 1;
		long p = pow(a, b / 2, c);
		p = (p * p) % c;
		return (b % 2 == 0) ? p : (a * p) % c;
	}

	private long gcd(long n, long l) {
		if (l == 0)
			return n;
		return gcd(l, n % l);
	}

	public static void main(String[] args) throws Exception {
		new Thread(null, new Runnable() {
			@Override
			public void run() {
				new Main().solve();
			}
		}, "1", 1 << 26).start();
		//new Main().solve();
	}

	public StringBuilder solve() {
		InputReader(System.in);
		/*
		 * try { InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\in.txt"));
		 * } catch(FileNotFoundException e) {}
		 */
		pw = new PrintWriter(System.out);
		// ans_sb = new StringBuilder();
		soln();

		pw.close();
		// System.out.println(ans_sb);
		return ans_sb;
	}

	public void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	private int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private String nextToken() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private String nextLine() {
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

	private int[] nextIntArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		return arr;
	}

	private long[] nextLongArray(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextLong();
		}
		return arr;
	}

	private void pArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private void pArray(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private char nextChar() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		char c1 = (char) c;
		while (!isSpaceChar(c))
			c = read();
		return c1;
	}

	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}