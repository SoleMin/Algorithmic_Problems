import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int r=  Integer.parseInt(line[1]);
		line = in.readLine().split(" ");
		double[] x = new double[n];
		double[] y= new double[n];
		for(int i = 0; i<n; i++) {
			y[i] = r;
			x[i] = Integer.parseInt(line[i]);
		}
		for(int i = 1; i<n; i++) {
			for(int j = 0; j<i; j++) {
				if(Math.abs(x[i]-x[j])>r*2) {
					continue;
				}
				double low = y[j];
				double high = y[j]+(double)r*2.0;
				for(int k = 0; k<85 && low<high; k++) {
					double mid = (low+high)/2.0;
					if(Point2D.distance(x[j], y[j], x[i], mid)<(double)r*2.0) {
						low = mid;
					}
					else {
						high = mid;
					}
				}
				y[i] = Math.max(y[i], low);
			}
		}
		System.out.printf("%.15f",y[0]);
		for(int i = 1; i<n; i++) {
			System.out.printf(" %.15f",y[i]);
		}
		System.out.print("\n");
	}
}