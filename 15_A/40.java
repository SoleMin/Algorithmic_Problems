import java.util.*;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double w = in.nextDouble();
		int tot = 2;
		Interval[] houses = new Interval[n];
		for(int i=0; i<n; i++) {
			double center = in.nextDouble();
			double wid = in.nextDouble();
			houses[i] = new Interval(center-wid/2,center+wid/2);
		}
		Arrays.sort(houses);
		for(int i=1; i<n; i++) {
			double dist = houses[i].s - houses[i-1].e;
			if(dist+1e-6 >= w) {
				tot+=2;
				if(Math.abs(w-dist) < 1e-6)
					tot--;
			}
		}
		System.out.println(tot);
	}
}
class Interval implements Comparable<Interval> {
	double s, e;
	Interval(double a, double b) {
		s=a;
		e=b;
	}
	public int compareTo(Interval i) {
		return (int)Math.signum(s-i.s);
	}
}
