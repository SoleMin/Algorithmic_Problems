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
300iq as writer = Sad!
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class x1080D
   {
      public static void main(String hi[]) throws Exception
      {
         long[] dp = new long[32];
         for(int i=1; i <= 31; i++)
            dp[i] = 1+4*dp[i-1];
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int T = Integer.parseInt(st.nextToken());
         StringBuilder sb = new StringBuilder();
         matcha:while(T-->0)
         {
            st = new StringTokenizer(infile.readLine());
            int N = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            if(N >= 32 || K == 1)
               sb.append("YES "+(N-1)+"\n");
            else if(dp[N] == K)
               sb.append("YES 0\n");
            else if(dp[N] < K)
               sb.append("NO\n");
            else
            {
               long total = 3L;
               long length = 2;
               for(int res=N-1; res >= 0; res--)
               {
                  long min = 1+3*dp[N-1-res];
                  long max = min+dp[N-1];
                  long cansplit = total-2*length+1;
                  max += dp[res]*cansplit;
                  if(min <= K && K <= max)
                  {
                     sb.append("YES "+res+"\n");
                     continue matcha;
                  }
                  length <<= 1;
                  total *= 4;
               }
               sb.append("NO\n");
            }
         }
         System.out.print(sb);
      }
   }