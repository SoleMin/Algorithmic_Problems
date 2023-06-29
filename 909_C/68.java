import java.util.*;
import java.io.*;

public class p3sol{

	static char[] c;
	static int[][] dp;
	static int mod = (int)1e9 + 7;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		c = new char[n];

		for(int i = 0; i < n; i++)
			c[i] = br.readLine().charAt(0);

		dp = new int[n + 1][n + 1];

		dp[0][0] = 1;

		for(int i = 0; i < n - 1; i++){
			if(c[i] == 's'){
				int prev = 0;
				for(int j = i; j >= 0; j--){
					prev += dp[i][j];
					prev %= mod;
					dp[i + 1][j] += prev;
					dp[i + 1][j] %= mod;
				}
			}
			else{
				for(int j = 1; j <= n; j++){
					dp[i + 1][j] += dp[i][j - 1];
					dp[i + 1][j] %= mod;
				}
			}
		}

		int ans = 0;
		for(int i = 0; i < n; i++){
			ans += dp[n - 1][i];
			ans %= mod;
		}

		// print(dp);

		System.out.println(ans);
		
		br.close();
	}

	public static void print(int[][] a){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println("");
		}
	}

}