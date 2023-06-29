import java.io.*;
import java.util.*;

public class Main {
	
	void solve() {
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			b[i] = a[i];
		}
		Arrays.sort(b);
		int cnt = 0;
		for (int i = 0; i < n; ++i) {
			if (a[i] != b[i]) {
				++cnt;
			}
		}
		out.println(cnt <= 2 ? "YES" : "NO");
	}
	
	void run() {
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}
	
	InputReader in;
	PrintWriter out;
	
	class InputReader {
		BufferedReader br;
		StringTokenizer st;
		
		InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st = null;
		}
		
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}