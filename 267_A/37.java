
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n-- > 0) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = 0;
			while (a != 0 && b != 0) {
				if (a > b) {
					int t = a / b;
					k += t;
					a = a - b * t;
				} else {
					int t = b / a;
					k += t;
					b = b - a * t;
				}
			}
			System.out.println(k);
		}

	}

}
