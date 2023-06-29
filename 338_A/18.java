// practice with rainboy
import java.io.*;
import java.util.*;

public class CF338A extends PrintWriter {
	CF338A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF338A o = new CF338A(); o.main(); o.flush();
	}

	static final int MD = 1000000009;
	long power(int a, int k) {
		if (k == 0)
			return 1;
		long p = power(a, k / 2);
		p = p * p % MD;
		if (k % 2 == 1)
			p = p * a % MD;
		return p;
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int z = n - m;
		if (z >= (n + k - 1) / k) {
			println(m);
			return;
		}
		int d = (n - z * k) / k;
		println(((power(2, d + 1) - 2 + MD) * k + m - d * k) % MD);
	}
}
