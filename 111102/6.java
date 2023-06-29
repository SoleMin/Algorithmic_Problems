import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			
			int s1_l = s1.length();
			int s2_l = s2.length();

			BigInteger[][] dp = new BigInteger[s1_l+1][s2_l+1];
			
			for(int j = 0; j <= s1_l; j++) {
				dp[j][0] = BigInteger.ONE;
			}
			
			for(int j = 1; j <= s2_l; j++) {
				dp[0][j] = BigInteger.ZERO;
			}
			
			for(int c = 1; c <= s1_l; c++) {
				for(int r = 1; r <= s2_l; r++) {
					if(s1.charAt(c-1) == s2.charAt(r-1)) {
						dp[c][r] = dp[c-1][r-1].add(dp[c-1][r]);
					}
					else {
						dp[c][r] = dp[c-1][r];
					}
				}
			}
			
			System.out.println(dp[s1_l][s2_l]);
			
		}
		
	}
}