import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(System.in));
		// StringTokenizer t = new StringTokenizer(rd.readLine(), " ");
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		int pl[] = new int[n];
		if (k >= m) {
			System.out.println(0);
			System.exit(0);
		}
		m -= k;
		for (int i = 0; i < n; i++) {
			pl[i] = sc.nextInt() - 1;
		}
		Arrays.sort(pl);
		int out = 0;
		for (int i = n - 1; i >= 0; i--) {
			m -= pl[i];
			out++;
			if (m <= 0)
				break;
		}
		if (m <= 0)
			System.out.println(out);
		else
			System.out.println(-1);
	}

}
