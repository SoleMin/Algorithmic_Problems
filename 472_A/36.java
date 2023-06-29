import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TA {

	public void solve(long n) {
		long a = 0, b = 0;
		if (n % 2 == 0) {
			if (n % 4 == 0) {
				a = n / 2;
				b = n/ 2;
			} else {
				a = n / 2 - 1;
				b = n / 2 + 1;
			}
		} else {
			a = 4;
			b = n - a;
			while (b > 0 && (b % 3 != 0)) {
				a += 2;
				b = n - a;
			}
			
		}
		System.out.println(a + " " + b);
	}
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		
		new TA().solve(in.nextLong());
	}
	static class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
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

	}

}
