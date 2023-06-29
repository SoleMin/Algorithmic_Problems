/*
If you want to aim high, aim high
Don't let that studying and grades consume you
Just live life young
******************************
What do you think? What do you think?
1st on Billboard, what do you think of it
Next is a Grammy, what do you think of it
However you think, I’m sorry, but shit, I have no fcking interest
*******************************
I'm standing on top of my Monopoly board
That means I'm on top of my game and it don't stop
til my hip don't hop anymore
https://www.a2oj.com/Ladder16.html
*******************************
300iq as writer = Sad!
*/
import java.util.*;
import java.io.*;
import java.math.*;

   public class x35C
   {
      public static void main(String hi[]) throws Exception
      {
         BufferedReader infile = new BufferedReader(new FileReader("input.txt"));
         StringTokenizer st = new StringTokenizer(infile.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         int K = Integer.parseInt(infile.readLine());
         int[][] grid = new int[N][M];
         for(int i=0; i < N; i++)
            Arrays.fill(grid[i], -1);
         ArrayDeque<Integer> q = new ArrayDeque<Integer>();
         st = new StringTokenizer(infile.readLine());
         while(K-->0)
         {
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            grid[a][b] = 0;
            q.add(a);   q.add(b);
         }
         while(q.size() > 0)
         {
            int x = q.poll();
            int y = q.poll();
            if(x > 0 && grid[x-1][y] == -1)
            {
               grid[x-1][y] = grid[x][y]+1;
               q.add(x-1); q.add(y);
            }
            if(y > 0 && grid[x][y-1] == -1)
            {
               grid[x][y-1] = grid[x][y]+1;
               q.add(x);   q.add(y-1);
            }
            if(x+1 < N && grid[x+1][y] == -1)
            {
               grid[x+1][y] = grid[x][y]+1;
               q.add(x+1); q.add(y);
            }
            if(y+1 < M && grid[x][y+1] == -1)
            {
               grid[x][y+1] = grid[x][y]+1;
               q.add(x);   q.add(y+1);
            }
         }
         int r = 0;
         int c = 0;
         for(int i=0; i < N; i++)
            for(int j=0; j < M; j++)
               if(grid[r][c] < grid[i][j])
               {
                  r = i;
                  c = j;
               }
         r++;  c++;
         System.setOut(new PrintStream(new File("output.txt")));
         System.out.println(r+" "+c);
      }
   }