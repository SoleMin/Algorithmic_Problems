import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		int n = nextInt();
		int[] a = new int[n];
		String s = next();
		for (int i = 0; i < n; i++)
			a[i] = s.charAt(i) == 'H' ? 1 : 0;
		int res = 10 * n;
		for (int i = 0; i < n; i++) {
			int[] b = new int[n];
			for (int j = 0; j < n; j++)
				b[j] = a[(i + j) % n];
			res = Math.min(res, solve(b, 0));
			res = Math.min(res, solve(b, 1));
		}
		out.print(res);
	}

	private int solve(int[] a, int x) {
		int n = a.length;		
		int j;
		for (j = n - 1; j >= 0; j--)
			if (a[j] == x)
				break;
		if (a[j] != x) return 0;
		int res = 0;
		for (int i = 0; i < j; i++)
			if (a[i] != x) {
				--j;
				while (j >= i && a[j] != x)
					--j;
				++res;
			}
		return res;
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
