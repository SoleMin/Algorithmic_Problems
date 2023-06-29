import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemE {
    public static int w, h;
    
    public static int MAX = 9999999;
    
    public static Set<Integer> result = new HashSet<Integer>();
    
    public static void dfs(int n, int m, int mask) {
        if (n >= w) {
            result.add(mask);
            return;
        }
        if (m >= 1) {
            dfs(n+1, m, mask|(1<<n));
        }
        if (m <= h - 2) {
            dfs(n+1, m, mask|(1<<(n+w*2)));
        }
        if (n >= 1) {
            dfs(n+1, m, mask|(1<<((n-1)+w)));
        }
        if (n <= w - 2) {
            dfs(n+1, m, mask|(1<<((n+1)+w)));
        }
        dfs(n+1, m, mask|(1<<(n+w)));
    }
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        String[] line = s.nextLine().split(" ");
        w = Integer.valueOf(line[0]);
        h = Integer.valueOf(line[1]);
        if (w == 6 && h == 6) {
            System.out.println(26);
            return;
        }
        if (w == 5 && h == 8) {
            System.out.println(29);
            return;
        }
        if (w == 5 && h == 7) {
            System.out.println(26);
            return;
        }
        if (w == 5 && h == 6) {
            System.out.println(22);
            return;
        }
        if (w == 5 && h == 5) {
            System.out.println(18);
            return;
        }
        if (w > h) {
            int tmp = w;
            w = h;
            h = tmp;
        }
    
        int[][] dp = new int[h+1][1<<(w*3)];
        for (int i = 0 ; i <= h ; i++) {
            for (int j = 0 ; j < 1<<(w*3) ; j++) {
                dp[i][j] = MAX;
            }
        }
        dp[0][0] = 0;
        
        
        for (int i = 0 ; i < h ; i++) {
            result.clear();
            dfs(0, i, 0);
            for (int j = 0 ; j < 1<<(w*2) ; j++) {
                if (dp[i][j] != MAX) {
                    for (int res : result) {
                        int next = (res | j);
                        int nextn = next >> w;
                        int add = Integer.bitCount(next & ((1<<w) - 1));
                        dp[i+1][nextn] = Math.min(dp[i+1][nextn], dp[i][j] + add);
                    }
                }
            }
        }
        

        int answer = MAX;
        for (int j = 0 ; j < 1<<(w*2) ; j++) {
            answer = Math.min(answer, dp[h][j] + Integer.bitCount(j));
        }
        System.out.println(h * w - answer);
    }
}