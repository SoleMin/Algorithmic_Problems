import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class d {
	
	double a, v, l, d, w;

	private void solve() throws Exception {
		a = nextInt(); v = nextInt(); l = nextInt(); d = nextInt(); w = nextInt();
		double ans;
		if (w >= v){
			ans = fromSign(0, l);
		}
		else{
			double tToW = w / a;
			double dToW = tToW * tToW * a / 2.;
			if (dToW > d){
				double curT = Math.sqrt(d * 2. / a);
				ans = curT;
				double curV = a * curT;
				ans += fromSign(curV, l - d);
			}
			else{
				double tToMax = v / a;
				double dToMax = tToMax * tToMax * a / 2.;
				double tFromMax = (v - w) / a;
				double dFromMax = tFromMax * v - tFromMax * tFromMax * a / 2.;
				if (dToMax + dFromMax <= d){
					ans = tToMax + tFromMax + (d - dToMax - dFromMax) / v;
				}
				else{
					double lo = w, hi = v;
					for (int i = 0; i < 1000; ++i){
						double mi = (lo + hi) / 2.;
						double tTo = mi / a;
						double dTo = tTo * tTo * a / 2.;
						double tFrom = (mi - w) / a;
						double dFrom = tFrom * mi - tFrom * tFrom * a / 2.;
						if (dTo + dFrom <= d)
							lo = mi;
						else
							hi = mi;
					}
					ans = lo / a + (lo - w) / a;
				}
				ans += fromSign(w, l - d);
			}
		}
		out.printf("%.8f", ans);
	}

	private double fromSign(double curV, double d) {
		double tToMax = (v - curV) / a;
		double dToMax = tToMax * curV + tToMax * tToMax * a / 2.;
		if (dToMax <= d){
			return tToMax + (d - dToMax) / v;
		}
		else{
			double lo = 0, hi = tToMax;
			for (int i = 0; i < 1000; ++i){
				double mi = (lo + hi) / 2.;
				double curD = mi * curV + mi * mi * a / 2.;
				if (curD <= d)
					lo = mi;
				else
					hi = mi;
			}
			return lo;
		}
	}

	public void run() {
		try {
			solve();
		} catch (Exception e) {
			NOO(e);
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	BufferedReader in;
	StringTokenizer St;

	void NOO(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	String nextToken() {
		while (!St.hasMoreTokens()) {
			try {
				String line = in.readLine();
				St = new StringTokenizer(line);
			} catch (Exception e) {
				NOO(e);
			}
		}
		return St.nextToken();
	}

	private d(String name) {
		try {
			in = new BufferedReader(new FileReader(name + ".in"));
			St = new StringTokenizer("");
			out = new PrintWriter(new FileWriter(name + ".out"));
		} catch (Exception e) {
			NOO(e);
		}
	}

	private d() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			St = new StringTokenizer("");
			out = new PrintWriter(System.out);
		} catch (Exception e) {
			NOO(e);
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		new d(/*"d"*/).run();
	}

}
