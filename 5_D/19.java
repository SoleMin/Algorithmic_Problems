import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.math.BigInteger;

public class Main {
	final int INF = 1000000000;
	final int MAXN = 100100;	
	
	Scanner input = new Scanner(System.in);
	BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		new Main().run();
	}
	
	double a, v;
	double l, d, w;
	
	void run() throws IOException {
		a = input.nextDouble();
		v = input.nextDouble();
		l = input.nextDouble();
		d = input.nextDouble();
		w = input.nextDouble();
		if (v <= w) {
			out.println(timeTravel(l, 0));
		} else {
			double tw = w / a;
			double dw = dist(tw, 0);
			if (dw >= d) {
				out.println(timeTravel(l, 0));
			} else {
				double tSym = timeTravel((d - dw) / 2, w);
				out.println(tw + 2 * tSym + timeTravel(l - d, w));
			}
		}
		out.close();
	}	
	
	double dist(double time, double speed) {
		return speed * time + a * time * time / 2; 
	}
	
	double timeTravel(double distance, double speed) {
		double delta = speed * speed + 2 * a * distance;
		double tAll = (Math.sqrt(delta) - speed) / a;
		double tMax = (v - speed) / a;
		if (tMax >= tAll) {
			return tAll;
		} else {
			return tMax + (distance - dist(tMax, speed)) / v;
		}
	}
}