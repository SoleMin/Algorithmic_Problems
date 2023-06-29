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

   public class x1242C2
   {
      public static void main(String hi[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         long[] sums = new long[N];
         ArrayList<Integer>[] boxes = new ArrayList[N];
         for(int i=0; i < N; i++)
         {
            boxes[i] = new ArrayList<Integer>();
            st = new StringTokenizer(infile.readLine());
            int a = Integer.parseInt(st.nextToken());
            while(a-->0)
               boxes[i].add(Integer.parseInt(st.nextToken()));
            for(int x: boxes[i])
               sums[i] += x;
         }
         long lmaosum = 0L;
         for(long x: sums)
            lmaosum += x;
         if(Math.abs(lmaosum)%N != 0)
         {
            System.out.println("No");
            return;
         }
         long target = lmaosum/N;
         //fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck fuck
         HashMap<Long, Integer> map = new HashMap<Long, Integer>();
         for(int k=0; k < N; k++)
            for(int x: boxes[k])
               map.put((long)x, k);
         HashMap<Long, Long> edges = new HashMap<Long, Long>();
         for(int k=0; k < N; k++)
            for(int x: boxes[k])
            {
               long nextval = target-sums[k]+x;
               if(map.containsKey(nextval))
                  edges.put((long)x, nextval);
            }
         Node[] dp = new Node[1<<N];
         dp[0] = new Node(-69, -69, 0);
         //precompute subsets ass
         Node[] subsets = new Node[1<<N];
         for(int b=0; b < N; b++)
            for(int i=0; i < boxes[b].size(); i++)
            {
               if(!edges.containsKey((long)boxes[b].get(i)))
                  continue;
               long curr = edges.get((long)boxes[b].get(i));
               //shit shit shit shit shit shit shit shit shit shit
               int submask = 0;  boolean cyclic = true;
               while(curr != boxes[b].get(i))
               {
                  int k = map.get(curr);
                  if((submask&(1<<k)) > 0 || !edges.containsKey((long)curr))
                  {
                     cyclic = false;
                     break;
                  }
                  submask |= 1<<k;
                  curr = edges.get((long)curr);
               }
               submask |= (1<<b);
               if(cyclic)
                  subsets[submask] = new Node(-69, i, b);
            }
         for(int mask=1; mask < (1<<N); mask++)
            outer:for(int submask=mask; submask > 0; submask=(submask-1)&mask)
               if(dp[mask^submask] != null && subsets[submask] != null)
               {
                  dp[mask] = new Node(mask^submask, subsets[submask].dex, subsets[submask].start);
                  break outer;
               }
         if(dp[(1<<N)-1] == null)
            System.out.println("No");
         else
         {
            StringBuilder sb = new StringBuilder("Yes\n");
            long[][] res = new long[N][2];
            for(int i=0; i < N; i++)
               res[i][1] = -1L;
            int currmask = (1<<N)-1;
            while(currmask != 0)
            {
               int submask = dp[currmask].mask;
               int i = dp[currmask].dex;
               int b = dp[currmask].start;
               long nextval = target-sums[b]+boxes[b].get(i);
               int curr = map.get(nextval);
               res[map.get(nextval)][0] = nextval;
               res[map.get(nextval)][1] = b;
               while(true) //lol
               {
                  int lol = map.get(nextval);
                  nextval = edges.get(nextval);
                  res[map.get(nextval)][0] = nextval;
                  if(res[map.get(nextval)][1] != -1)
                     break;
                  res[map.get(nextval)][1] = lol;
               }
               currmask = dp[currmask].mask;
            }
            for(int k=0; k < N; k++)
               sb.append(res[k][0]+" ").append(res[k][1]+1).append("\n");
            System.out.print(sb);
         }
      }
   }
   class Node
   {
      public int mask;
      public int dex;
      public int start;
      
      public Node(int a, int b, int c)
      {
         mask = a;
         dex = b;
         start = c;
      }
   }