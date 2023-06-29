import java.io.*;
import java.util.*;

public class pr169D implements Runnable {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer str;

	public void solve() throws IOException {
		long l = nextLong();
		long r = nextLong();
		long x = l ^ r;
		long i = 1;
		while (x >= i)
			i *= 2;
		out.println(x > i ? x : i - 1);
	}

	public String nextToken() throws IOException {
		while (str == null || !str.hasMoreTokens()) {
			str = new StringTokenizer(in.readLine());
		}
		return str.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			in.close();
			out.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new Thread(new pr169D()).start();
	}
}
