import java.util.Scanner;


public class Task5d {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double v = sc.nextDouble();
		double l = sc.nextDouble();
		double d = sc.nextDouble();
		double w = sc.nextDouble();
		double t = 0;
		if (w >= v) {
			double t1 = v / a;
			double s1 = a * t1 * t1 / 2;
			if (s1 > l) {
				t = Math.sqrt(2 * l / a);
			} else {
				t = t1 + (l - s1) / v;
			}
		} else {
			double t2 = Math.sqrt(2 * d / a);
			if (a * t2 <= w) {
				double t1 = v / a;
				double s1 = a * t1 * t1 / 2;
				if (s1 > l) {
					t = Math.sqrt(2 * l / a);
				} else {
					t = t1 + (l - s1) / v;
				}
			} else {
				double tup = v / a;
				double tdown = (v - w) / a;
				double sup = a * tup * tup / 2;
				double sdown = v * tdown - a * tdown * tdown / 2;
				if (sup + sdown <= d) {
					double tmax = (d - sup - sdown) / v;
					t = tup + tmax + tdown;					
				} else {
					double tw = w / a;
					double sw = a * tw * tw / 2;
					double sl = (d - sw) / 2;
					double dis = w * w + 2 * a * sl;
					double tu1 = (- w - Math.sqrt(dis)) / a;
					if (tu1 < 0) {
						tu1 = (- w + Math.sqrt(dis)) / a;
					}
					t = tw + 2 * tu1;
				}
				double sreup = w * tdown + a * tdown * tdown / 2;
				if (sreup <= l - d) {
					t += tdown;
					t += (l - d - sreup) / v;
				} else {
					double dis = w * w - 2 * a * (d - l);
					double tu1 = (- w - Math.sqrt(dis)) / a;
					if (tu1 < 0) {
						tu1 = (- w + Math.sqrt(dis)) / a;
					}
					t += tu1;
				}
			}
		}
		System.out.println(t);
	}

}
