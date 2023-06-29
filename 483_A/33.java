import java.io.*;
import java.util.*;

public class practice {
	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(new File("practice.in"));
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		long n = Long.parseLong(str.substring(0, str.indexOf(" ")));
		long m = Long.parseLong(str.substring(str.indexOf(" ") + 1));
		if(m - n < 2) {
			System.out.println("-1");
		} else {
			if(m - n == 2 && m % 2 == 1) {
				System.out.println("-1");
			} else {
				System.out.println((n + n % 2) + " " + (n + 1 + n % 2) + " " + (n + 2 + n % 2));
			}
		}
	}
}