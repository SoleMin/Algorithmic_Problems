

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class A {
	
	private void processInput() throws IOException {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long res = go(n);

		System.out.printf(Locale.ENGLISH, "%d\n", res);			

	

		
		in.close();
	}

	private long go(long n) {
		
		long res = 3*n / 2;
		

		return res;
	}
	
	public static void main(String[] args) throws Exception {
		A a = new A();
		a.processInput();
	}
}
