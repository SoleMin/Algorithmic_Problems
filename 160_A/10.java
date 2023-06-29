import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @listen
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		int n = in.nextInt();
		int [] input = new int[n];
		int total = 0;
		for (int i = 0; i < n; ++i){
			input[i] = in.nextInt();
			total +=input[i];
		}
		Arrays.sort(input);
		int res = 0;
		int now = 0;
		for (int i = n - 1; i >= 0; --i){
			now += input[i];
			int left = total - now;
			++res;
			if (now > left){
				break;
			}
		}
		out.println(res);
		return;
	}
}

