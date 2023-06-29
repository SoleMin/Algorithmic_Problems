import java.util.Scanner;

public class TaskD {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		int m = s.nextInt();

		int inv = 0;
		// count inversions
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					inv++;
				}
			}
		}

		boolean odd = (inv % 2 == 1);

		for (int i = 0; i < m; i++) {
			int l = s.nextInt();
			int r = s.nextInt() + 1; // r excluding, l including
			int num = (r - l)*(r - l - 1)/2;
			if (num % 2 == 1) {
				odd = !odd;
			}
			System.out.println((odd) ? "odd" : "even");
		}
	}

}
