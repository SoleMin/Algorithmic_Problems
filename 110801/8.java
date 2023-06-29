import java.util.*;

class Main {
	
	static int squares(int i) {
		if ((i & 1) == 1) {
			return i / 4 * 2 + 1;
		} else {
			return (i - 1) / 4 * 2 + 2;
		}
	}
	
	static long findBishop(int n, int k) {
		if (k > 2 * n - 1) return 0;
		
		long[][] dp = new long[n*2][k+1];
		
		for (int i=0; i < n*2; i++) dp[i][0] = 1;
		dp[1][1] = 1;
		
		for (int i=2; i < n*2; i++) {
			for (int j=1; j <= k; j++) {
				dp[i][j] = dp[i-2][j] + dp[i-2][j-1]*(squares(i) - j + 1);
			}
		}
		
		long ans = 0;
		for(int i=0; i <= k; i++) {
			ans += dp[n*2-1][i] * dp[n*2-2][k-i];
		}
		return ans;
	}
	
	static String solution(String str) {
		String answer = "";
		
		String[] params = str.split(" ");
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		answer = String.format("%d", findBishop(x,y));
		
		return answer;
	}
	
	static void print(String result) {
		System.out.println(result);
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(line == null || line.length() == 0) break;
			if ("0 0".equals(line)) break;
			
			String result = solution(line);
			print(result);
		}
		
		scanner.close();
	}
}