
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 */
public class Main911D {
	public static void main(String[] args) {
		run(System.in, System.out);
	}

	public static void run(InputStream in, PrintStream out) {

		try (Scanner sc = new Scanner(in)) {
			int n = sc.nextInt();
			int[] t = new int[n];
			int inv = 0;
			for (int i = 0; i < n; i++) {
				t[i] = sc.nextInt();
				for (int j = 0; j < i; j++) {
					if (t[j] > t[i]) inv++;
				}
			}

			inv = inv % 2;
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int s = b - a + 1;
				inv = (inv + s * (s - 1) / 2) % 2;
				out.println(inv == 0 ? "even" : "odd");

			}

		}
	}

}