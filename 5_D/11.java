import java.io.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main {

	private BufferedReader in;
	private BufferedWriter out;

	double time(double a, double l, double v0, double v) {
		double t = (v - v0) / a;
		double s = a * t * t / 2 + v0 * t;
		if (s <= l) {
			return t + (l - s) / v;
		}

		double B = v0, C = -l;
		double D = Math.sqrt(B * B - 2 * a * C);
		return (-B + D) / a;
	}

	// )(()()))(())))
	public void solve() throws Exception {
		StreamTokenizer st = new StreamTokenizer(in);
		st.nextToken();
		double a = st.nval;
		st.nextToken();
		double v = st.nval;
		st.nextToken();
		double l = st.nval;
		st.nextToken();
		double d = st.nval;
		st.nextToken();
		double w = st.nval;

		double ttt = Math.sqrt(2 * d / a);
		double ans = 0.0;

		if (w > v || ttt * a < w) {
			ans = time(a, l, 0, v);
		} else {
			double B = 2 * w / a, C = -w * w / (a * a) - 4 * d / a;
			double D = Math.sqrt(B * B - 4 * C);
			ans = (-B + D) / 2;
			if ((a * ans + w) / 2.0 > v) {
				double t1 = v / a;
				double t2 = (v - w) / a;
				double s = (a * t1 * t1 / 2.0) + (v * t2 - a * t2 * t2 / 2.0);
				ans = t1 + t2 + (d - s) / v;
			}
			ans += time(a, l - d, w, v);
		}
		DecimalFormat df = new DecimalFormat("0.000000000");
		out.write(df.format(ans) + "\n");
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {
		}
		new Main().run();
	}
}