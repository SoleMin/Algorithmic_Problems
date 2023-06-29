// practice with rainboy
import java.io.*;
import java.util.*;

public class CF1238E extends PrintWriter {
	CF1238E() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1238E o = new CF1238E(); o.main(); o.flush();
	}

	static final int INF = 0x3f3f3f3f;
	void main() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		byte[] cc = sc.next().getBytes();
		int[] kk = new int[1 << m];
		for (int i = 1; i < n; i++) {
			int a = cc[i - 1] - 'a';
			int b = cc[i] - 'a';
			kk[1 << a | 1 << b]++;
		}
		for (int h = 0; h < m; h++)
			for (int b = 0; b < 1 << m; b++)
				if ((b & 1 << h) == 0)
					kk[b | 1 << h] += kk[b];
		int[] dp = new int[1 << m];
		int m_ = (1 << m) - 1;
		for (int b = 1; b < 1 << m; b++) {
			int k = n - 1 - kk[b] - kk[m_ ^ b];
			int x = INF;
			for (int h = 0; h < m; h++)
				if ((b & 1 << h) != 0) {
					int b_ = b ^ 1 << h;
					x = Math.min(x, dp[b_]);
				}
			dp[b] = x == INF ? INF : x + k;
		}
		println(dp[m_]);
	}
}
