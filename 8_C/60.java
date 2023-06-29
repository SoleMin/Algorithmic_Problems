import java.util.*;
public class c8 {
    static int n;
    static int[] ds;
    static int[][] g;
public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    int x = input.nextInt(), y = input.nextInt();
    n = input.nextInt();
    int[] xs = new int[n], ys = new int[n];
    for(int i = 0; i<n; i++)
    {
        xs[i] = input.nextInt();
        ys[i] = input.nextInt();
    }
    ds = new int[n];
    g = new int[n][n];
    for(int i = 0; i<n; i++)
    {
        ds[i] = (x - xs[i])  *  (x - xs[i]) + (y - ys[i]) * (y - ys[i]);
        for(int j = 0; j<n; j++)
        {
            g[i][j] = (xs[i] - xs[j]) * (xs[i] - xs[j]) + (ys[i] - ys[j]) * (ys[i] - ys[j]);
        }
    }
    int[] dp = new int[1<<n];
    Arrays.fill(dp, 987654321);
    dp[0] = 0;
    for(int i = 0; i<(1<<n); i++)
    {
        if(dp[i] == 987654321) continue;
        for(int a = 0; a<n; a++)
        {
            if((i & (1<<a)) > 0) continue;
            dp[i | (1<<a)] = Math.min(dp[i | (1<<a)], dp[i] + 2*ds[a]);
            for(int b = a+1; b<n; b++)
            {
                if((i & (1<<b)) > 0) continue;
                dp[i | (1<<a) | (1<<b)] = Math.min(dp[i | (1<<a) | (1<<b)], dp[i] + ds[a] + ds[b] + g[a][b]);
            }
            break;
        }
    }
    Stack<Integer> stk = new Stack<Integer>();
    stk.add(0);
    int i = (1<<n) - 1;
    //System.out.println(Arrays.toString(dp));

    trace:
    while(i > 0)
    {
        //System.out.println(i);
        for(int a = 0; a<n; a++)
        {
            if((i & (1<<a)) == 0) continue;
            if( dp[i] == dp[i - (1<<a)] + 2*ds[a])
            {
                stk.add(a+1);
                stk.add(0);
                i -= (1<<a);
                continue trace;
            }
            for(int b = a+1; b<n; b++)
            {
                if((i & (1<<b)) == 0) continue;
                if(dp[i] == dp[i - (1<<a) - (1<<b)] + ds[a] + ds[b] + g[a][b])
                {
                    stk.add(a+1);
                    stk.add(b+1);
                    stk.add(0);
                    i -= (1<<a) + (1<<b);
                    continue trace;
                }
            }
            //break;
        }
    }
    System.out.println(dp[(1<<n) - 1]);
    while(!stk.isEmpty()) System.out.print(stk.pop()+" ");
}
}
