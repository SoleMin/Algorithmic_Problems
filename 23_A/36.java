
import java.util.*;


public class A
{
   public static void main(String[] args)
   {
      new A(new Scanner(System.in));
   }

   public A(Scanner in)
   {
      TreeSet<String> ts = new TreeSet<String>();
      ArrayList<String> sr = new ArrayList<String>();

      String s = in.next();
      for (int i=0; i<s.length(); i++)
      {
         for (int j=i+1; j<=s.length(); j++)
         {
            String ss = s.substring(i, j);
            if (ts.contains(ss))
            {
               sr.add(ss);
            }
            ts.add(ss);
         }
      }

      int res = 0;
      for (String ss : sr)
      {
         if (ss.length() > res)
            res = ss.length();
      }

      System.out.printf("%d%n", res);
   }
}
