import java.util.*;

public class Village{
	static class House implements Comparable<House>{
		public double center, length;

		public House(double center, double  length){
			this.center = center;
			this.length = length;
		}
		public double getRight(){
			return center + length/2;
		}
		public double getLeft(){
			return center - length/2;
		}
		public int compareTo(House h){
			return this.center < h.center ? -1 : this.center == h.center ? 0 : 1;
		}

	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] fline = in.nextLine().split("\\s+");
		int N = Integer.parseInt(fline[0]);
		int T = Integer.parseInt(fline[1]);

		House[] houses = new House[N];
		for (int i = 0; i < N; i++){
			String[] house = in.nextLine().split("\\s+");
			houses[i] = new House(Double.parseDouble(house[0]), Double.parseDouble(house[1]));
		}
		Arrays.sort(houses);
		int count = 2;
		for (int i = 0; i < houses.length - 1; i++){
			//how many positions between house i and house i + 1 can we fit in?
			double diff = houses[i+1].getLeft() - houses[i].getRight();
			if (diff < T) continue;
			if (Math.abs(diff - T) < 1E-12) count++;
			else count+=2;
		}
		System.out.println(count);
	}
}
 