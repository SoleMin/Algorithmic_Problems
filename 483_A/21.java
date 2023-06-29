
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong(), r = sc.nextLong();
		if (l % 2 == 0 && r - l >= 2) {
			System.out.println(l + " " + (l + 1) + " " + (l + 2));
		} else if (l % 2 == 1 && r - l >= 3) {
			System.out.println(l + 1 + " " + (l + 2) + " " + (l + 3));
		} else {
			System.out.println(-1);
		}
	}
}
