import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task235A {

	public static void main(String... args) throws NumberFormatException,
			IOException {
		Solution.main(System.in, System.out);
	}

	static class Scanner {

		private final BufferedReader br;
		private String[] cache;
		private int cacheIndex;

		Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			cache = new String[0];
			cacheIndex = 0;
		}

		int nextInt() throws IOException {
			if (cacheIndex >= cache.length) {
				cache = br.readLine().split(" ");
				cacheIndex = 0;
			}
			return Integer.parseInt(cache[cacheIndex++]);
		}

		long nextLong() throws IOException {
			if (cacheIndex >= cache.length) {
				cache = br.readLine().split(" ");
				cacheIndex = 0;
			}
			return Long.parseLong(cache[cacheIndex++]);
		}

		String next() throws IOException {
			if (cacheIndex >= cache.length) {
				cache = br.readLine().split(" ");
				cacheIndex = 0;
			}
			return cache[cacheIndex++];
		}

		void close() throws IOException {
			br.close();
		}

	}

	static class Solution {

		public static void main(InputStream is, OutputStream os)
				throws NumberFormatException, IOException {
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);

			long n = sc.nextInt();

			if (n < 3) {
				pw.println(n);
			} else {
				if (n % 2 != 0) {
					pw.println(n * (n - 1) * (n - 2));
				} else {
					if (n % 3 != 0) {
						pw.println(n * (n - 1) * (n - 3));
					} else {
						long cand1 = n * (n - 1) * (n - 2) / 2;
						long cand2 = (n - 1) * (n - 2) * (n - 3);
						pw.println(Math.max(cand1, cand2));
					}
				}
			}

			pw.flush();
			sc.close();
		}
	}

}