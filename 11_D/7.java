

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        boolean[][] graph = new boolean[n][n];
        
        for(int i = 0; i < m; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            graph[from][to] = true;
            graph[to][from] = true;
        }

        int max = 1 << n;
        long[][] dp = new long[max][n];
        for(int mask = 1; mask < max; mask++) {
            for(int i = 0; i < n; i++) {
                int countMask = Integer.bitCount(mask); 
                boolean existSubSeti = (mask & (1 << i)) > 0;
                if(countMask == 1 && existSubSeti) {
                    dp[mask][i] = 1; 
                }
                else if(countMask > 1 && existSubSeti) {
                    int mask1 = mask ^ (1 << i);
                    for(int j = 0; j < n; j++) {
                        if(((mask1 & (1 << j)) > 0) && graph[j][i] && i != firstMask(mask, n)) {
                            dp[mask][i] += dp[mask1][j]; 
                        }
                    }
                }
            }
        }
        
        long counter = 0; 
        for(int mask = 1; mask < max; mask++) {
            for(int i = 0; i < n; i++) {
                if(Integer.bitCount(mask) >= 3 && graph[firstMask(mask, n)][i]) {
                    counter += dp[mask][i];
                }
            }
            
        }
        System.out.println(counter / 2);
        in.close();
    }
    
    public static int firstMask(int mask, int n) { 
        for(int i = 0; i < n; i++) {
            if((mask & (1 << i)) > 0) return i;
        }
        return -1;
        
    }
}
