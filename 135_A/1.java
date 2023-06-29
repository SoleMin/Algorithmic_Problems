import java.util.Arrays;
import java.util.Scanner;

public class A135 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt(), a[] = new int[n], max = 0, imax = 0;

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (a[i] > max) {
				max = a[i];
				imax = i;
			}
		}

		if (a[imax] == 1)
			a[imax] = 2;
		else
			a[imax] = 1;

		Arrays.sort(a);

		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");

	}
}