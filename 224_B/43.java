import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class B {
	static Vector<Integer> primes;

	public static void main(String[] args) throws IOException {
		InputReader myScanner = new InputReader();
		int n = myScanner.nextInt(), k = myScanner.nextInt();
		myScanner.hasNext();
		int all[] = new int[n];
		boolean numbers[] = new boolean[100100];
		int diff[] = new int[n];
		all[0] = myScanner.nextInt();
		diff[0] = 1;
		numbers[all[0]] = true;
		int r = -1;
		if (k == 1)
			r = 1;
		for (int i = 1; i < all.length; i++) {
			all[i] = myScanner.nextInt();
			diff[i] = diff[i - 1];
			if (!numbers[all[i]]) {
				if (r == -1 && diff[i] + 1 == k)
					r = i + 1;
				numbers[all[i]] = true;
				diff[i]++;
			}
		}
		if (r == -1)
			System.out.println(-1 + " " + -1);
		else {
			numbers = new boolean[100010];
			int l = 0, cnt = 1;
			numbers[all[r - 1]] = true;
			if (k == 1)
				System.out.println(1 + " " + 1);
			else {
				for (int i = r - 2; i >= 0; i--) {
					if (!numbers[all[i]]) {
						numbers[all[i]] = true;
						cnt++;
					}
					if (cnt == k) {
						l = i + 1;
						break;
					}
				}

				System.out.println(l + " " + r);
			}
		}
	}

	static class InputReader {
		BufferedReader buff;
		StringTokenizer tok;
		String cur;

		public InputReader() throws IOException {
			buff = new BufferedReader(new InputStreamReader(System.in));
			tok = new StringTokenizer(cur = buff.readLine());
		}

		public boolean hasNext() throws IOException {
			if (!tok.hasMoreElements()) {
				cur = buff.readLine();
				if (cur == null)
					return false;
				tok = new StringTokenizer(cur);
			}
			return true;
		}

		public String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(cur = buff.readLine());

			return tok.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(cur = buff.readLine());

			return Long.parseLong(next());
		}
	}

}
