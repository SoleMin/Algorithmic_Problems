import java.util.Arrays;
import java.util.Scanner;

public class StagesRocket {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt(), i, s;
		char a[] = in.next().toCharArray(), l;
		in.close();

		Arrays.sort(a);
		l = a[0];
		s = a[0] - 96;
		
		for (i = 1; i < n; i++) {
			if (k > 1 && a[i] - l > 1) {
				l = a[i];
				s += a[i] - 96;
				k--;
			}
		}
		System.out.println(k == 1 ? s : -1);
	}
}
