import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
 	
	public void solve () throws Exception {
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		TreeSet<Integer> bad = new TreeSet<>();
		int a [] = new int [n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		Arrays.sort(a);
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (!bad.contains(a[i])) {
				result++;
				long next = (long) a[i] * k;
				if (next <= 1000000000)
					bad.add((int) next);
			}
		}
		out.println(result);
	}
	
	BufferedReader in;
	PrintWriter out;
	FastScanner sc;

	static Throwable uncaught;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable t) {
			Solution.uncaught = t;
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) throws Throwable {
		Thread t = new Thread(null, new Solution(), "", (1 << 26));
		t.start();
		t.join();
		if (uncaught != null) {
			throw uncaught;
		}
	}

}

class FastScanner {

	BufferedReader reader;
	StringTokenizer strTok;

	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}

	public String nextToken() throws IOException {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

}