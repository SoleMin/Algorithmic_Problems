import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Solution {
	
	class Q implements Comparable<Q> {
		int p, t;
		Q(int q, int w) {
			p = q; t = w;
		}
		@Override
		public int compareTo(Q arg0) {
			if (p == arg0.p) return t - arg0.t; 
			return arg0.p - p;
		}
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int k = nextInt() - 1;
		Q[] a = new Q[n];
		for (int i = 0; i < n; i++) a[i] = new Q(nextInt(), nextInt());
		Arrays.sort(a);
		int ans = 1;
		for (int i = k - 1; i >= 0; i--) if (a[i].compareTo(a[k]) == 0) ans++; else break;
		for (int i = k + 1; i < n; i++) if (a[i].compareTo(a[k]) == 0) ans++; else break;
		out.println(ans);
	}

	public static void main(String[] args) {
		new Solution().run();
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.close();
		}
	}
	
	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null) return null;
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;

}
