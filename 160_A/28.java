import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution implements Runnable {

	public static void main(String[] args) {
		(new Thread(null, new Solution(), "1", 1l << 28)).start();
	}

	public void run() {
		try {
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
	
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = null;
	
	String nextToken() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			//if (!in.ready()) return null;
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	
	void solve() throws Exception {
		int n = nextInt();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) sum += (a[i] = nextInt());
		Arrays.sort(a);
		int ans = 0;
		int s = 0;
		for (int i = n - 1; i >= 0; i--) {
			s += a[i]; ans++;
			if (2 * s > sum) break;
		}
		out.println(ans);
	}
	
}
