import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
	public static BufferedReader in;
	public static PrintWriter out;

	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		boolean showLineError = true;
		if (showLineError) {
			solve();
			out.close();
		} else {
			try {
				solve();
			} catch (Exception e) {
			} finally {
				out.close();
			}
		}

	}

	static void debug(Object... os) {
		out.println(Arrays.deepToString(os));
	}

	private static void solve() throws IOException {
		String[] line = in.readLine().split(" ");
		long n = Long.parseLong(line[0]) - 1;
		long k = Long.parseLong(line[1]) - 1;
		if (f(1, k) < n) {
			out.println(-1);
			return;
		}
		if (n == 0) {
			out.println(0);
			return;
		}
		long lo = 0l;
		long hi = k;
		while (lo + 1l < hi) {
			long m = (lo + hi) / 2l;
			long f = f(k - m + 1, k);
			if (f < n) {
				lo = m;
			} else {
				hi = m;
			}
		}
		out.println(hi);

	}

	private static long f(long lo, long hi) {
		return (lo + hi) * (hi - lo + 1l) / 2l;
	}
}