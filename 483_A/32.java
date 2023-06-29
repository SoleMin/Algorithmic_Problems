import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	private void run() throws IOException {
		if (new File("input.txt").exists())
			in = new BufferedReader(new FileReader("input.txt"));
		else
			in = new BufferedReader(new InputStreamReader(System.in));
		if (new File("output.txt").exists())
			out = new PrintWriter("output.txt");
		else
			out = new PrintWriter(System.out);

		solve();

		in.close();
		out.close();
	}

	void solve() throws IOException {
		long l = nextLong();
		long r = nextLong();
		l += l % 2;
		if (l + 2 > r)
			out.println("-1");
		else {
			out.println(l + " " + (l + 1) + " " + (l + 2));
		}
	}

	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}

	String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String str = in.readLine();
			if (str == null)
				return true;
			st = new StringTokenizer(str);
		}
		return false;
	}

}
