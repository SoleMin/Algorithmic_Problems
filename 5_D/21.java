import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D5 implements Runnable {

	final double eps = 1e-9;

	private void Solution() throws IOException {
		double a = nextDouble(), v = nextDouble();
		double l = nextDouble(), d = nextDouble(), w = nextDouble();
		double t = 0;
		if (w + eps > v) {
			double s = v * v / (2 * a);
			if (s + eps > l)
				t = Math.sqrt(2 * l / a);
			else {
				double ta = v / a;
				double sa = a * ta * ta / 2;
				t = ta + (l - sa) / v;
			}
		} else {
			double sv = v * v / (2 * a);
			double sw = w * w / (2 * a);
			if (sw + eps > d) {
				if (sv + eps > l)
					t = Math.sqrt(2 * l / a);
				else {
					double ta = v / a;
					double sa = a * ta * ta / 2;
					t = ta + (l - sa) / v;
				}
			} else {
				double sd = (w * w - v * v) / (-2 * a);
				if (sv + sd < eps + d)
					t = v / a + (d - sv - sd) / v + (v - w) / a;
				else {
					double f = Math.sqrt(d * a + w * w / 2);
					t = f / a + (f - w) / a;
				}
				if (sd + eps > l - d) {
					double lv = Math.sqrt((l - d) * 2 * a + w * w);
					t += (lv - w) / a;
				} else {
					t += (v - w) / a + (l - d - sd) / v;
				}
			}
		}
		out.printf("%.12f", t);
	}

	public static void main(String[] args) {
		new D5().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			Solution();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	void print(Object... obj) {
		for (int i = 0; i < obj.length; i++) {
			if (i != 0)
				out.print(" ");
			out.print(obj[i]);
		}
	}

	void println(Object... obj) {
		print(obj);
		print("\n");
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(next());
	}

	String nextLine() throws IOException {
		return in.readLine();
	}

	String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}
}
