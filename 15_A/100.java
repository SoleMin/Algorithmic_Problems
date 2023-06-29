import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {
	
	public static void main(String[] args) {
		(new Thread(new Solution())).start();
	}
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
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
	
	class Dom implements Comparable<Dom>{
		int x, a;

		public int compareTo(Dom o) {
			return x - o.x;
		}
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int t = nextInt() * 2;
		Dom[] a = new Dom[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Dom();
			a[i].x = nextInt() * 2;
			a[i].a = nextInt();
		}
		Arrays.sort(a);
		int ans = 2;
		for (int i = 0; i < n - 1; i++) {
			if (t < a[i + 1].x - a[i + 1].a - a[i].x - a[i].a) ans += 2;
			if (t == a[i + 1].x - a[i + 1].a - a[i].x - a[i].a) ans += 1;
		}
		out.print(ans);
	}
	
	public void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
	}

}
