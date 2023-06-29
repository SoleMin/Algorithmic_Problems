import java.util.*;

public class cf16e {
	static int n;
	static double[][] prob;
	static double[] memo;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		prob = new double[n][n];
		memo = new double[1<<n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				prob[i][j] = in.nextDouble();
		memo[(1<<n)-1] = 1;
		for(int k=(1<<n)-1; k>0; k--) {
			int numWays = Integer.bitCount(k);
			numWays = (numWays*(numWays-1))/2;
			for(int first = 0; first < n; first++) {
				if(!isSet(k,first)) continue;
				for(int second = first+1; second < n; second++) {
					if(!isSet(k,second)) continue;
					memo[reset(k,first)] += prob[second][first]*memo[k]/numWays;
					memo[reset(k,second)] += prob[first][second]*memo[k]/numWays;
				}
			}
		}
		for(int i=0; i<n; i++)
			System.out.printf("%.6f ", memo[set(0,i)]);
		System.out.println();
	}
	static boolean isSet(int x, int p) {
		return (x&(1<<p)) != 0;
	}
	static int set(int x, int p) {
		return x|(1<<p);
	}
	static int reset(int x, int p) {
		return x&~(1<<p);
	}
	static boolean isDone(int x) {
		return Integer.bitCount(x)==n-1;
	}
}
