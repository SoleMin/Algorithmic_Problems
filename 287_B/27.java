import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class palin {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(System.out);
		Scanner scan = new Scanner(System.in);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		long n = in.nextLong() - 1;
		long k = in.nextLong() - 1;
		if (n == 0) {
			out.print("0");
		} else {
			if (k >= n) {
				out.print("1");
			} else {
				if (k * (k + 1) / 2 < n) {
					out.print("-1");
				} else {
					long t = binsearch(n, k, 1, k);
					long ans = k - t + 1;
					if (k * (k + 1) / 2 - t * (t - 1) / 2 != n)
						ans++;
					System.out.println(ans);
				}
			}
		}
	}

	public static long binsearch(long n, long k, long from, long to) {
		if (from == to) {
			return from;
		}
		long mid = (from + to) / 2;
		if ((k * (k + 1)) / 2 - (mid * (mid - 1)) / 2 > n)
			return binsearch(n, k, mid + 1, to);
		else

			return binsearch(n, k, from, mid);
	}
}

class InputReader {
	BufferedReader br;
	StringTokenizer st;

	public InputReader(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
		st = null;
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}
}