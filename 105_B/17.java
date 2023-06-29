import java.util.*;

public class b {
	static int n,k,A;
	static int[] l,p;
	static double [][][] memo;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		k = in.nextInt();
		A = in.nextInt();
		memo = new double[n+1][n+1][1<<n];
		l = new int[n];
		p = new int[n];
		for(int i=0; i<n; i++) {
			l[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		System.out.printf("%.10f%n",go(0,k));
	}
	static double go(int pos, int left) {
		if(pos==n) {
			for(int i=0; i<=n; i++)
				for(int j=0; j<=n; j++)
					Arrays.fill(memo[i][j],-1);
			return go2(0,n/2+1,0);
		}
		double best = go(pos+1,left);
		if(left == 0) return best;
		if(p[pos] < 100) {
			p[pos] += 10;
			best = Math.max(best, go(pos,left-1));
			p[pos] -= 10;
		}
		return best;
	}
	static double go2(int pos, int needed, int mask) {
		if(needed == 0) return 1.0;
		if(pos == n) {
			int tot = 0;
			for(int i=0; i<n; i++)
				if((mask&(1<<i))!=0)
					tot += l[n-i-1];
			return (A)/(A+tot+0.0);
		}
		if(memo[pos][needed][mask] != -1) 
			return memo[pos][needed][mask];
		double a = (p[pos]/100.)*go2(pos+1,needed-1,mask*2);
		double b = (1-(p[pos]/100.))*go2(pos+1,needed,mask*2+1);
		return memo[pos][needed][mask] = a+b;
	}
}
