import java.util.*;

public class Beta15PA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beta15PA temp = new Beta15PA();
		temp.solve();
	}
	
	public void solve() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), t = scan.nextInt();
		House[]	houses = new House[n];
		for(int i=0; i<n; i++) {
			houses[i] = new House(scan.nextInt(), scan.nextInt());
		}
		Arrays.sort(houses);
		int res = 2;
		for(int i=0; i<n-1; i++) {
			double cnt = houses[i+1].coordinate - houses[i].coordinate;
			cnt -= 1.0*(houses[i+1].side+houses[i].side)/2;
			if(cnt>t) res += 2;
			else if(Math.abs(cnt-t)<1e-7) res += 1;
		}
		System.out.println(res);
	}
	
	public class House implements Comparable<House> {
		public int coordinate, side;

		public House(int coordinate, int side) {
			this.coordinate = coordinate;
			this.side = side;
		}

		@Override
		public int compareTo(House arg0) {
			// TODO Auto-generated method stub
			return this.coordinate - arg0.coordinate;
		}
		
	}

}
