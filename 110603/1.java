import java.io.*;
import java.math.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		BigInteger[] dp = new BigInteger[1001];
		dp[0] = BigInteger.ONE;
		dp[1] = BigInteger.valueOf(2);
		dp[2] = BigInteger.valueOf(5);
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1].add(dp[i - 1]).add(dp[i - 2]).add(dp[i - 3]);
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