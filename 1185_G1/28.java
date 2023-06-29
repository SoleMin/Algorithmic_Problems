/*
Roses are red
Memes are neat
All my test cases time out
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class x1185G1b
   {
      static long MOD = 1000000007L;
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int T = Integer.parseInt(st.nextToken());
         Song[] arr = new Song[N];
         for(int i=0; i < N; i++)
         {
            st = new StringTokenizer(infile.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            arr[i] = new Song(a, b);
         }
         //bitmask
         long[][] dp = new long[1 << N][3];
         Arrays.fill(dp[0], 1L);
         for(int mask=0; mask < dp.length; mask++)
         {
            for(int i=0; i < N; i++)
               if((mask & (1 << i)) == 0)
               {
                  Song c = arr[i];
                  //continue all dp if mask == 0
                  if(mask == 0 && c.t <= T)
                  {
                     dp[mask|(1 << i)][c.g]++;
                     dp[mask|(1 << i)][c.g] %= MOD;
                  }
                  //continue dp if not same genre
                  else
                  {
                     for(int gen=0; gen < 3; gen++)
                        if(gen != c.g)
                        {
                           dp[mask|(1 << i)][c.g] += dp[mask][gen];
                           dp[mask|(1 << i)][c.g] %= MOD;
                        }
                        //optimize?
                  }
               }
         }
         long res = 0L;
         for(int mask=1; mask < dp.length; mask++)
            for(int i=0; i < 3; i++)
            {
               int sum = 0;
               for(int b=0; b < N; b++)
                  if((mask & (1 << b)) > 0)
                     sum += arr[b].t;
               if(sum == T)
                  res = (res+dp[mask][i])%MOD;
            }
         System.out.println(res);
      }
   }
   class Song
   {
      public int t;
      public int g;
      
      public Song(int a, int b)
      {
         t = a;
         g = b;
      }
   }
   //cheerios are good for your heart, but are they good for your brain?