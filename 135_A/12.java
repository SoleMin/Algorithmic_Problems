import static java.util.Arrays.deepToString;

import java.io.*;
import java.math.*;
import java.util.*;

public class A {

	static int [] solve(int [] a) {
		int n = a.length;
		Arrays.sort(a);
		a[n - 1] = (a[n - 1] > 1 ? 1 : 2);
		int [] b = Arrays.copyOf(a, n);
		Arrays.sort(b);
		return b;
	}

	public static void main(String[] args) throws Exception {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);

		setTime();
		
		int n = nextInt();
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		int [] b = solve(a);
		for (int v: b) {
			writer.print(v + " ");
		}
		
		printTime();
		printMemory();

		writer.close();
	}

	static BufferedReader reader;
	static PrintWriter writer;
	static StringTokenizer tok = new StringTokenizer("");
	static long systemTime;

	static void debug(Object... o) {
		System.err.println(deepToString(o));
	}

	static void setTime() {
		systemTime = System.currentTimeMillis();
	}

	static void printTime() {
		System.err.println("Time consumed: " + (System.currentTimeMillis() - systemTime));
	}

	static void printMemory() {
		System.err.println("Memory consumed: "
				+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + "kb");
	}

	static String next() {
		while (!tok.hasMoreTokens()) {
			String w = null;
			try {
				w = reader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (w == null)
				return null;
			tok = new StringTokenizer(w);
		}
		return tok.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}

	static long nextLong() {
		return Long.parseLong(next());
	}

	static double nextDouble() {
		return Double.parseDouble(next());
	}

	static BigInteger nextBigInteger() {
		return new BigInteger(next());
	}
}