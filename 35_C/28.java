
import java.util.*;
import java.io.*;


public class C
{
   public static void main(String[] args) throws Exception
   {
      new C(new Scanner(new File("input.txt")), new PrintWriter("output.txt"));
   }

   int oo = 987654321;
   int W, H;

   public C(Scanner in, PrintWriter out)
   {
      W = in.nextInt();
      H = in.nextInt();

      int[][] grid = new int[W][H];
      for (int[] gri : grid)
         Arrays.fill(gri, oo);
   
      ArrayDeque<Node> q = new ArrayDeque<Node>();
      int K = in.nextInt();
      for (int u=0; u<K; u++)
      {
         q.add(new Node(in.nextInt()-1, in.nextInt()-1, 0));
         while (q.size() > 0)
         {
            Node cur = q.poll();
            if (grid[cur.x][cur.y] <= cur.d)
               continue;
            grid[cur.x][cur.y] = cur.d;
            if (cur.x+1<W)
               q.add(new Node(cur.x+1, cur.y, cur.d+1));
            if (cur.x>0)
               q.add(new Node(cur.x-1, cur.y, cur.d+1));
            if (cur.y+1<H)
               q.add(new Node(cur.x, cur.y+1, cur.d+1));
            if (cur.y>0)
               q.add(new Node(cur.x, cur.y-1, cur.d+1));
         }
      }

      int res = 0;
      for (int j=0; j<H; j++)
         for (int i=0; i<W; i++)
            res = Math.max(res, grid[i][j]);

      for (int j=0; j<H; j++)
         for (int i=0; i<W; i++)
            if (res == grid[i][j])
            {
               out.printf("%d %d%n", i+1, j+1);
               out.close();
               return;
            }
   }
}

class Node
{
   int x, y, d;

   public Node(int xx, int yy, int dd)
   {
      x=xx; y=yy; d=dd;
   }
}
