import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = nextInt();
		int d = nextInt();
		int[]x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
		}
		int ans = 2;
		for (int i = 1; i < n; i++) {
			if (x[i]-x[i-1]==2*d)
				ans++;
			else if (x[i]-x[i-1] > 2*d)
				ans += 2;
		}
		System.out.println(ans);
		pw.close();
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}