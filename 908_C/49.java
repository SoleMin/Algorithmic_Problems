import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C908 {
	
	public static class mPoint implements Comparable<mPoint> {
		public double a, b;
		public mPoint(int a, double b) {
			this.a = a; this.b = b;
		}
		public int compareTo(mPoint p) {
			return b < p.b ? 1 : (b > p.b) ? -1 : 0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), r = in.nextInt();
		int[] ar = new int[n];
		ArrayList<mPoint> disks = new ArrayList<>();
		double[] ans = new double[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
			double max = -1;
			for (int j = 0; j < disks.size(); j++) {
				if (inRange(ar[i], disks.get(j).a, r)) {
					double h = 4*r*r - (ar[i]-disks.get(j).a) * (ar[i]-disks.get(j).a);
					max = Math.max(max, Math.sqrt(h) + disks.get(j).b);
				}
			}
			mPoint p = null;
			if (max == -1) {
				p = new mPoint(ar[i], r);
			} else {
				p = new mPoint(ar[i], max);
			}
			disks.add(p);
			ans[i] = p.b;
		}
		for (int i = 0; i < ans.length - 1; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println(ans[ans.length - 1]);
	}
	
	public static boolean inRange(int a, double b, int r) {
		if (Math.abs(b - a) <= 2*r) return true; return false;
	}
	
}
