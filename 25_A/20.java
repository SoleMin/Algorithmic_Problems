import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		int n = nextInt();
		int even = 0, odd = 0, atEven = -1, atOdd = -1;
		for (int i = 0; i < n; i++) {
			if (nextInt() % 2 == 0) {
				atEven = i;
				++even;
			}
			else {
				atOdd = i;
				++odd;
			}
		}
		if (odd == 1)
			out.print(atOdd + 1);
		else
			out.print(atEven + 1);
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
