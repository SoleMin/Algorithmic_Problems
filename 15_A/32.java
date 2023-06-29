import java.util.Scanner;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P15A_CottageVillage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int t = scanner.nextInt();
		scanner.nextLine();

		int[] x = new int[n];
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = scanner.nextInt();
			a[i] = scanner.nextInt();
			scanner.nextLine();
		}

		scanner.close();

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (x[i] > x[j]) {
					swap(x, i, j);
					swap(a, i, j);
				}
			}
		}

		int countPositions = 2;

		for (int i = 1; i < n; i++) {
			double left = x[i - 1] + a[i - 1] * 1.0 / 2;
			double right = x[i] - a[i] * 1.0 / 2;
			double length = right - left;

			if (length == (double) t) {
				countPositions++;
			} else if (length > t) {
				countPositions += 2;
			}
		}

		System.out.println(countPositions);
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
