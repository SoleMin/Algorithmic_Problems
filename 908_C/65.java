import java.util.*;
import java.io.*;

public class test {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(s.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(s.nextLine());
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<State> list = new ArrayList<State>();
		for (int i = 0; i < n; i++) {
			double currY = r;
			for (int j = 0; j < list.size(); j++) {
				double xDiff = Math.abs(list.get(j).getX() - array[i]);
				if (xDiff <= 2 * r) {
					if (currY < list.get(j).getY() + Math.sqrt(4 * r * r - xDiff * xDiff)) {
						currY = list.get(j).getY() + Math.sqrt(4 * r * r - xDiff * xDiff);
					}
				}
			}
			list.add(new State(array[i], currY));
			System.out.print(currY + " ");
		}
		s.close();
	}

	static class State {
		double x;
		double y;

		public State(double a, double b) {
			x = a;
			y = b;
		}

		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}
	}
}
