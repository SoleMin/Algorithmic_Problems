import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class A {

	final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok = new StringTokenizer("");

	void solve() throws IOException {
		int n = readInt();
		int m = readInt();
		int k = readInt();
		int[] a = readArr(n);
		Arrays.sort(a);
		for(int i = 0; i <= n; i++){
			int curR = k;
			for(int j = n-1; j >= n-i; j--){
				curR += a[j];
			}
			curR -= i;
			if(curR >= m){
				out.println(i);
				return;
			}
		}
		out.println(-1);
	}

	void init() throws FileNotFoundException {
		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
	}

	String readString() throws IOException {
		while (!tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	int readInt() throws IOException {
		return Integer.parseInt(readString());
	}

	long readLong() throws IOException {
		return Long.parseLong(readString());
	}

	double readDouble() throws IOException {
		return Double.parseDouble(readString());
	}

	int[] readArr(int n) throws IOException {
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = readInt();
		}
		return res;
	}

	long[] readArrL(int n) throws IOException {
		long[] res = new long[n];
		for (int i = 0; i < n; i++) {
			res[i] = readLong();
		}
		return res;
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			long t1 = System.currentTimeMillis();
			init();
			solve();
			out.close();
			long t2 = System.currentTimeMillis();
			System.err.println("Time = " + (t2 - t1));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.exit(-1);
		}
	}
}