
import java.util.*;


public class A
{
   public static void main(String[] args)
   {
      new A(new Scanner(System.in));
   }

   public A(Scanner in)
   {
      int n = in.nextInt();
      int t = in.nextInt();
      int tt = 2*t;

      rect[] rs = new rect[n];
      for (int i=0; i<n; i++)
         rs[i] = new rect(in.nextInt(), in.nextInt());
      
      Arrays.sort(rs);

      int res = 2;
      for (int i=1; i<n; i++)
      {
         rect a = rs[i-1];
         rect b = rs[i];
         int d = b.p-a.p;
         int dd = a.t+b.t;
         int tv = 2*d-dd;
         if (tt == tv)
            res++;
         if (tv > tt)
            res+=2;
      }
      System.out.printf("%d%n", res);
   }
}

class rect implements Comparable<rect>
{
   int p;
   int t;

   public rect(int pp, int tt)
   {
      p = pp;
      t = tt;
   }

   public int compareTo(rect rhs)
   {
      return p-rhs.p;
   }
}
