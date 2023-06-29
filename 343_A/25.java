import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task343A {

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

		private static long r(long a, long b) {
			if (a == 0 || b == 0) {
				return 0;
			}
			if (a > b) {
				return a / b + r(b, a % b);
			}
			return b / a + r(a, b % a);
		}

		public static void main(InputStream is, OutputStream os)
				throws NumberFormatException, IOException {
			PrintWriter pw = new PrintWriter(os);
			Scanner sc = new Scanner(is);

			long a = sc.nextLong();
			long b = sc.nextLong();

			pw.println(r(a, b));

			pw.flush();
			sc.close();
		}
	}

}