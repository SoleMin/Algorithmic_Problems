import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		long n = Long.parseLong(in[0]), s = Long.parseLong(in[1]);
		Solver solver = new Solver(n, s);
		System.out.println(solver.solve());

	}

}

class Solver {

	private long n, s;

	Solver(long n, long s) {
		this.n = n;
		this.s = s;
	}

	public long solve() {
		long low = 1, high = n;
		for (int i = 0; i < 72; ++i) {
			long x = low + (high - low) / 2;
			if (check(x))
				high = x - 1;
			else
				low = x + 1;
		}
		return n - high;
	}

	private boolean check(long x) {

		long tmp = x;
		int sum = 0;
		while (tmp > 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		return x - sum >= s;
	}
}
