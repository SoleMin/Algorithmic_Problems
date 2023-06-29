import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		int n = nextInt();
		int k = nextInt();
		boolean[] p = new boolean[n + 1];
		Arrays.fill(p, true);
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++)
			if (p[i]) {
				primes.add(i);
				for (int j = i + i; j <= n; j += i)
					p[j] = false;
			}
		boolean[] ok = new boolean[n + 1];
		for (int i = 0; i < primes.size() - 1; i++) {
			int x = primes.get(i);
			int y = primes.get(i + 1);
			if (x + y + 1 <= n)
				ok[x + y + 1] = true;
		}
		for (int i = 2; i <= n; i++)
			if (p[i] && ok[i]) {
				--k;				
			}		
		out.println(k <= 0 ? "YES" : "NO");
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
