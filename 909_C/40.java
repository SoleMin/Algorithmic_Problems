import java.io.*;
import java.util.*;

public class Codeforces455Div2C {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		char[] list = new char[n];
		for (int i = 0; i < n; i++) {
			sp = br.readLine().split(" ");
			list[i] = sp[0].charAt(0);
		}
		
		int[] list2 = new int[n];
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (list[i] == 's') {
				counter++;
			}
			else {
				list2[counter]++;
			}
		}
		
		int[][] dp = new int[counter][n-counter+1];
		int[][] dpsum = new int[counter][n-counter+1];
		int[] count = new int[counter];
		count[0] = list2[0];
		for (int i = 1; i < counter; i++) {
			count[i] = count[i-1] + list2[i];
		}
		
		for (int i = 0; i <= count[0]; i++) {
			dp[0][i] = 1;
			dpsum[0][i] = i+1;
		}
		for (int i = 1; i < counter; i++) {
			for (int j = 0; j <= count[i]; j++) {
				dp[i][j] = dpsum[i-1][Math.min(j, count[i-1])];
			}
			dpsum[i][0] = dp[i][0];
			for (int j = 1; j <= count[i]; j++) {
				dpsum[i][j] = (dpsum[i][j-1]+dp[i][j])%1000000007;
			}
		}
		
		System.out.println(dp[counter-1][n-counter]);
	}
}