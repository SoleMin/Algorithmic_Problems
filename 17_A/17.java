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
	
	void solve() throws Exception {
		boolean[] r = new boolean[1010];
		Arrays.fill(r, true);
		r[0] = r[1] = false;
		for (int i = 2; i < 1010; i++) {
			if (r[i]) {
				for (int j = i + i; j < 1010; j += i) {
					r[j] = false;
				}
			}
		}
		int[] pr = new int[1010];
		int l = 0;
		for (int i = 2; i < 1010; i++) if (r[i]) pr[l++] = i;
		int n = nextInt();
		int k = nextInt();
		int ans = 0;
		int j = 0;
		for (int i = 2; i <= n; i++) {
			if (r[i]) {
			for (; j < l - 1; j++) {
				if (i == pr[j] + pr[j + 1] + 1) {
					ans++;
					break;
				}
				if (i < pr[j] + pr[j + 1] + 1) break;
			}
			}
		}
		if (ans >= k) out.println("YES"); else out.println("NO");
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
