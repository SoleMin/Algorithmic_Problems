import java.util.*;

public class Task25a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = 0, a2 = 0;
		int n1 = 0, n2 = 0;
		for (int i = 1; i <= n; i++) {
			int c = sc.nextInt();
			if (c % 2 == 1) {
				a1 = i;
				n1++;
			} else {
				a2 = i;
				n2++;
			}
		}
		if (n1 == 1) {
			System.out.println(a1);
		} else {
			System.out.println(a2);
		}
	}

}
