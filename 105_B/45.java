import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution implements Runnable {

	public static void main(String[] args) {
		(new Thread(new Solution())).start();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String r = in.readLine();
			if (r == null) return null;
			st = new StringTokenizer(r);
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	int n;
	int[] b, l;
	double ans;
	int[] sw;
	int a;
	
	void sol() {
		for (int i = 0; i < n; i++) l[i] += sw[i] * 10;
		double yes = 0;
		for (int q = 0; q < (1 << n); q++) {
			double p = 1;
			int bb = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if ((q & (1 << i)) == 0) {
					p *= (1.0 - (double)l[i] / 100);
					bb += b[i];
				} else {
					p *= 1.0 * (double)l[i] / 100;
					cnt++;
				}
			}
			if (cnt > n / 2) {
				yes += p;
			} else {
				yes += p * (double)a / (double)(a + bb); 
			}
		}
		if (ans < yes) ans = yes;
		for (int i = 0; i < n; i++) l[i] -= sw[i] * 10;
	}
	
	void rek(int i, int k) {
		if (i == n) sol(); else {
			for (int q = 0; q <= k && l[i] + q * 10 <= 100; q++) {
				sw[i] = q;
				rek(i + 1, k - q);
			}
		}
	}
	
	void solve() throws Exception {
		n = nextInt();
		int k = nextInt();
		a = nextInt();
		b = new int[n];
		l = new int[n];
		sw = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = nextInt();
			l[i] = nextInt();
		}
		rek(0, k);
		out.printf("%.10f", ans);
	}

	public void run() {
		Locale.setDefault(Locale.UK);
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
//			in = new BufferedReader(new FileReader("knights.in"));
//			out = new PrintWriter("knights.out");
			solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			out.flush();
		}
	}

}