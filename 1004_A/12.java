import java.util.*;
public class Hotels {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] cities = new int[n];
		int d = input.nextInt();
		for (int i = 0; i<n; i++) {
			cities[i] = input.nextInt();
		}
		int possibilities = 0;
		ArrayList<Integer> newHotels = new ArrayList<Integer>();
		for (int i = 0; i<n; i++) {
			int plusD = cities[i]+d;
			if (newHotels.indexOf(cities[i]+d)==-1 && minDist(plusD,cities)==d) {
				possibilities++;
				newHotels.add(cities[i]+d);
			}
			if (newHotels.indexOf(cities[i]-d)==-1 && minDist(cities[i]-d,cities)==d) {
				possibilities++;
				newHotels.add(cities[i]-d);
			}
		}
		System.out.println(possibilities);
	}
	public static int minDist(int a, int[] arr) {
		int minDist = Integer.MAX_VALUE;
		for (int i=0; i<arr.length; i++) {
			minDist = Math.min(Math.abs(arr[i]-a), minDist);
	}
		return minDist;
	}

}
