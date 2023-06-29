

import java.util.Scanner;

public class Main {
	static int maxn = 200005;
	static int dp[] = new int[maxn];
	static int arr[] = {0,-1,-1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "#";
		String s1 = in.next();
		s += s1;
		int r = 0;
		char c[] = s.toCharArray();
		for(int i = 1; i < s.length(); i++) {
			r = (r + c[i] - '0') % 3;
			dp[i] = dp[i - 1];
			if(arr[r] != -1) {
				dp[i] = Math.max(dp[i], dp[arr[r]] + 1);
			}
			arr[r] = i;
		}
		System.out.println(dp[s.length() - 1]);
	}
}

  	 	   		  		 	   			    		  	