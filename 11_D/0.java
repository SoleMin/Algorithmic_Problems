/*
stream Butter!
eggyHide eggyVengeance
I need U
xiao rerun when
 */
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class x11D
{
    public static void main(String hi[]) throws Exception
    {
        int[] log = new int[1<<20];
        for(int i=0; i < 19; i++)
            log[1<<i] = i;
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] edges = new boolean[N][N];
        for(int i=0; i < M; i++)
        {
            st = new StringTokenizer(infile.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            edges[a][b] = edges[b][a] = true;
        }
        long[][] dp = new long[1<<N][N];
        for(int a=0; a < N; a++)
            for(int b=a+1; b < N; b++)
                if(edges[a][b])
                    dp[(1<<a)|(1<<b)][b] = 1L;
        long res = 0L;
        for(int mask=1; mask < 1<<N; mask++)
        {
            int small = log[mask&-mask];
            for(int a=small+1; a < N; a++)
                if((mask&(1<<a)) > 0)
                {
                    for(int b=small+1; b < N; b++)
                        if(a != b && (mask&(1<<b)) > 0 && edges[a][b])
                            dp[mask][a] += dp[mask^(1<<a)][b];
                    if(edges[small][a])
                    {
                        //System.out.println(mask+" "+a+" "+dp[mask][a]);
                        res += dp[mask][a];
                    }
                }
        }
        System.out.println((res-M)/2);
    }
}