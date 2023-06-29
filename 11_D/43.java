import java.util.Scanner;

public class Hello {
		public static void main(String[] args){			
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			int m = scan.nextInt();
			boolean[][] graph = new boolean[n][n];
			
			for(int i = 0; i < m; i++) {
				int from = scan.nextInt() - 1;
				int to = scan.nextInt() - 1;
				graph[from][to] = graph[to][from] = true;
			}
			
			int max = 1 << n;
			long[][] dp = new long[max][n];
			
			for(int mask = 1; mask < max; mask++) {
				for(int i = 0; i < n; i++) {
					boolean existI = (mask & (1 << i)) > 0;
					if(Integer.bitCount(mask) == 1 && existI) {
						dp[mask][i] = 1;
					} else if(Integer.bitCount(mask) > 1 && existI && first(mask) != i) {
						long sum = 0; 
						for(int j = 0; j < n; j++) {
							if(graph[i][j]) sum += dp[mask ^ (1 << i)][j];
						}
						dp[mask][i] = sum;
					}
				}
			}
			
			long countCycles = 0;
			for(int mask = 7; mask < max; mask++) {
				for(int i = 0; i < n; i++) {
					if(Integer.bitCount(mask) >= 3 && graph[first(mask)][i]) {
						countCycles += dp[mask][i];
					}
				}
			}
			System.out.println(countCycles / 2);
		}
		
		
		public static int first(int mask) {
			int i = 0;
			while((mask & (1 << i++)) == 0);
			return i - 1; 
		}
}