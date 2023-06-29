import java.util.*;
import java.io.*;
public class C
{
   static long time = System.currentTimeMillis();
   public static void main(String[] args) throws IOException
   {
      //FastReader infile = new FastReader("test.txt");
      FastReader infile = new FastReader(System.in);
      int N = infile.nextInt();
      int R = infile.nextInt();
      double[] xPos = new double[N];
      for(int x = 0; x < N; x++)
         xPos[x] = infile.nextDouble();
      double[] yPos = new double[N];
      Arrays.fill(yPos, R);
      for(int x = 1; x < N; x++)
      {
         for(int y = 0; y < x; y++)
            if(Math.abs(xPos[x]-xPos[y])<=2*R)
            {
               yPos[x] = Math.max(yPos[x], yPos[y]+Math.sqrt((2*R)*(2*R)-Math.abs(xPos[x]-xPos[y])*Math.abs(xPos[x]-xPos[y])));
            }
      }
      System.out.print(yPos[0]);
      for(int x = 1; x < N; x++)
         System.out.print(" "+yPos[x]);
      //System.out.println(System.currentTimeMillis()-time);
   }
}
class FastReader
{
   BufferedReader br;
   StringTokenizer st;

   public FastReader(String file) throws IOException
   {
      br = new BufferedReader(new FileReader(file));
   }
 
   public FastReader(InputStream i) throws IOException
   {
      br = new BufferedReader(new InputStreamReader(System.in));
   }
   boolean hasNext()
   {
      while (st == null || !st.hasMoreElements())
      {
         try
         {
            st = new StringTokenizer(br.readLine());
         }
         catch (Exception  e)
         {
            return false;
         }
      }
      return true;
   }
 
   String next()
   {
      while (st == null || !st.hasMoreElements())
      {
         try
         {
            st = new StringTokenizer(br.readLine());
         }
         catch (IOException  e)
         {
            e.printStackTrace();
         }
      }
      return st.nextToken();
   }
 
   int nextInt()
   {
      return Integer.parseInt(next());
   }
 
   long nextLong()
   {
      return Long.parseLong(next());
   }
 
   double nextDouble()
   {
      return Double.parseDouble(next());
   }
 
   String nextLine()
   {
      String str = "";
      try
      {
         str = br.readLine();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return str;
   }
}