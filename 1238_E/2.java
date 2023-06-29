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

   public class x1238E
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         String input = infile.readLine();
         int[][] cnt = new int[M][M];
         for(int i=0; i < N-1; i++)
         if(input.charAt(i) != input.charAt(i+1))
            {
               cnt[input.charAt(i)-'a'][input.charAt(i+1)-'a']++;
               cnt[input.charAt(i+1)-'a'][input.charAt(i)-'a']++;
            }
         int[] dp = new int[1 << M];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0;
         for(int mask=0; mask < dp.length; mask++)
            for(int b=0; b < M; b++)
               if((mask&(1<<b)) == 0)
               {
                  int submask = mask|(1<<b);
                  int cost = 0;
                  for(int c=0; c < M; c++)
                  {
                     if((mask&(1<<c)) > 0)
                        cost += cnt[b][c];
                     else
                        cost -= cnt[b][c];
                  }
                  dp[submask] = Math.min(dp[submask], dp[mask]+cost*Integer.bitCount(mask));
               }
         System.out.println(dp[(1<<M)-1]);
      }
   }