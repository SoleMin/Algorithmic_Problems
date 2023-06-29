import java.math.BigInteger;
import java.util.Scanner;

class Main {
  static String X;
  static String Z;
  static BigInteger dp[][] = new BigInteger[101][10001];

  public static void solve() {
    int I = Z.length();
    int J = X.length();
	  for (int i = 0; i <= I; i++)
		  for (int j = 0; j <= J; j++)
			  dp[i][j] = BigInteger.valueOf(0);
	  for (int j = 0; j <= J; j++)
		  dp[0][j] = BigInteger.valueOf(1);
	  for (int i = 1; i <= I; i++)
		  dp[i][0] = BigInteger.valueOf(0);
    
	  for (int j = 1; j <= J; j++) {
		  for (int i = 1; i <= I; i++) {
        if (Z.charAt(i - 1) == X.charAt(j - 1))
				  dp[i][j] = (dp[i][j - 1]).add(dp[i - 1][j - 1]);
			  else
				  dp[i][j] = dp[i][j - 1];
		  }
	  }

    System.out.println(dp[I][J]);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t != 0) {
      X = in.next();
      Z = in.next();
      solve();
      t = t - 1;
    }
  }
}