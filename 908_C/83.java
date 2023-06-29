import java.util.*;
import java.io.*;

public class NewYearsCurling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		ArrayList<Integer> centers = new ArrayList<Integer>();
		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			centers.add(Integer.parseInt(st.nextToken()));
		}
		sc.close();
		ArrayList<Point> finalpoints = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			double maxy = r;
			for (int j = 0; j < finalpoints.size(); j++) {
				if (finalpoints.get(j).x - centers.get(i) > 2 * r || centers.get(i) - finalpoints.get(j).x > 2 * r)
					continue;
				double dist = Math.sqrt(
						4 * r * r - (finalpoints.get(j).x - centers.get(i)) * (finalpoints.get(j).x - centers.get(i)))
						+ finalpoints.get(j).y;
				if(dist > maxy)
					maxy = dist;
			}
			
			pw.print(maxy + " ");
			finalpoints.add(new Point(centers.get(i), maxy));
		}
		
		pw.close();
	}

	public static class Point {
		double x;
		double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}
