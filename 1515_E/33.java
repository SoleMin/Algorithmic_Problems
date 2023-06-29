import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Practice {
	public static long mod = (long) Math.pow(10, 9) + 7;
	public static long[][] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		String[] s2 = br.readLine().split(" ");

		int n = (int) Long.parseLong(s2[0]);
		long m = Long.parseLong(s2[1]);
		dp = new long[n + 2][n + 2];
		long[] power = new long[n + 1];
		mod = m;
		long[][] choose = new long[n + 2][n + 2];
		getPow(power, n + 1);
		getChoose(choose, n + 2, n + 2);
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				for (int k = 1; k + i <= n; k++) {
				//	System.out.println((j + k) + " " + k + " - " + choose[j + k][k]);
					dp[i + k + 1][j
							+ k] = (dp[i + k + 1][j + k] + (((dp[i][j] * power[k - 1]) % mod) * choose[j + k][k]) % mod)
									% mod;
				}
			}
		}
		long ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = (ans + dp[n + 1][i]) % mod;
		}
		pw.println(ans);
		pw.close();
	}

	private static void getChoose(long[][] choose, int up, int dow) {
		// TODO Auto-generated method stub
		for (int i = 1; i < up; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1 && i == 1) {
					choose[i][j] = 1;
				} else if (j == 1) {
					choose[i][j] = i;
				} else {
					choose[i][j] = (choose[i - 1][j] + choose[i - 1][j - 1]) % mod;
				}
			}
		}
	}

	private static void getPow(long[] power, int l) {
		// TODO Auto-generated method stub
		for (int i = 0; i < l; i++) {
			if (i == 0) {
				power[i] = 1;
			} else {
				power[i] = (power[i-1] * 2) % mod;
			}
		}
	}

}

//private static long getGCD(long l, long m) {
//// TODO Auto-generated method stub
//
//long t1 = Math.min(l, m);
//long t2 = Math.max(l, m);
//while (true) {
//	long temp = t2 % t1;
//	if (temp == 0) {
//		return t1;
//	}
//	t2 = t1;
//	t1 = temp;
//}
//}