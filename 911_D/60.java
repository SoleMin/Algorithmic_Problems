import java.util.*;

public class inversioncounting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] permutation = new int[n];
		for (int i = 0; i < n; i++) {
			permutation[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[][] reverse = new int[m][2];
		for (int i = 0; i < m; i++) {
			reverse[i][0] = sc.nextInt();
			reverse[i][1] = sc.nextInt();
		}
		int counter = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (permutation[i] > permutation[j]) {
					counter++;
				}
			}
		}
		boolean bayus = true;
		if (counter % 2 == 1) {
			bayus = false;
		}
		for (int i = 0; i < m; i++) {
			int bobib = reverse[i][1] - reverse[i][0] + 1;
			int bafry = nChoose2(bobib);
			if (bafry%2 == 1) {
				bayus = !bayus;
			}
			if (bayus) {
				System.out.println("even");
			}
			else {
				System.out.println("odd");
			}
		}

	}
	private static int nChoose2 (int n) {
		return (n * (n-1)) / 2;
	}

}
