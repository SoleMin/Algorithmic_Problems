import java.io.*;
import java.util.*;

public class CF1185G2 {
	static final int MD = 1000000007;
	static int[][] solve1(int[] aa, int t, int n) {
		int[][] da = new int[t + 1][n + 1];
		da[0][0] = 1;
		for (int i = 0; i < n; i++) {
			int a = aa[i];
			for (int s = t - 1; s >= 0; s--)
				for (int m = 0; m < n; m++) {
					int x = da[s][m];
					if (x != 0) {
						int s_ = s + a;
						if (s_ <= t)
							da[s_][m + 1] = (da[s_][m + 1] + x) % MD;
					}
				}
		}
		return da;
	}
	static int[][][] solve2(int[] aa, int[] bb, int t, int na, int nb) {
		int[][] da = solve1(aa, t, na);
		int[][][] dab = new int[t + 1][na + 1][nb + 1];
		for (int s = 0; s <= t; s++)
			for (int ma = 0; ma <= na; ma++)
				dab[s][ma][0] = da[s][ma];
		for (int i = 0; i < nb; i++) {
			int b = bb[i];
			for (int s = t - 1; s >= 0; s--)
				for (int ma = 0; ma <= na; ma++)
					for (int mb = 0; mb < nb; mb++) {
						int x = dab[s][ma][mb];
						if (x != 0) {
							int s_ = s + b;
							if (s_ <= t)
								dab[s_][ma][mb + 1] = (dab[s_][ma][mb + 1] + x) % MD;
						}
					}
		}
		return dab;
	}
	static long power(int a, int k) {
		if (k == 0)
			return 1;
		long p = power(a, k / 2);
		p = p * p % MD;
		if (k % 2 == 1)
			p = p * a % MD;
		return p;
	}
	static int[] ff, gg;
	static int ch(int n, int k) {
		return (int) ((long) ff[n] * gg[n - k] % MD * gg[k] % MD);
	}
	static int[][][] init(int n, int na, int nb, int nc) {
		ff = new int[n + 1];
		gg = new int[n + 1];
		for (int i = 0, f = 1; i <= n; i++) {
			ff[i] = f;
			gg[i] = (int) power(f, MD - 2);
			f = (int) ((long) f * (i + 1) % MD);
		}
		int[][][] dp = new int[na + 1][nb + 1][nc + 1];
		for (int ma = 0; ma <= na; ma++)
			for (int mb = 0; mb <= nb; mb++)
				for (int mc = 0; mc <= nc; mc++) {
					int x = (int) ((long) ff[ma + mb + mc] * gg[ma] % MD * gg[mb] % MD * gg[mc] % MD);
					for (int ma_ = ma == 0 ? 0 : 1; ma_ <= ma; ma_++) {
						int cha = ma == 0 ? 1 : ch(ma - 1, ma_ - 1);
						for (int mb_ = mb == 0 ? 0 : 1; mb_ <= mb; mb_++) {
							int chb = mb == 0 ? 1 : ch(mb - 1, mb_ - 1);
							for (int mc_ = mc == 0 ? 0 : 1; mc_ <= mc; mc_++) {
								int chc = mc == 0 ? 1 : ch(mc - 1, mc_ - 1);
								int y = dp[ma_][mb_][mc_];
								if (y == 0)
									continue;
								x = (int) ((x - (long) y * cha % MD * chb % MD * chc) % MD);
							}
						}
					}
					if (x < 0)
						x += MD;
					dp[ma][mb][mc] = x;
				}
		for (int ma = 0; ma <= na; ma++)
			for (int mb = 0; mb <= nb; mb++)
				for (int mc = 0; mc <= nc; mc++)
					dp[ma][mb][mc] = (int) ((long) dp[ma][mb][mc] * ff[ma] % MD * ff[mb] % MD * ff[mc] % MD);
		return dp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] aa = new int[n];
		int[] bb = new int[n];
		int[] cc = new int[n];
		int na = 0, nb = 0, nc = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			if (g == 1)
				aa[na++] = a;
			else if (g == 2)
				bb[nb++] = a;
			else
				cc[nc++] = a;
		}
		int[][][] dp = init(n, na, nb, nc);
		int[][][] dab = solve2(aa, bb, t, na, nb);
		int[][] dc = solve1(cc, t, nc);
		int ans = 0;
		for (int tab = 0; tab <= t; tab++) {
			int tc = t - tab;
			for (int ma = 0; ma <= na; ma++)
				for (int mb = 0; mb <= nb; mb++) {
					int xab = dab[tab][ma][mb];
					if (xab == 0)
						continue;
					for (int mc = 0; mc <= nc; mc++) {
						int xc = dc[tc][mc];
						if (xc == 0)
							continue;
						ans = (int) ((ans + (long) xab * xc % MD * dp[ma][mb][mc]) % MD);
					}
				}
		}
		System.out.println(ans);
	}
}