// https://codeforces.com/contest/1185/submission/55800229 (rainboy)
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
	static int[][][] init(int n, int na, int nb, int nc) {
		int[][][] dp = new int[na + 1][nb + 1][nc + 1];
		int[][][][] dq = new int[na + 1][nb + 1][nc + 1][3];
		for (int ma = 0; ma <= na; ma++)
			for (int mb = 0; mb <= nb; mb++)
				for (int mc = 0; mc <= nc; mc++)
					if (ma == 0 && mb == 0 && mc == 0) {
						dp[ma][mb][mc] = 1;
						dq[ma][mb][mc][0] = dq[ma][mb][mc][1] = dq[ma][mb][mc][2] = 1;
					} else {
						int x0 = ma > 0 ? (int) ((long) dq[ma - 1][mb][mc][0] * ma % MD) : 0;
						int x1 = mb > 0 ? (int) ((long) dq[ma][mb - 1][mc][1] * mb % MD) : 0;
						int x2 = mc > 0 ? (int) ((long) dq[ma][mb][mc - 1][2] * mc % MD) : 0;
						dp[ma][mb][mc] = (int) (((long) x0 + x1 + x2) % MD);
						dq[ma][mb][mc][0] = (x1 + x2) % MD;
						dq[ma][mb][mc][1] = (x2 + x0) % MD;
						dq[ma][mb][mc][2] = (x0 + x1) % MD;
					}
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
