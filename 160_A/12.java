import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SolA {

	static Scanner in;
	static PrintWriter out;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

		new SolA().run();

		in.close();
		out.close();

	}

	private void run() {
		int n = in.nextInt();
		int[] a = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			sum+=a[i];
		}
		Arrays.sort(a);
		int cs = 0;
		int kol = 0;
		for(int i = n - 1; i>=0; i--) {
			cs+=a[i];
			kol++;
			if (cs > sum - cs) {
				break;
			}
		}
		out.print(kol);
	}

}
