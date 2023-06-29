/*
Roses are red
Memes are neat
All my test cases time out
Lmao yeet
*/
import java.util.*;
import java.io.*;

   public class B
   {
      public static void main(String args[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));  
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int K = Integer.parseInt(st.nextToken());
         //bin search
         //ugh I'm shafting
         long x = (long)N;
         long low = 0L;
         long high = N;
         while(low != high)
         {
            x = (low+high+1)/2;
            long add = (x*(x+1))/2;
            long y = N-x;
            if(add-y > K)
               high = x;
            else if(add-y == K)
            {
               System.out.println(y);
               break;
            }
            else
               low = x;
         }
         //run time?
      }
      public static void sort(int[] arr)
      {
         PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
         for(int a: arr)
            pq.add(a);
         for(int i=0; i < arr.length; i++)
            arr[i] = pq.poll();
      }
   }