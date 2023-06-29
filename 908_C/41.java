import java.util.*;
import java.io.*;
public class probC {
	static int r;
	static ArrayList<Circ> curr = new ArrayList<Circ>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		int[] xC = new int[n];
		for(int i = 0; i < n; i++)
			xC[i] = sc.nextInt();
		double ans[] = new double[n];
		ans[0] = r;
		curr.add(new Circ(xC[0], r));
		for(int i = 1; i < n; i++) {
			double max = r;
			for(int k = 0; k < curr.size(); k++) {
				double cur = curr.get(k).y+ Math.sqrt(4 * r*r - (xC[i]-curr.get(k).x)*(xC[i]-curr.get(k).x));
				//System.out.println(cur + " " + max);
				if(4 * r*r - (xC[i]-curr.get(k).x)*(xC[i]-curr.get(k).x) >= 0)
					max = Math.max(cur,  max);
			}
			ans[i] = max;
			curr.add(new Circ(xC[i], max));
			//System.out.println();
		}
		for(int i = 0; i < n; i++)
			System.out.print(ans[i] + " ");
		sc.close();
	}
	static class Circ {
		double x, y;
		public Circ(double a, double b) {
			x=a;
			y=b;
		}
		public boolean isNT(Circ b) {
			double dist = Math.sqrt((x-b.x)*(x-b.x)+(y-b.y)*(y-b.y));
			return dist > 2*r;
		}
	}
}
