import java.io.*;
import java.util.*;
import java.math.*;
class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i = 0; i < cases; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			k = k + 8 ;
			int[][] dp = new int[k+1][n+1];
			int[] length = new int[n+1];
			
			for(int j = 0; j < n; j++) {
				length[n-j] = sc.nextInt();
			}


			for(int r = 0; r <= n; r++) {
				dp[0][r] = 0;
			}
			
			for(int c = 1; c <= k; c++) {
				int limit = 3 * c;
				for(int r = 0; r < limit; r++) {
					dp[c][r] = 99999;
				}
			}
			
			for(int c = 1; c <= k; c++) {
				int start = 3 * c; 
				for(int r = start; r <=n; r++) {
					int dif = length[r-1] - length[r];
					dp[c][r] = Math.min(dp[c][r-1],dp[c-1][r-2] + dif * dif);
				}
			}
	
			System.out.println(dp[k][n]);
			
		}
	}
}