import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class TaskA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new TaskA().solve(in, out);
		in.close();
		out.close();
	}
	
	private void solve(Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int answer = 0;
		int counter = k;
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = in.nextInt();
		Arrays.sort(a);
		int[] b = Arrays.copyOf(a, a.length);
		for (int i = 0; i < n; ++i) 
			a[i] = b[n - i - 1];
		for (int i = 0; i < n; ++i) {
			if (counter < m) {
				counter += a[i] - 1;
				++answer;
			} else
				break;
		}
		if (counter < m)
			out.println("-1");
		else
			out.println(answer);
	}

}
