import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
		long C = sc.nextLong();

		int lo = 0, hi = (int) (1e6);
		int answer = -1;
		while (lo <= hi) {
			int L = lo + (hi - lo) / 2;
			long area = 0;
			for (int steps = 0; steps <= L; ++steps) { // L + 1 steps to right
				if (y + steps > N)
					break;
				long up = Math.min(x, 1 + L - steps), down = Math.min(N - x, L - steps);
				area += up + down;
			}

			for (int steps = 1; steps <= L; ++steps) { // L steps to left
				if (y - steps < 1)
					break;
				long up = Math.min(x, 1 + L - steps), down = Math.min(N - x, L - steps);
				area += up + down;
			}
			if (area >= C) {
				answer = L;
				hi = L - 1;
			} else
				lo = L + 1;
		}
		out.println(answer);

		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

	}
}