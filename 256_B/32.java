import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	long fang(int s, int x, int y) {
		if (x > y) { int t = x; x = y; y = t; }
		if (s + 1 <= x) {
			return (long)(s + 1) * (s + 2) / 2;
		}
		if (s + 1 <= y) {
			return (long)x * (x + 1) / 2 + (long)(s + 1 - x) * x;
		}
		if (s + 1 >= x + y - 1) {
			return (long)x * y;
		}
		long q = x + y - 1 - s - 1;
		return (long)x * y - q * (q + 1) / 2;
	}
	
	long f(int s, int n, int x, int y) {
		long ans = fang(s, n - x + 1, n - y + 1) + fang(s, n - x + 1, y) + fang(s, x, n - y + 1) + fang(s, x, y);
		ans -= Math.min(s + 1, n - x + 1) + Math.min(s + 1, x) + Math.min(s + 1, n - y + 1) + Math.min(s + 1, y);
		return ans + 1;
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int x = nextInt(), y = nextInt();
		long c = nextInt();
		if (c == 1) {
			out.println(0);
			return;
		}
		int bg = 0, ed = 2 * n;
		while (ed > bg + 1) {
			int mm = (bg + ed) / 2;
			if (f(mm, n, x, y) >= c) ed = mm; else bg = mm;
		}
		out.println(ed);
	}
	
	void run() {
		try {
			Locale.setDefault(Locale.US);
//			in = new BufferedReader(new FileReader("input.txt"));
//			out = new PrintWriter("output.txt");
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().run();
	}

}
