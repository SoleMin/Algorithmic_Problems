import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		(new Main()).solve();
	}

	public void Main() {
	}

	void solve() throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// Scanner in = new Scanner(System.in);
		MyReader in = new MyReader();
		PrintWriter out = new PrintWriter(System.out);
		// Scanner in = new Scanner(new FileReader("input.txt"));
		// PrintWriter out = new PrintWriter("output.txt");

		int n = in.nextInt();
		out.print("0 0 ");
		out.print(n);

		out.close();
	}

};

class MyReader {
	private BufferedReader in;
	String[] parsed;
	int index = 0;

	public MyReader() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public int nextInt() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Integer.parseInt(parsed[index++]);
	}

	public long nextLong() throws NumberFormatException, IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return Long.parseLong(parsed[index++]);
	}

	public String nextString() throws IOException {
		if (parsed == null || parsed.length == index) {
			read();
		}
		return parsed[index++];
	}

	private void read() throws IOException {
		parsed = in.readLine().split(" ");
		index = 0;
	}

	public String readLine() throws IOException {
		return in.readLine();
	}
};