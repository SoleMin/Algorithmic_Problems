import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					long prevTime = System.currentTimeMillis();
					new Main().run();
					System.err.println("Total time: "
							+ (System.currentTimeMillis() - prevTime) + " ms");
					System.err.println("Memory status: " + memoryStatus());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start();
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Object o = solve();
		if (o != null)
			out.println(o);
		out.close();
		in.close();
	}

	int n;
	Point[] ps;
	int[] dp;

	private Object solve() throws IOException {
		int o_x = ni();
		int o_y = ni();

		n = ni();
		ps = new Point[n];
		for (int i = 0; i < n; i++)
			ps[i] = new Point(ni() - o_x, ni() - o_y);

		dp = new int[1 << n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] path_x = new int[1 << n];
		int[] path_y = new int[1 << n];
		
		for (int mask = 1; mask < (1 << n); mask++) {
			int i = min(mask);
			int min_val = dp[mask - (1 << i)] + 2 * ps[i].norm;
			if (min_val < dp[mask]) {
				dp[mask] = min_val;
				path_x[mask] = i;
				path_y[mask] = i;
				
			}
			for (int j = i + 1; j < n; j++)
				if ((mask & (1 << j)) != 0) {
					int newMask = mask - (1 << i) - (1 << j);
					int val = dp[newMask] + ps[i].norm + ps[j].norm
							+ ps[i].dist(ps[j]);
					if (val < dp[mask]) {
						dp[mask] = val;
						path_x[mask] = i;
						path_x[mask] = j;
						
					}
				}
		}
		pln(dp[(1 << n) - 1]);

		int maskPath = (1 << n) - 1;
		LinkedList<Long> list = new LinkedList<Long>();
		while (maskPath != 0) {
			long x = path_x[maskPath];
			long y = path_y[maskPath];
			
			list.addFirst(0L);
			list.addFirst(y + 1);
			maskPath -= (1 << y);
			if (x != y) {
				list.addFirst(x + 1);
				maskPath -= 1 << x;
			}
		}
		list.addFirst(0L);
		show(list);
		return null;
	}

	private int min(int mask) {
		int ret = 0;
		while (mask % 2 == 0) {
			mask /= 2;
			ret++;
		}
		return ret;
	}

	private void show(LinkedList<Long> list) {
		int index = 0;
		for (long a : list) {
			if (index == 0) {
				p(a);
			} else {
				p(" " + a);
			}
			index++;
		}
		pln();
	}

	class Point {
		int x;
		int y;
		int norm;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
			this.norm = x * x + y * y;
		}

		public int dist(Point other) {
			int dx = (x - other.x);
			int dy = (y - other.y);

			return dx * dx + dy * dy;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", norm=" + norm + "]";
		}

	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer strTok = new StringTokenizer("");

	String nextToken() throws IOException {
		while (!strTok.hasMoreTokens())
			strTok = new StringTokenizer(in.readLine());
		return strTok.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nl() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nd() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int[] nia(int size) throws IOException {
		int[] ret = new int[size];
		for (int i = 0; i < size; i++)
			ret[i] = ni();
		return ret;
	}

	long[] nla(int size) throws IOException {
		long[] ret = new long[size];
		for (int i = 0; i < size; i++)
			ret[i] = nl();
		return ret;
	}

	double[] nda(int size) throws IOException {
		double[] ret = new double[size];
		for (int i = 0; i < size; i++)
			ret[i] = nd();
		return ret;
	}

	String nextLine() throws IOException {
		strTok = new StringTokenizer("");
		return in.readLine();
	}

	boolean EOF() throws IOException {
		while (!strTok.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			strTok = new StringTokenizer(s);
		}
		return false;
	}

	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}

	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array, String spec) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}

	void printArray(Object[] array) {
		boolean blank = false;
		for (Object x : array) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		boolean blank = false;
		for (Object x : collection) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory() >> 20)
				+ "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}

	public void pln() {
		out.println();
	}

	public void pln(int arg) {
		out.println(arg);
	}

	public void pln(long arg) {
		out.println(arg);
	}

	public void pln(double arg) {
		out.println(arg);
	}

	public void pln(String arg) {
		out.println(arg);
	}

	public void pln(boolean arg) {
		out.println(arg);
	}

	public void pln(char arg) {
		out.println(arg);
	}

	public void pln(float arg) {
		out.println(arg);
	}

	public void pln(Object arg) {
		out.println(arg);
	}

	public void p(int arg) {
		out.print(arg);
	}

	public void p(long arg) {
		out.print(arg);
	}

	public void p(double arg) {
		out.print(arg);
	}

	public void p(String arg) {
		out.print(arg);
	}

	public void p(boolean arg) {
		out.print(arg);
	}

	public void p(char arg) {
		out.print(arg);
	}

	public void p(float arg) {
		out.print(arg);
	}

	public void p(Object arg) {
		out.print(arg);
	}

}