import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
	
	void solve() throws Exception {
		int n = nextInt();
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		Integer[] b = a.clone();
		Arrays.sort(b);
		int d = 0;
		for (int i = 0; i < n; i++) {
			if (!a[i].equals(b[i])) d++;
		}
		out.println(d > 2? "NO" : "YES");
	}

	public void run() {
		try {
			Locale.setDefault(Locale.UK);
			in = new BufferedReader(new InputStreamReader(System.in));
			// in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter(System.out);
			// out = new PrintWriter("output.txt");
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		// new Thread(null, new Solution(), "1", 1 << 28).start();
		(new Solution()).run();
	}

}