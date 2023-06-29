import java.io.*;
import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class Main implements Runnable {
	
	void randomShuffle(int[] arr) {
		Random rnd = new Random();
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = rnd.nextInt(i + 1);
			int temp = arr[pos];
			arr[pos] = arr[i];
			arr[i] = temp;
		}
	}
	
	void solve() throws Exception {
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] ac = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ac[i] = sc.nextInt();
		}
		randomShuffle(ac);
		Arrays.sort(ac);
		int diff = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != ac[i]) {
				diff++;
			}
		}
		if (diff <= 2) {
			out.println("YES");
		} else {
			out.println("NO");
		}
	}
	
	BufferedReader in;
	PrintWriter out;
	FastScanner sc;
	
	static Throwable uncaught;
	
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			sc = new FastScanner(in);
			solve();
		} catch (Throwable t) {
			Main.uncaught = t;
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) throws Throwable {
		Thread t = new Thread(null, new Main(), "", 128 * 1024 * 1024);
		t.start();
		t.join();
		if (uncaught != null) {
			throw uncaught;
		}
	}

}

class FastScanner {
	
	BufferedReader reader;
	StringTokenizer strTok;
	
	public FastScanner(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String nextToken() throws IOException {
		while (strTok == null || !strTok.hasMoreTokens()) {
			strTok = new StringTokenizer(reader.readLine());
		}
		return strTok.nextToken();
	}
	
	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
}