import java.io.*;
import java.util.*;

public class trafficerules {
 	
 	public static void main(String[] args) throws Exception {
 		if ("Satayev".equals(System.getProperty("user.name"))) {
			long start = System.nanoTime();
			new trafficerules().solve(new FileInputStream("input"));
			System.err.printf("Time elapsed: %d ms.\n", (System.nanoTime()-start)/1000000);
		}
		else
			new trafficerules().solve(System.in);
 	}

 	void solve(InputStream is) throws Exception {
		Scanner in = new Scanner(is);
		
		double a = in.nextDouble(), maxv = in.nextDouble(), s = in.nextDouble(), d = in.nextDouble(), w = in.nextDouble();
		
		if (maxv < w)
			w = maxv;
		
		double t = 0;
		
		// v = at
		// s = att/2
		double t1 = w / a;
		double s1 = a*t1*t1/2;
		double v1 = w;
		if ( s1 < d ) {
			v1 = w;
			
			if (v1 >= maxv)
				t1 += (d-s1)/v1;
			else {
				double tt = (maxv - v1)/a;
				double ss = v1*tt+a*tt*tt/2;
				ss *= 2;
				if (s1 + ss < d)
					t1 += tt*2 + (d-s1-ss)/maxv;
				else {
					ss = (d-s1)/2;
					// ss = v1*t + a*t*t/2;
					double A = a/2;
					double B = v1;
					double C = -ss;
					double D = B*B - 4 * A * C;
					tt = (-B + Math.sqrt(D))/2/A;
					t1 += tt*2;
				}
			}
			
			s1 = d;
		}
		if (s1 > d) {
			s1 = d;
			t1 = Math.sqrt(2*s1/a);
			v1 = a * t1;
		}
		
		t += t1;
		
		double t2 = (maxv - v1) / a;
		double s2 = v1*t2 + a*t2*t2/2;
		double v2 = maxv;
		if (s1 + s2 < s) {
			v2 = maxv;
			t2 += (s-s1-s2)/v2;
		}
		if (s1 + s2 > s) {
			s -= s1;
			// v = v1 + a*t
			// s = v1*t + a*t*t/2
			double A = a/2;
			double B = v1;
			double C = -s;
			double D = B*B - 4*A*C;
			
			t2 = (-B + Math.sqrt(D))/2/A;
		}
		
		t += t2;
		
		System.out.println(t);
 	}

}