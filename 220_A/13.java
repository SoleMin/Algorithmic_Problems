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
	
	int fu(int[] a, int l) {
		for (int i = l; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) return i;
		}
		return a.length;
	}
	
	void swap(int[] a, int q, int w) {
		int t = a[q]; a[q] = a[w]; a[w] = t;
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = nextInt();
		int q = fu(a, 0);
		if (q == n) out.println("YES"); else {
			int w = fu(a, q + 1);
			if (w < n) {
				boolean ans = false;
				swap(a, q, w);
				ans |= fu(a, 0) == n;
				swap(a, q, w);
				if (q < n - 1) {
					swap(a, q + 1, w);
					ans |= fu(a, 0) == n;
					swap(a, q + 1, w);
				}
				if (w < n - 1) {
					swap(a, q, w + 1);
					ans |= fu(a, 0) == n;
					swap(a, q, w + 1);
				}
				if (q < n - 1 && w < n - 1) {
					swap(a, q + 1, w + 1);
					ans |= fu(a, 0) == n;
					swap(a, q + 1, w + 1);
				}
				if (ans) out.println("YES"); else out.println("NO");
			} else {
				int j = q + 1;
				while (j < n && a[j] == a[q + 1]) j++;
				j--;
				swap(a, q, j);
				if (fu(a, 0) == n) out.println("YES"); else {
					swap(a, q, j);
					q++;
					j = q - 1;
					while (j >= 0 && a[j] == a[q - 1]) j--;
					j++;
					swap(a, q, j);
					if (fu(a, 0) == n) out.println("YES"); else out.println("NO");
				}
			}
		}
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