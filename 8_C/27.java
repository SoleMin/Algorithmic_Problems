
import java.util.*;


public class C
{
   public static void main(String[] args)
   {
      new C(new Scanner(System.in));
   }

   vect[] vs;
   int N;
   int oo = 987654321;

   ArrayList<choice> cs;
   choice[][] cg;

   int MF;

   int[] memo;
   int[] next;

   int go(int m)
   {
      if (m == MF)
         return 0;
      if (memo[m] != -1)
         return memo[m];

      // Try a new place
      int res = oo;
      int nxt = -1;

      int i=0;
      for (i=0; i<N; i++)
      {
         if (((1<<i)&m) == 0)
            break;
      }

      for (int j=0; j<N; j++)
      {
         choice cc = cg[i][j];
         if ((m&cc.m) > 0)
            continue;

         int r2 = cc.cost+go(m|cc.m);
         if (r2 < res)
         {
            res = r2;
            nxt = cc.index;
         }
      }

      memo[m] = res;
      next[m] = nxt;
      return res;
   }

   public C(Scanner in)
   {
      vect vt = new vect(in.nextInt(), in.nextInt());
      N = in.nextInt();
      vs = new vect[N+1];
      vs[N] = vt;
      for (int i=0; i<N; i++)
         vs[i] = new vect(in.nextInt(), in.nextInt());
  
      // Precompute all choices and masks
      cs = new ArrayList<choice>();
      cg = new choice[N][N];
      for (int i=0; i<N; i++)
      {
         choice cc = new choice(cs.size(), 2*vs[i].dist(vt), 1<<i);
         cc.add(i);
         cs.add(cc);
         cg[i][i] = cc;
      }

      for (int i=0; i<N; i++)
      {
         for (int j=i+1; j<N; j++)
         {
            int dist = vs[i].dist(vt);
            dist += vs[i].dist(vs[j]);
            dist += vs[j].dist(vt);
            choice cc = new choice(cs.size(), dist, (1<<i)|(1<<j));
            cc.add(i); cc.add(j);
            cs.add(cc);
            cg[i][j] = cc;
            cg[j][i] = cc;
         }
      }

      MF = (1<<N)-1;
      next = new int[MF+1];
      memo = new int[MF+1];

      Arrays.fill(next, -1);
      Arrays.fill(memo, -1);

      int res = go(0);
      System.out.println(res);

      int m = 0;
      StringBuilder sb = new StringBuilder();
      while (m != -1)
      {
         //System.out.println(Integer.toBinaryString(m));
         sb.append(0);
         sb.append(' ');
         int i = next[m];
         if (i == -1)
            break;
         choice cc = cs.get(i);
         for (int j : cc.iv)
         {
            sb.append(f(j));
            sb.append(' ');
         }
         m = m|cc.m;
      }
      System.out.println(sb.toString().trim());
   }

   int f(int i)
   {
      if (i == N)
         return 0;
      return i+1;
   }
}


class choice
{
   int cost;
   int m;
   int index;
   ArrayList<Integer> iv;

   public choice(int ii, int c, int mm)
   {
      index = ii;
      cost = c;
      m = mm;
      iv = new ArrayList<Integer>(2);
   }

   void add(int i)
   {
      iv.add(i);
   }
}


class vect
{
   int x, y;

   public vect(int i, int j)
   {
      x=i; y=j;
   }

   int dist(vect rhs)
   {
      int xx = x-rhs.x;
      int yy = y-rhs.y;
      return xx*xx+yy*yy;
   }
}

