import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while ( sc.hasNextInt() ) {
			int n = sc.nextInt();
			long m = sc.nextInt();
			boolean edge[][] = new boolean[n][n];
			long dp[][] = new long[1<<n][n];
			for ( long i = 1 ; i<=m ; ++i ) {
	 			int u = sc.nextInt();   
				int v = sc.nextInt();
				-- u;
				-- v;
				edge[u][v] = edge[v][u] = true;
			}
			for ( int i = 0 ; i<n ; ++i ) {
				dp[1<<i][i] = 1;
			}
			long res = 0;
			for ( int i = 1 ; i<(1<<n) ; ++i ) {
				int first = cal(i);
				for ( int j = first ; j<n ; ++j ) {
					if ( dp[i][j]==0 ) {
						continue;
					}
					for ( int k = first ; k<n ; ++k ) {
 						if ( j==k || !edge[j][k] ) {
							continue;
						}
						if ( k==first && judge(i) ) {
							res += dp[i][j];
						}
						if ( (i&(1<<k))==0 ) {
							dp[i|(1<<k)][k] += dp[i][j];
						}
					}
				}
			}
			System.out.println(res/2);		
		}
	}
	public static int cal( int x ) {
		int ord = 0;
		while ( true ) {
			if ( (x&(1<<ord))!=0 ) {
				break;
			}
			++ ord;
		}
		return ord;
	}
	public static boolean judge( int x ) {
		int cnt = 0;
		while ( x>=1 ) {
			if ( (x&1)==1 ) {
				++ cnt;
			}
			x >>= 1;
		}
		return cnt >= 3;
	}
}
