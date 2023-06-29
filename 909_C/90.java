import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		long MOD = 1000000007;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][]dp = new long[n][5010];
		char[] program = new char[n];
		
		for(int i = 0; i < n; i++){
			program[i] = sc.next().charAt(0);
		}
		
		dp[0][0] = 1;
		
		long[] acc = new long[5010];
		
		acc[0] = 1;
		
		for(int i = 1 ; i < n; i++){
			for(int j = 0; j< 5010; j++){
				if(program[i-1] == 'f'){
					if(j - 1 >= 0){
						dp[i][j] = dp[i-1][j-1];
					}
				}else{
					dp[i][j] = acc[j];
				}
			}
			acc[5009] = dp[i][5009];
			for(int j = 5008; j >= 0; j--){
				acc[j] = (acc[j + 1] + dp[i][j]) % MOD;
			}
		}
		System.out.println(acc[0]);
	}
}
