// practice with rainboy
import java.io.*;
import java.util.*;

public class CF256B extends PrintWriter {
	CF256B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF256B o = new CF256B(); o.main(); o.flush();
	}

	long count(int n, int x, int y, int r) {
		long a = 2L * r * r + 2 * r + 1;
		int w;
		if ((w = 1 - (x - r)) > 0)
			a -= (long) w * w;
		if ((w = 1 - (y - r)) > 0)
			a -= (long) w * w;
		if ((w = (x + r) - n) > 0)
			a -= (long) w * w;
		if ((w = (y + r) - n) > 0)
			a -= (long) w * w;
		if ((w = r - 1 - (x - 1) - (y - 1)) > 0)
			a += (long) w * (w + 1) / 2;
		if ((w = r - 1 - (x - 1) - (n - y)) > 0)
			a += (long) w * (w + 1) / 2;
		if ((w = r - 1 - (n - x) - (y - 1)) > 0)
			a += (long) w * (w + 1) / 2;
		if ((w = r - 1 - (n - x) - (n - y)) > 0)
			a += (long) w * (w + 1) / 2;
		return a;
	}
	void main() {
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int c = sc.nextInt();
		int lower = -1, upper = c;
		while (upper - lower > 1) {
			int r = (lower + upper) / 2;
			if (count(n, x, y, r) >= c)
				upper = r;
			else
				lower = r;
		}
		println(upper);
	}
}
