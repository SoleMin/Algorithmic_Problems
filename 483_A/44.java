import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long l = in.nextLong();
		long r = in.nextLong();
		long a = 0;
		long b = 0;
		long c = 0;
		if (r - l < 2)
			System.out.println(-1);
		else if (r - l < 3 && l % 2 == 1)
			System.out.println(-1);
		else {
			if (l % 2 == 0) {
				a = l;
				b = l + 1;
				c = l + 2;
			} else {
				if (l == 1) {
					a = 2;
					b = 3;
					c = 4;
				} else {
					a = l + 1;
					b = l + 2;
					c = l + 3;
				}
			}
			System.out.println(a + " " + b + " " + c);
		}
		
	}
}
