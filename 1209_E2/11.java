//stan hu tao
//join nct ridin by first year culture reps
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class x1209E
{
    public static void main(String hi[]) throws Exception
    {
        BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(infile.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(T-->0)
        {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] grid = new int[N][M];
            for(int r=0; r < N; r++)
                grid[r] = readArr(M, infile, st);
            ArrayList<Integer> ls = new ArrayList<Integer>();
            for(int i=0; i < M; i++)
                ls.add(i);
            Collections.sort(ls, (x,y) -> {
                int m1 = grid[0][x];
                int m2 = grid[0][y];
                for(int r=1; r < N; r++)
                {
                    m1 = max(m1, grid[r][x]);
                    m2 = max(m2, grid[r][y]);
                }
                return m2-m1;
            });
            int[][] newgrid = new int[N][M];
            for(int r=0; r < N; r++)
                for(int c=0; c < M; c++)
                    newgrid[r][c] = grid[r][ls.get(c)];
            M = min(M, N);
            int[][] sums = new int[M][1<<N];
            for(int i=1; i < M; i++)
                for(int mask=0; mask < 1<<N; mask++)
                {
                    //try all shifts
                    for(int head=0; head < N; head++)
                    {
                        int temp = 0;
                        for(int b=0; b < N; b++)
                        {
                            int nb = b+head;
                            if(nb >= N)
                                nb -= N;
                            if((mask&(1<<nb)) > 0)
                                temp += newgrid[b][i];
                        }
                        sums[i][mask] = max(sums[i][mask], temp);
                    }
                }
            int[][] dp = new int[M][1<<N];
            for(int mask=0; mask < 1<<N; mask++)
                for(int b=0; b < N; b++)
                    if((mask&(1<<b)) > 0)
                        dp[0][mask] += newgrid[b][0];
            for(int i=1; i < M; i++)
                for(int mask=0; mask < 1<<N; mask++)
                    for(int pmask=mask; pmask >= 0; pmask=(pmask-1)&mask)
                    {
                        dp[i][mask] = max(dp[i][mask], dp[i-1][pmask]+sums[i][mask-pmask]);
                        if(pmask == 0)
                            break;
                    }
            sb.append(dp[M-1][(1<<N)-1]+"\n");
        }
        System.out.print(sb);
    }
    public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception
    {
        int[] arr = new int[N];
        st = new StringTokenizer(infile.readLine());
        for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}