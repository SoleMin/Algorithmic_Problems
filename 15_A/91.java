import java.util.*;

public class Village {
	
	private class House implements Comparable<House> {
		Double Coordinate;
		Double Sidelength;

		private House(double coordinate, double sidelength) {
			Coordinate = coordinate;
			Sidelength = sidelength;
		}

		public int compareTo(House o) {
			return Coordinate.compareTo(o.Coordinate);
		}
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		in.next();
		double requireside = in.nextDouble();
		ArrayList<House> coordinate = new ArrayList<House>();
		while (in.hasNext()) {
			double coo = in.nextDouble();
			double side = in.nextDouble();
			coordinate.add(new House(coo, side));
		}
		Collections.sort(coordinate);
		ArrayList<Double> edges = new ArrayList<Double>();
		int count = 2;
		for (int i = 0; i < coordinate.size(); i++) {
			edges.add(coordinate.get(i).Coordinate
					- (double) coordinate.get(i).Sidelength / (double) 2);
			edges.add(coordinate.get(i).Coordinate
					+ (double) coordinate.get(i).Sidelength / (double) 2);
		}
		ArrayList<Double> difference = new ArrayList<Double>();
		for (int i = 1; i < edges.size() - 1; i++) {
			difference.add(Math.abs(edges.get(i) - edges.get(i + 1)));
		}
		for (int i = 0; i < difference.size(); i += 2) {
			if (difference.get(i) == requireside)
				count++;
			else if (difference.get(i) > requireside)
				count += 2;
		}
		System.out.println(count);
	}

	public static void main(String args[]) {
		Village v = new Village();
		v.solve();
	}
}
