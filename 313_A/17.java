import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CFA {

	private void work() throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int a = n;
			int b = n / 10;
			int c;
			if (n < 0) {
				n = -n;
				c = -((n / 100) * 10 + n % 10);
			} else {
				c = (n / 100) * 10 + n % 10;
			}
			System.out.println(Math.max(a, Math.max(b, c)));
		}
		System.out.close();
	}

	private int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		new CFA().work();
	}

}
