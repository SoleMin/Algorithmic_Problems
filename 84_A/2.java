import java.util.*;
import java.io.*;

public class Soldiers {
	public static void main(String[] args) throws IOException {
		new Soldiers().run();
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);

		int n = nextInt();
		pw.println(3 * (n / 2));

		pw.close();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter pw;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
