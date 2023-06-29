import java.util.Scanner;

public class Main {    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int tc = 0; tc < testcase; tc++) {
			int family_number = sc.nextInt();
			int[] street_number = new int[family_number];
			for (int i = 0; i < family_number; i++) {
				street_number[i] = sc.nextInt();
			}
			int min = 99999;
			for (int i = 0; i < family_number; i++) {
				int stand = street_number[i];
				int total_distance = 0;
				for (int j = 0; j < family_number; j++) {
						total_distance += Math.abs(stand - street_number[j]);
				}
					if (min > total_distance)
						min = total_distance;
			}
			System.out.println(min);
		}
	}
}