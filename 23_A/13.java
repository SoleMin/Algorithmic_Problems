import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		String s = next();
		for (int len = s.length(); len >= 1; len--) {
			for (int i = 0; i + len <= s.length(); i++)
				for (int j = i + 1; j + len <= s.length(); j++)
					if (s.substring(i, i + len).equals(s.substring(j, j + len))) {
						out.print(len);
						return;
					}
		}
		out.print(0);
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
