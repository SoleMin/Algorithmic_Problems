import java.util.Scanner;


public class A {

	static Scanner scanner = new Scanner(System.in);
	static int s;

	public static void main(String[] args) {
		s = scanner.nextInt();
		if (s >= 0) {
			System.out.println(s);
		}
		else {
			if (s >= -10) {
				System.out.println(0);
			}
			else {
				int ss = -s;
				int a, b;
				a = ss % 10;
				b = (ss % 100) / 10;
				if (a > b) {
					ss = ss / 10;
				}
				else {
					ss = (ss / 100) * 10 + a;
				}
				if (ss == 0) {
					System.out.println(0);
				}
				else {
					System.out.println("-" + ss);
				}
			}
		}
	}

}
