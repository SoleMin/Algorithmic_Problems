
import java.util.*;


public class E
{
   public static void main(String[] args)
   {
      new E(new Scanner(System.in));
   }

   int N, M;
   int[][][] memo;

   int go(int i, int j, int mask)
   {
      if (i == N)
         return go(0, j+1, mask);
      if (j == M)
      {
         int mm = mask%(1<<N);
         //System.out.println(Integer.toBinaryString(mm)+" "+Integer.toBinaryString(mask));
         if (mm != ((1<<N)-1))
            return N*M;
         return 0;
      }

      if (memo[i][j][mask] != -1)
         return memo[i][j][mask];

      // Now place a spider cluster here
      int nMask = mask;
      int prevMask = 0;
      if (i > 0)
         prevMask = 1 << (N-1);
      int nextMask = 0;
      if (i < (N-1))
         nextMask = 1 << (N+1);
      int curMask = 1 << N;
      int nextRowMask = 1 << (N+N);
      nMask = nMask|prevMask|nextMask|curMask|nextRowMask;
      nMask = nMask/2;
      int res = 1+go(i+1, j, nMask);
      
      int pr = mask%2;
      if (pr == 1)
      {
         // We have the option to skip here
         int rr = go(i+1, j, mask/2);
         if (rr < res)
            res = rr;
      }

   
      //System.out.printf("%d %d %s = %d%n", i, j, Integer.toBinaryString(mask), res);
      memo[i][j][mask] = res;
      return res;
   }

   public E(Scanner in)
   {
      int[] vals = new int[2];
      vals[0] = in.nextInt();
      vals[1] = in.nextInt();
      Arrays.sort(vals);

      N = vals[0];
      M = vals[1];
      memo = new int[N][M][1<<(N+N+1)];
      fill3(memo, -1);
      
      int r1 = go(0, 0, (1<<N)-1);
      int res = N*M-r1;
      System.out.printf("%d%n", res);
   
   }

   void fill3(int[][][] vvv, int val)
   {
      for (int[][] vv : vvv)
         for (int[] v : vv)
            Arrays.fill(v, val);
   }
}
