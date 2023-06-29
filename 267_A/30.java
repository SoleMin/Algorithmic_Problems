import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task267A {

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

			int n = sc.nextInt();

			while (n-- > 0) {
				int ai = sc.nextInt();
				int bi = sc.nextInt();
				int retVal = 0;

				while (ai > 0 && bi > 0) {
					if (ai > bi) {
						retVal += ai / bi;
						ai = ai % bi;
					} else {
						retVal += bi / ai;
						bi = bi % ai;
					}
				}
				pw.println(retVal);
			}

			pw.flush();
			sc.close();
		}
	}

}