import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int numbOfStatements = in.nextInt();
		long[] dp = new long[numbOfStatements];
		dp[0] = 1L;
		boolean priorFor = in.next().equals("f");
		
		for(int i=0; i<numbOfStatements-1; i++)
		{
			String type = in.next();
			if (priorFor) {
				for(int j=numbOfStatements-1;j>0;j--) {
					dp[j] = dp[j-1];
				}
				dp[0] = 0L;
			} else {
				long sum = 0;
				for(int j = numbOfStatements - 1; j >= 0; --j) {
					sum = (sum + dp[j])  % 1000000007;
					dp[j] = sum;
				}
			}
			priorFor = type.equals("f");
		}
		long ans = 0;
		for(int j=0; j<numbOfStatements; j++) {
			ans = (ans + dp[j]) % 1000000007;
		}
		System.out.println(ans);
	}

}