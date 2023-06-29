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

   public class x1141F
   {
      public static void main(String omkar[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int[] arr = new int[N];
         st = new StringTokenizer(infile.readLine());
         for(int i=0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
         //thonky wonky
         HashMap<Long, ArrayList<Range>> map = new HashMap<Long, ArrayList<Range>>();
         for(int r=0; r < N; r++)
         {
            long sum = 0L;
            for(int i=r; i >= 0; i--)
            {
               sum += arr[i];
               if(!map.containsKey(sum))
                  map.put(sum, new ArrayList<Range>());
               map.get(sum).add(new Range(i, r));
            }
         }
         ArrayList<Range> res = new ArrayList<Range>();
         for(long key: map.keySet())
         {
            ArrayList<Range> ls = map.get(key);
            ArrayList<Range> temp = new ArrayList<Range>();
            temp.add(ls.get(0));
            int r = ls.get(0).r;
            for(int i=1; i < ls.size(); i++)
               if(r < ls.get(i).l)
               {
                  r = ls.get(i).r;
                  temp.add(ls.get(i));
               }
            if(res.size() < temp.size())
               res = temp;
         }
         System.out.println(res.size());
         StringBuilder sb = new StringBuilder();
         for(Range x: res)
         {
            sb.append(x.l+" "+x.r);
            sb.append("\n");
         }
         System.out.print(sb);
      }
   }
   class Range
   {
      public int l;
      public int r;
      
      public Range(int a, int b)
      {
         l = a+1;
         r = b+1;
      }
   }