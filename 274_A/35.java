import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static Random rnd;

	void solve() throws IOException {
		int n = nextInt();
		long k = nextLong();

		if (k == 1) {
			out.println(n);
		} else {

			TreeMap<Long, ArrayList<Integer>> numbers = new TreeMap<Long, ArrayList<Integer>>();

			for (int i = 0; i < n; i++) {
				long m = nextLong();
				int howMuch = 0;

				while (m % k == 0) {
					m /= k;
					++howMuch;
				}

				if (!numbers.containsKey(m)) {
					numbers.put(m, new ArrayList<Integer>());
				}

				numbers.get(m).add(howMuch);
			}

			int res = 0;

			for (ArrayList<Integer> oneGroup : numbers.values()) {
				res += parseOneGroup(oneGroup);
			}

			out.println(res);
		}
	}

	private int parseOneGroup(ArrayList<Integer> oneGroup) {
		Collections.sort(oneGroup);

		int res = 0, prevValue = Integer.MIN_VALUE;

		for (int i = 0; i < oneGroup.size(); i++) {
			int curValue = oneGroup.get(i);

			if (prevValue + 1 != curValue) {
				++res;
				prevValue = curValue;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null)
				return null;

			st = new StringTokenizer(line);
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
}