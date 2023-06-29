import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class flags1225 implements Runnable {
	static int n, k, a, b[], loy[];
	static boolean decision[];
	static double ans, max;

	static void check(int i) {
		if (i == n) {
			checkAgain();
			return;
		}
		decision[i] = true;
		check(i + 1);
		if (loy[i] < 100) {
			decision[i] = false;
			check(i + 1);
		}
	}

	static void checkAgain() {
		double prob = 1;
		int enemyEnergy = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (decision[i]) {
				count++;
				prob *= loy[i];
			} else {
				prob = prob * (100 - loy[i]);
				enemyEnergy += b[i];
			}
		}
		double killProb = (double) (a) / (a + enemyEnergy);
		if (count > n / 2) {
			ans += prob;
			return;
		}
		prob *= killProb;
		ans += prob;
	}

	static void rec(int sum, int i) {
		if (i == n || sum == 0) {
			ans = 0;
			check(0);
			max = max(ans, max);
			return;
		}
		for (int j = 0; j <= sum; j = j + 10) {
			if (loy[i] + j > 100)
				continue;
			loy[i] += j;
			rec(sum - j, i + 1);
			loy[i] -= j;
		}
	}

	public void run() {
		n = nextInt();
		k = nextInt() * 10;
		a = nextInt();
		max = 0;
		b = new int[n];
		loy = new int[n];
		decision = new boolean[n];
		for (int i = 0; i < n; i++) {
			b[i] = nextInt();
			loy[i] = nextInt();
		}
		// System.out.println(Arrays.toString(loy));
		rec(k, 0);
		long pow = (long) pow(100, n);
		out.print((double) max / pow);

		// --------------------------------------------------------------------------------------------
		out.close();
		System.exit(0);
	}

	private static boolean fileIOMode = false;
	private static String problemName = "harmful";
	private static BufferedReader in;
	private static PrintWriter out;
	private static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.ENGLISH);
		if (fileIOMode) {
			in = new BufferedReader(new FileReader(problemName + ".in"));
			out = new PrintWriter(problemName + ".out");
		} else {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
		}
		tokenizer = new StringTokenizer("");

		new Thread(new flags1225()).start();
	}

	private static String nextLine() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private static String nextToken() {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(nextLine());
		}
		return tokenizer.nextToken();
	}

	private static double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	private static int nextInt() {
		return Integer.parseInt(nextToken());
	}
}