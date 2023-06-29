import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Round313A {
	private static final int LOCAL_ENV = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			if (LOCAL_ENV == 1) {
				in = new Scanner(new File("input.txt"));
			}
		} catch (FileNotFoundException e) {
			in = new Scanner(System.in);
		}

		long n = in.nextLong();

		if (n >= -9) {
			System.out.println(n);
		} else {
			long absN = Math.abs(n);
			long m1 = -(absN / 10);
			long last = absN % 10;
			long m2 = -((absN / 100) * 10 + last);
			System.out.println(Math.max(m1, m2));
		}
	}
}
