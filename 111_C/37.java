/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
If I'm the sun, you're the moon
Because when I go up, you go down
*******************************
I'm working for the day I will surpass you
https://www.a2oj.com/Ladder16.html
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class x111C
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int R = Integer.parseInt(st.nextToken());
         int C = Integer.parseInt(st.nextToken());
         if(R > C)
         {
            int t = R;
            R = C;
            C = t;
         }
         //dp[c][m1][m2] = min spoders in first c columns
         int[][][] dp = new int[C+1][1 << R][1 << R];
         for(int i=0; i <= C; i++)
            for(int mask=0; mask < (1<<R); mask++)
               Arrays.fill(dp[i][mask], 69);
         for(int mask=0; mask < (1<<R); mask++)
            dp[0][0][mask] = 0;
         for(int c=1; c <= C; c++)
            for(int mask1=0; mask1 < (1<<R); mask1++)
               for(int mask2=0; mask2 < (1<<R); mask2++)
                  for(int mask3=0; mask3 < (1<<R); mask3++)
                  {
                     boolean works = true;
                     for(int b=0; b < R; b++)
                        if((mask2&(1<<b)) == 0)
                        {
                           if(b > 0 && (mask2&(1<<(b-1))) > 0);
                           else if(b+1 < R && (mask2&(1<<(b+1))) > 0);
                           else if((mask1&(1<<b)) > 0);
                           else if((mask3&(1<<b)) > 0);
                           else  works = false;
                        }
                     if(works)
                        dp[c][mask2][mask3] = Math.min(dp[c][mask2][mask3], dp[c-1][mask1][mask2]+Integer.bitCount(mask1));
                  }
         int res = 0;
         for(int mask=0; mask < (1<<R); mask++)
            res = Math.max(res, R*C-(dp[C][mask][0]+Integer.bitCount(mask)));
         System.out.println(res);
      }
   }