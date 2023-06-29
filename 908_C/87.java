import java.io.*;
import java.util.*;
	
public class Codeforces908C {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] x = new int[n];
		st = new StringTokenizer(f.readLine());
		for(int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		double[] y = new double[n];
		y[0] = r;
		double hypSq = 4*r*r;
		for(int i = 1; i < n; i++) {
			boolean hit = false;
			double maxY = 0;
			for(int j = 0; j < i; j++) {
				int dx = Math.abs(x[i] - x[j]);
				if(dx == 2*r) {
					if(y[j] > maxY) {
						maxY = y[j];
						hit = true;
					}
				} else if(dx < 2*r) {
					double newY = y[j] + Math.sqrt(hypSq - dx*dx);
					if(newY > maxY) {
						maxY = newY;
						hit = true;
					}
				}
			}
			if(!hit) {
				y[i] = r;
			} else {
				y[i] = maxY;
			}
		}
		StringBuffer s = new StringBuffer("");
		for(int i = 0; i < n; i++) {
			s.append(y[i] + " ");
		}
		System.out.println(s.toString().trim());
	}
}
