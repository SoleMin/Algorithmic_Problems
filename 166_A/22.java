import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] argv) {
		new Main().run();
	}

	void run() {

		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
			solve();
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	Scanner in;

	class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}

	int[] readArr(int size) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = in.nextInt();
		}
		return a;
	}

	void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		Pair[] a = new Pair[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Pair(in.nextInt(), in.nextInt());
		}
		Arrays.sort(a, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				if (p2.x != p1.x) {
					return p2.x - p1.x;
				}
				return p1.y - p2.y;
			}
		});
		int cnt = 1;
		int ans = 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			if (!(a[i].x == a[i - 1].x && a[i].y == a[i - 1].y)) {
				cnt++;
			}
			res[i] = cnt;
			//out.println(a[i] + " * " + cnt);
		}
		int el = res[k - 1];
		for (int i = 0; i < n; i++) {
			if (res[i] == el) {
				ans++;
			}
		}
		out.println(ans);

	}
}