//package Dp_bitmasking;
import java.util.*;
public class Fish {
	static double[][] prob;
	static double[] dp=new double[1<<19];
	static double pmove(int mask,int fish_to_kill,int n) {
		int count=0;
		for(int i=0;i<n;i++) {
			if((mask&(1<<i))!=0) {
				++count;
			}
		}
		long totalPairs=(count*(count-1))/2;
		double prob_die=0;
		for(int fish=0;fish<n;fish++) {
			if((mask&(1<<fish))!=0) {
				prob_die+=prob[fish][fish_to_kill];
			}
		}
		return prob_die/totalPairs;
	}
	
	static double solve(int mask,int n) {
		if(mask==((1<<n)-1)) {
			return 1;
		}
		if(dp[mask]>-0.9) {
			return dp[mask];
		}
		double ans=0;
		for(int fish=0;fish<n;fish++) {
			if((mask&(1<<fish))==0) {
				int prev_mask=mask|(1<<fish);
				ans+=pmove(prev_mask,fish,n)*solve(prev_mask,n);
			}
		}
		dp[mask]=ans;
		return dp[mask];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		prob=new double[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				prob[i][j]=sc.nextDouble();
			}
		}
		Arrays.fill(dp, -1);
		for(int i=0;i<n;i++) {

			System.out.print(String.format("%.06f", solve(1<<i,n))+" ");
		}
		
	}

}
