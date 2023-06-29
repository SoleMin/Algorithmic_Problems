//package contest10D;
import java.math.*;
import java.util.*;
import static java.math.BigInteger.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Main {
	static void debug(Object... os) {
		System.err.println(deepToString(os));
	}

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		boolean[][] bs=new boolean[n][n];
		for (int i = 0; i < m; i++) {
			int s=sc.nextInt()-1,t=sc.nextInt()-1;
			bs[s][t] = bs[t][s] = true;
		}
		long res = 0;
		for(int i=0;i<n;i++){
			res += calc(bs,n-1-i);
		}
		System.out.println(res/2);
	}
	long calc(boolean[][] bs,int n){//start is n.
		long[][] dp=new long[1<<n][n]; // set,last -> number of path n -> last.
		for(int i=0;i<n;i++){
			if(bs[i][n])
				dp[1<<i][i] ++;
		}
		for(int i=1;i<1<<n;i++){
			for(int j=0;j<n;j++)if(((i>>j)&1)==1)
				for(int k=0;k<n;k++)if(((i>>k)&1)==0 && bs[j][k]){//add
					dp[i|(1<<k)][k] += dp[i][j];
				}
		}
		long res=0;
		for(int i=0;i<1<<n;i++)for(int j=0;j<n;j++)if(Integer.bitCount(i)>=2&&bs[j][n])res+=dp[i][j];
		return res;
	}
	
}