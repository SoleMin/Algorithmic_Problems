import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {

	void solve() {
		double a = sc.nextDouble();
		double v = sc.nextDouble();
		double l = sc.nextDouble();
		double d = sc.nextDouble();
		double w = sc.nextDouble();

		double res = calc(a, v, l, d, w);
		out.printf("%.10f\n", res);

	}




	double calc(double a, double v, double l, double d, double w) {
		if (v <= w) return getTime(a, 0, l, v);

		// 距離 d までに速度 w に達しない場合
		if ((w * w) >= d * 2 * a) return getTime(a, 0, l, v);

		// それ以外は、d は速度wで通過
		double ans = 0;

		double[] r1 = getReach(a, 0, v);
		double[] r2 = getReach(a, w, v);

		// d までに最高速度 v に達する場合
		if (r1[1] + r2[1] <= d) {
			ans += r1[0];
			ans += r2[0];
			ans += (d - r1[1] - r2[1]) / v;
		} else {
			// d までに最高速度に達しない場合
			double t0 = sqrt((2 * a * d + w * w) / (2 * a * a));
			ans += t0 + (a * t0 - w) / a;
		}

		ans += getTime(a, w, l - d, v);
		return ans;

	}

	/**
	 *  s から v に達するまでの時間と、その間の走行距離
	 */
	double[] getReach(double a, double s, double v) {
		double t = (v - s) / a;
		double dist = t * (v + s) / 2.0;
		return new double[]{t, dist};
	}


	/**
	 * 初速 s、加速a、 最高速度 v で距離 l を走るのにかかる時間
	 */
	double getTime(double a, double s, double l, double v) {
		double t = (-s + sqrt(s * s + 2 * a * l)) / a;
		double t_ = (v - s) / a;
		if (t < t_) return t;

		double p = l - (s + v) * t_ / 2;
		return t_ + (p / v);
	}

	public static void main(String[] args) throws Exception {
		Class<?> here = new Object(){}.getClass().getEnclosingClass();
		try {
			String packageName = here.getPackage().getName();
			packageName = "src/" + packageName.replaceAll("\\.", "/") + "/";
			System.setIn(new FileInputStream(packageName + "input.txt"));
//			System.setOut(new PrintStream(new FileOutputStream(packageName + "output.txt")));
		} catch (FileNotFoundException e) {
		} catch (NullPointerException e) {
		}

		Object o = Class.forName(here.getName()).newInstance();
		o.getClass().getMethod("run").invoke(o);
	}

	static void tr(Object... os) {
		System.err.println(deepToString(os));
	}

	MyScanner sc = null;
	PrintWriter out = null;
	public void run() throws Exception {
		sc = new MyScanner(System.in);
		out = new PrintWriter(System.out);
		for (;sc.hasNext();) {
			solve();
			out.flush();
		}
		out.close();
	}

	void print(int[] a) {
		out.print(a[0]);
		for (int i = 1; i < a.length; i++) out.print(" " + a[i]);
		out.println();
	}

	class MyScanner {
		String line;
		BufferedReader reader;
		StringTokenizer tokenizer;

		public MyScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}
		public void eat() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					line = reader.readLine();
					if (line == null) {
						tokenizer = null;
						return;
					}
					tokenizer = new StringTokenizer(line);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public String next() {
			eat();
			return tokenizer.nextToken();
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		public boolean hasNext() {
			eat();
			return (tokenizer != null && tokenizer.hasMoreElements());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
	}
}
