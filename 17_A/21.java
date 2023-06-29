import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists())
				System.setIn(new FileInputStream("input.txt"));
		} catch (SecurityException e) {
		}
		new Thread() {
			public void run() {
				try {
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	private void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		boolean[] pr = new boolean[1001];
		for (int i = 2; i <= 1000; i++)
			if (!pr[i]) {
				int l = 2 * i;
				while (l <= 1000) {
					pr[l] = true;
					l += i;
				}
			}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 2; i < 1000; i++) {
			for (int j = i + 1; j <= 1000; j++) {
				if (!pr[j]) {
					set.add(j + i + 1);
					i = j - 1;
					break;
				}
			}
		}
		int n = nextInt();
		int k = nextInt();
		int res = 0;
		for (int i = 2; i <= n; i++) {
			if (set.contains(i) && !pr[i])
				res++;
		}
		if (res >= k)
			out.println("YES");
		else
			out.println("NO");
		
		in.close();
		out.close();
	}

	void chk(boolean b) {
		if (b)
			return;
		System.out.println(new Error().getStackTrace()[1]);
		exit(999);
	}
	void deb(String fmt, Object... args) {
		System.out.printf(Locale.US, fmt + "%n", args);
	}
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
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
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
