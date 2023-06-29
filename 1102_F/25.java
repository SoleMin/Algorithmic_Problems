import java.util.Scanner;

public class Main {
	
	private static boolean check(int n , int m , int k) {
		
		for (int i = 0;i < n;i ++) {
			for (int j = 0;j < n;j ++) {
				for (int l = 0;l < (1 << n);l ++) {
					dp[i][j][l] = - 1;
				}
			}
		}
		for (int i = 0;i < n;i ++) {
			if (dfs(i , i , n , m , k , 0)) {
				return true;
			}
		}
		return false;
		
	}	
	
	private static boolean dfs(int first , int current , int n , int m , int k , int bitmap) {
	
		bitmap |= (1 << current);
		if (bitmap == (1 << n) - 1) {
			// check first and current			
			if (n == 1) {
				if (m > 1) {
					if (rowMinDist[current] >= k) {
						return true;
					} else {					
						return false;
					}
				} else {
					return true;
				}
			} else {
				if (m > 1) {
					if (minDistBetweenHeadAndTail[first][current] >= k) {
						return true;
					} else {
						return false;
					}
				} else {
					return true;
				}
			}
		} else {
			if (dp[first][current][bitmap] >= 0) {
				if (dp[first][current][bitmap] > 0) {
					return true;
				} else {
					return false;
				}
			}
			
			short ans = 0;
			for (int i = 0;i < n;i ++) {
				if ((bitmap & (1 << i)) == 0 && minDistBetweenRow[current][i] >= k) {					
					if (dfs(first , i , n , m , k , bitmap)) {
						ans = 1;
						break;
					}
				}
			}
			
			dp[first][current][bitmap] = ans;
			if (ans > 0) {			
				return true;
			} else {
				return false;
			}
		}
		
	}

	private static short[][][] dp = new short[20][20][(1 << 17)];	
	private static int[][] input = new int[20][10010];
	private static int[][] minDistBetweenRow = new int[20][20];
	private static int[][] minDistBetweenHeadAndTail = new int[20][20];
	private static int[] rowMinDist = new int[20];
	
	public static void main(String[] args) {		
	
		Scanner scan = new Scanner(System.in);
	
		int i , j , k , n , m;
		n = scan.nextInt();
		m = scan.nextInt();
		for (i = 0;i < n;i ++) {
			for (j = 0;j < m;j ++) {
				input[i][j] = scan.nextInt();
			}
		}
		for (i = 0;i < n;i ++) {
			for (j = i + 1;j < n;j ++) {
				int minDist = - 1;
				for (k = 0;k < m;k ++) {
					int dist = Math.abs(input[i][k] - input[j][k]);
					if (dist < minDist || minDist < 0) {
						minDist = dist;
					}
				}
				minDistBetweenRow[i][j] = minDistBetweenRow[j][i] = minDist;		
			}
		}
		for (i = 0;i < n;i ++) {
			for (j = 0;j < n;j ++) {
				if (i != j) {
					// i head , j tail
					int minDist = - 1;
					for (k = 0;k < m - 1;k ++) {						
						int dist = Math.abs(input[j][k] - input[i][k + 1]);
						if (dist < minDist || minDist < 0) {
							minDist = dist;
						}
					}
					minDistBetweenHeadAndTail[i][j] = minDist;
				}
			}
		}		
		for (i = 0;i < n;i ++) {
			int minDist = - 1;
			for (j = 0;j < m - 1;j ++) {
				int dist = Math.abs(input[i][j] - input[i][j + 1]);
				if (dist < minDist || minDist < 0) {
					minDist = dist;
				}
			}
			rowMinDist[i] = minDist;
		}
		int low = 0 , high = 1000000010;
		while (low < high) {
			int mid = (low + high) / 2;
			if (check(n , m , mid)) {				
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		System.out.println(high - 1);

	}
   
    
}














