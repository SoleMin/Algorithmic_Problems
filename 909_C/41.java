import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
	static long MOD = 1_000_000_007;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		boolean[] isFor = new boolean[n];
		for (int a = 0; a < n; a++) {
			isFor[a] = input.next().charAt(0) == 'f';
		}
		long[][] array = new long[n + 1][n + 1];
		array[0][0] = 1;
		boolean isPreviousFor = false;
		for (int idx = 0; idx < n; idx++) {
			long heightCache = 0;
			for (int height = n-1; height >= 0; height--) {
				if (isPreviousFor) {
					array[idx + 1][height + 1] += array[idx][height];
					array[idx + 1][height + 1] %= MOD;
				} else {
					heightCache += array[idx][height];
					heightCache %= MOD;
					array[idx + 1][height] += heightCache;
					array[idx + 1][height] %= MOD;
				}
			}
			isPreviousFor = isFor[idx];
		}
//		System.out.println(Arrays.deepToString(array));
		long sum = 0;
		for (int height = 0; height <= n; height++) {
			sum += array[n][height];
		}
		System.out.println(sum % MOD);
	}
}
