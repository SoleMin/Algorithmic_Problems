import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class a {
	
	boolean[] isp;
	ArrayList<Integer> primes;

	private void solve() throws Exception {
		int n = nextInt();
		int k = nextInt();
		int cnt = 0;
		primes = new ArrayList<Integer>();
		isp = new boolean[n + 1];
		Arrays.fill(isp, true);
		for (int i = 2; i <= n; ++i) {
			for (int j = 2; j * j <= i; ++j)
				if (i % j == 0)
					isp[i] = false;
			if (isp[i])
				primes.add(i);
		}
		for (int i = 2; i <= n; ++i)
			if (isp[i]) {
				boolean can = false;
				for (int j = 0; j < primes.size() - 1; ++j) {
					int sum = primes.get(j) + primes.get(j + 1) + 1;
					if (i == sum)
						can = true;
				}
				if (can)
					++cnt;
			}
		if (cnt >= k)
			out.print("YES");
		else
			out.print("NO");
	}

	public void run() {
		try {
			solve();
		} catch (Exception e) {
			NOO(e);
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	BufferedReader in;
	StringTokenizer St;

	void NOO(Exception e) {
		e.printStackTrace();
		System.exit(1);
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	String nextToken() {
		while (!St.hasMoreTokens()) {
			try {
				String line = in.readLine();
				St = new StringTokenizer(line);
			} catch (Exception e) {
				NOO(e);
			}
		}
		return St.nextToken();
	}

	private a(String name) {
		try {
			in = new BufferedReader(new FileReader(name + ".in"));
			St = new StringTokenizer("");
			out = new PrintWriter(new FileWriter(name + ".out"));
		} catch (Exception e) {
			NOO(e);
		}
	}

	private a() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			St = new StringTokenizer("");
			out = new PrintWriter(System.out);
		} catch (Exception e) {
			NOO(e);
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		new a().run();
	}

}
