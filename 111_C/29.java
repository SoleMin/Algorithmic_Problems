// practice with rainboy
import java.io.*;
import java.util.*;

public class CF111C extends PrintWriter {
	CF111C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF111C o = new CF111C(); o.main(); o.flush();
	}

	int encode(int[] aa, int m) {
		int a = 0;
		for (int j = 0; j < m; j++)
			a = a * 3 + aa[j];
		return a;
	}
	void decode(int[] aa, int m, int a, int base) {
		for (int j = m - 1; j >= 0; j--) {
			aa[j] = a % base;
			a /= base;
		}
	}
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n < m) {
			int tmp = n; n = m; m = tmp;
		}
		int p = 1;
		for (int j = 0; j < m; j++)
			p *= 3;
		int[] dp = new int[p];
		int[] dq = new int[p];
		int[] aa = new int[m];
		int[] bb = new int[m];
		for (int j = 0; j < m; j++)
			aa[j] = 1;
		Arrays.fill(dp, -1);
		dp[encode(aa, m)] = 0;
		while (n-- > 0) {
			Arrays.fill(dq, -1);
			for (int a = 0; a < p; a++) {
				if (dp[a] < 0)
					continue;
				decode(aa, m, a, 3);
				for (int b = 0; b < 1 << m; b++) {
					decode(bb, m, b, 2);
					boolean bad = false;
					for (int j = 0; j < m; j++)
						if (aa[j] == 0 && bb[j] == 0) {
							bad = true;
							break;
						}
					if (bad)
						continue;
					int cnt = 0;
					for (int j = 0; j < m; j++)
						if (bb[j] == 1) {
							bb[j] = 2;
							cnt++;
						}
					for (int j = 0; j < m; j++)
						if (bb[j] == 0 && (aa[j] == 2 || j > 0 && bb[j - 1] == 2 || j + 1 < m && bb[j + 1] == 2))
							bb[j] = 1;
					int a_ = encode(bb, m);
					dq[a_] = Math.max(dq[a_], dp[a] + m - cnt);
				}
			}
			int[] tmp = dp; dp = dq; dq = tmp;
		}
		int ans = 0;
		for (int a = 0; a < p; a++) {
			if (dp[a] <= ans)
				continue;
			decode(aa, m, a, 3);
			boolean bad = false;
			for (int j = 0; j < m; j++)
				if (aa[j] == 0) {
					bad = true;
					break;
				}
			if (!bad)
				ans = dp[a];
		}
		println(ans);
	}
}
