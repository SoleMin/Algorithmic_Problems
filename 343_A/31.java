import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		long a = nextLong();
		long b = nextLong();
		long res = 0;
		while (b > 0) {
			res += a / b;
			long t = a % b;
			a = b;
			b = t;
		}
		out.println(res);
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
		Locale.setDefault(Locale.UK);
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//in = new BufferedReader(new FileReader("a.in"));
			//out = new PrintWriter(new FileWriter("a.out"));

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
