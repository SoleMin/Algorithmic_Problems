import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t=input.nextInt();
		for(int i=0; i<t; i++) {
			String x=input.next();
			String z=input.next();

			long[][] dp=new long[z.length()][x.length()];
			if(x.charAt(0)==z.charAt(0)) {
				dp[0][0]=1;
			}

			for(int a=1; a<x.length(); a++) {
				if(x.charAt(a)==z.charAt(0))
					dp[0][a]=dp[0][a-1]+1;
				else
					dp[0][a]=dp[0][a-1];
			}

			for(int j=1; j<z.length(); j++) {
				for(int k=j; k<x.length(); k++) {
					if(x.charAt(k)==z.charAt(j))
						dp[j][k]=dp[j][k-1]+dp[j-1][k-1];
					else
						dp[j][k]=dp[j][k-1];
				}
			}

			System.out.println(dp[z.length()-1][x.length()-1]);

		}

		input.close();

	}

}
