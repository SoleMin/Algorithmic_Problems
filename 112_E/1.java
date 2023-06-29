import java.util.*;

public class cf112e {
	static int n,m,s;
	static int[][][] memo;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		if(n > m) {
			int tmp = n;
			n = m;
			m = tmp;
		}
		s = (1<<n);
		memo = new int[s][s][m];
		for(int i=0; i<s; i++)
			for(int j=0; j<s; j++)
				Arrays.fill(memo[i][j], -1);
		int ret = go(0,0,0);
		System.out.println(n*m - ret);
	}
	static int go(int last, int trans, int r) {
		if(r==m) {
			if(trans == 0) return 0;
			return 100;
		}
		if(memo[last][trans][r] != -1) return memo[last][trans][r];
		int best = 100;
		for(int crnt = 0; crnt < s; crnt++) {
			if((trans & ~crnt) != 0) continue; //certain ones have to be here
			for(int pass = 0; pass < s; pass++) {
				int tmp = ((1<<n)-1) & ~last;	//move back the ones you can
				if((pass & ~tmp) != 0) continue; //certain ones have to move on
				tmp = tmp & ~pass; //find which ones stay
				boolean fail = false;
				for(int k=0; k<n; k++) //make sure that the ones that stay
					if(isSet(tmp,k) && !(isSet(crnt,k-1) || isSet(crnt,k) || isSet(crnt,k+1)))
						fail = true;
				if(fail) continue;
				best = Math.min(best, Integer.bitCount(crnt) + go(crnt,pass,r+1));
			}
		}
		return memo[last][trans][r] = best;
	}
	static boolean isSet(int x, int p) {
		if(p < 0 || p >= n) return false;
		return (x & (1<<p)) != 0;
	}
}
