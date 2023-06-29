
import java.util.*;


public class E
{
   public static void main(String[] args)
   {
      new E(new Scanner(System.in));
   }


   public E(Scanner in)
   {
      int N = in.nextInt();
      double[][] g = new double[N][N];

      for (int j=0; j<N; j++)
         for (int i=0; i<N; i++)
            g[i][j] = in.nextDouble();

      double[] memo = new double[1<<N];
      memo[(1<<N)-1] = 1.0;
      
      for (int m=(1<<N)-1; m>0; m--)
      {
         int cnt = 0;
         for (int i=0; i<N; i++)
         {
            int m1 = 1 << i;
            if ((m1&m) > 0)
               cnt++;
         }

         int sum = (cnt*(cnt-1))/2;
         for (int i=0; i<N; i++)
         {
            int m1 = 1 << i;
            if ((m1&m) == 0) continue;

            for (int j=i+1; j<N; j++)
            {
               int m2 = 1 << j;
               if ((m2&m) == 0) continue;
               
               memo[m-m1] += (g[i][j]*memo[m])/sum;
               memo[m-m2] += (g[j][i]*memo[m])/sum;
            }
         }
      }

      StringBuilder sb = new StringBuilder();
      for (int i=0; i<N; i++)
      {
         double res = memo[1<<i];
         sb.append(String.format("%.8f", res));
         sb.append(' ');
      }
      System.out.println(sb.toString().trim());
   }
}
