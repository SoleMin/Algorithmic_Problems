import java.util.Scanner;

public class Prob235A {
	public static void main(String[] Args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		if (x < 3) {
			if (x == 1)
				System.out.println(1);
			else
				System.out.println(2);
		} else {
			long answer = x;
			if (x % 2 == 1) {
				answer *= x - 1;
				answer *= x - 2;
			} else if (x % 3 != 0) {
				answer *= x - 1;
				answer *= x - 3;
			} else {
				answer = x - 1;
				answer *= x - 2;
				answer *= x - 3;
			}
			System.out.println(answer);
		}
	}
}
