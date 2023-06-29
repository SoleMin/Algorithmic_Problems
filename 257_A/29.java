import java.io.*;
import java.util.*;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      new Main().run();
   }

   StreamTokenizer in;
   PrintWriter out;

   int nextInt() throws IOException
   {
      in.nextToken();
      return (int)in.nval;
   }
   long nextLong() throws IOException
   {
      in.nextToken();
      return (long)in.nval;
   }
   void run() throws IOException
   {
     // in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
     // out = new PrintWriter(new FileWriter("output.txt"));
      in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      out.flush();
   }

   void solve() throws IOException
   {
      int N=nextInt();
      int m=nextInt();
      int k=nextInt();
     //  System.out.println("k "+k);
      ArrayList<Integer> ts= new ArrayList<Integer>();
       for (int i = 0; i < N; i++) {
           ts.add(nextInt());
       }
       int count=0,pos=0;
       Collections.sort(ts);
       int jj=ts.size()-1;
      while(m>k){
         
      if((jj<0)||(k==0))
      {pos=1;break;}
      else{
        //  System.out.println(k);
      k+=ts.get(jj) -1;
      jj--;
      count++;
      }
      
      }
      if(pos==0)
           out.println(count);
      else
           out.println("-1");
      
   }
}