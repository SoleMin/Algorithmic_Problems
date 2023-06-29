/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
What do you think? What do you think?
1st on Billboard, what do you think of it
Next is a Grammy, what do you think of it
However you think, I’m sorry, but shit, I have no fcking interest
*******************************
I'm standing on top of my Monopoly board
That means I'm on top of my game and it don't stop
til my hip don't hop anymore
https://www.a2oj.com/Ladder16.html
*******************************
300IQ as writer = Sad!
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class F
   {
      public static void main(String hi[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         int[][] grid = new int[N][M];
         for(int i=0; i < N; i++)
            grid[i] = readArr(M, infile, st);
         int[][] mindiff = new int[N][N];
         for(int a=0; a < N; a++)
            for(int b=a+1; b < N; b++)
            {
               int val = Integer.MAX_VALUE;
               for(int i=0; i < M; i++)
                  val = Math.min(val, Math.abs(grid[a][i]-grid[b][i]));
               mindiff[a][b] = mindiff[b][a] = val;
            }
         int res = 0;
         for(int start=0; start < N; start++)
         {
            int[][] dp = new int[1<<N][N];
            Arrays.fill(dp[0], Integer.MAX_VALUE);
            for(int mask=0; mask < (1<<N); mask++)
            {
               if(Integer.bitCount(mask) == 1 && mask != (1<<start))
                  continue;
               for(int prev=0; prev < N; prev++)
                  if((mask&(1<<prev)) > 0 || mask == 0)
                  {
                     for(int b=0; b < N; b++)
                        if((mask&(1<<b)) == 0)
                        {
                           int submask = mask|(1<<b);
                           if(mask == 0)
                              dp[submask][b] = Integer.MAX_VALUE;
                           else
                              dp[submask][b] = Math.max(dp[submask][b], Math.min(dp[mask][prev], mindiff[prev][b]));
                        }
                  }
            }
            for(int b=0; b < N; b++)
            {
               int temp = dp[(1<<N)-1][b];
               for(int i=0; i < M-1; i++)
                  temp = Math.min(temp, Math.abs(grid[b][i]-grid[start][i+1]));
               res = Math.max(res, temp);
            }
         }
         System.out.println(res);
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