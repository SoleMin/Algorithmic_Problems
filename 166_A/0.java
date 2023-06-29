import java.util.Arrays;
import java.util.Scanner;

public class RankList {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt(), i, a[] = new int[n], c = 0;
		for (i = 0; i < n; i++)
			a[i] = in.nextInt() * 50 - in.nextInt();

		in.close();
		Arrays.sort(a);
		for (i = 0; i < n; i++)
			if (a[i] == a[n - k])
				c++;
		System.out.println(c);
	}
}
