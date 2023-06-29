
import java.io.*;
import java.util.*;

public class D {

	static Scanner in = new Scanner(new BufferedInputStream(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	static double getTime(double v, double a, double l, double r) {
		return (-v + Math.sqrt(v * v - 2 * a * (l - r))) / a;
	}

	static double getVelocity(double v, double t, double l, double r) {
		return t == 0 ? v : (2 * (r - l)) / t - v;
	}

	public static void main(String[] args) throws IOException {
		double a = in.nextDouble(), v = in.nextDouble(), l = in.nextDouble(),
				d = in.nextDouble(), w = Math.min(v, in.nextDouble());

		double x = v * v / (2 * a), y = d - (v * v - w * w) / (2 * a),
				z = d + (v * v - w * w) / (2 * a);
		//out.println(x + " " + y + " " + z);
		double L, R, T = 0, V = 0, t;

		//OX
		L = 0;
		R = x;
		if (x > y && x < z) {
			R = (x + y) / 2;
		} else if (x > l) {
			R = l;
		}
		t = getTime(V, a, L, R);
		V = getVelocity(V, t, L, R);
		//out.println("l: " + L + ", r: " + R + ", t: " + t + ", v: " + V);
		T += t;

		//XY
		if (x < y) {
			T += (y - x) / v;
		}
		//out.println("t: " + (T - t));

		//YD
		L = y;
		R = d;
		if (x > y && x < z) {
			L = (x + y) / 2;
		} else if (x >= z) {
			L = R;
		}
		t = getTime(V, -a, L, R);
		V = getVelocity(V, t, L, R);
		T += t;
		//out.println("l: " + L + ", r: " + R + ", t: " + t + ", v: " + V);

		//DZ
		L = d;
		R = z;
		if (x >= z) {
			R = L;
		} else if (z > l) {
			R = l;
		}
		t = getTime(V, a, L, R);
		V = getVelocity(V, t, L, R);
		T += t;
		//out.println("l: " + L + ", r: " + R + ", t: " + t + ", v: " + V);

		//ZL
		L = z;
		R = l;
		if (x > z) {
			L = x;
		}
		if (L < R) {
			T += (R - L) / v;
		}

		out.format(Locale.US, "%.12f%n", T);
		out.close();
	}
}
