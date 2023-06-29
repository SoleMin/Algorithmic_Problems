import java.io.*;
import java.util.*;

public class tree_small_distance {

	static ArrayList<Integer> [] adj; static int [][] dp; static int ans;
	
    public static void main(String[] args) throws Exception{
    	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        StringTokenizer line = new StringTokenizer(in.readLine());
        
        int n = Integer.parseInt(line.nextToken());
        
        adj = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
        	line = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(line.nextToken()); 
            int y = Integer.parseInt(line.nextToken());
            adj[x].add(y); adj[y].add(x);
        }
        
        dp = new int[n + 1][3]; ans = 0;
        for (int [] arr: dp) {
            Arrays.fill(arr, Integer.MAX_VALUE / 2);
        }
        
        dfs(1, -1, 0);
        out.println(ans);
        out.close();
    }
 
    static void dfs(int cur, int par, int dep) {
    	
        for (Integer next: adj[cur]) {
            if (next != par) {
                dfs(next, cur, dep + 1);
            }
        }
        
        if (dep == 0) {
        	return;
        }
        
        if (dep == 1) {
            dp[cur][0] = 0;
            for (Integer next: adj[cur]) {
                if (next != par) {
                    dp[cur][0] += Math.min(dp[next][0], dp[next][1]);
                }
            }
            ans += dp[cur][0];
        } else if (dep == 2) {
            dp[cur][0] = 0; dp[cur][1] = 0;
            for (Integer next: adj[cur]) {
                if (next != par) {
                    dp[cur][0] += Math.min(dp[next][0], dp[next][1]);
                    dp[cur][1] += Math.min(dp[next][0], dp[next][2]);
                }
            }
            dp[cur][0]++;
        } else {
            int temp = 0; dp[cur][0] = 0; dp[cur][1] = 0;
            for (Integer next: adj[cur]) {
                if (next != par) {
                    dp[cur][0] += Math.min(dp[next][0], dp[next][1]);
                    dp[cur][1] += Math.min(dp[next][0], dp[next][2]);
                    temp += Math.min(dp[next][0], dp[next][2]);
                }
            }
            
            for (Integer next: adj[cur]) {
                if (next != par) {
                    dp[cur][2] = Math.min(dp[cur][2], temp - Math.min(dp[next][0], dp[next][2]) + dp[next][0]);
                }
            }
            dp[cur][0]++;
        }
    }
	
}
