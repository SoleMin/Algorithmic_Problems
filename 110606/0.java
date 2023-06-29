import java.io.*;
import java.math.*;
import java.util.*;

class Main {
	static final long INF = Long.MAX_VALUE / 2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		BigInteger[] dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		dp[2] = BigInteger.valueOf(3);
		dp[3] = BigInteger.valueOf(5);
		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1].add(dp[i - 1]).add(BigInteger.ONE);
			for (int j = 2;; j++) {
				BigInteger x = dp[i - j].add(dp[i - j]).add(BigInteger.valueOf(2).pow(j).subtract(BigInteger.ONE));
				if (dp[i].compareTo(x) <= 0) {
					break;
				}
				dp[i] = x;
			}
		}
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			int N = Integer.parseInt(line);
			out.append(dp[N]).append('\n');
		}
		
		System.out.print(out);
		
		br.close();
	}
}