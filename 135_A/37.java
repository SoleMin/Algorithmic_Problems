//package round97;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String s = bf.readLine();
			if (s == null)
				return null;
			st = new StringTokenizer(s);
		}

		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static String nextStr() throws IOException {
		return nextToken();
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		Arrays.sort(a);
		
		for (int q = 0; q < n; q++) {
			if (a[q] != 1) {
				out.print("1");
				for (int i = 1; i < n; i++) {
					out.print(" " + a[i - 1]);
				}
				out.flush();
				return;
			}
		}
		
		for (int i = 0; i < n - 1; i++) {
			out.print("1 ");
		}
		out.println("2");
		out.flush();
		
		
	}
}
