import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int E = in.nextInt();
        boolean [][] G = new boolean [V][V];
        for (int i = 0; i < E; i++) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            G[u][v] = true;
            G[v][u] = true;
        }
        
        int pset = 1 << V;
        
        long [][] dp = new long [pset][V];
        long cycles = 0;
        
        for (int set = 1; set < pset; set++) {
            int bit = Integer.bitCount(set);
            int src = first(set);
            
            if (bit == 1) {
                dp[set][src] = 1;
            }
            else if(bit > 1) {
                for (int i = 0; i < V; i++) {
                    if(i == src) continue;
                    // Check if i is in set
                    if ((set & (1 << i)) != 0) {
                        int S_1 = set ^ (1 << i);
                        for (int v = 0; v < V; v++) {
                            if (G[v][i] == true) {
                                dp[set][i] += dp[S_1][v];
                            }
                        }
                    }
                    //Count Cycles:
                    if (bit >= 3 && G[src][i]) {
                        cycles += dp[set][i];
                    }   
                }
                
            }
                    
                    
        }
        System.out.println(cycles/2);
    }
    
    public static int first(int n) {
        int cnt = 0;
        while ((n & 1) != 1) {
            cnt++;
            n >>= 1;
        }
        return cnt;
    }
}