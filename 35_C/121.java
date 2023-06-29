//package C;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Fire_Again {
    static int N;
    static int M;
    static int K;
    private class Pos {
        public int r;
        public int c;
        int last;
        public Pos(int r,int c, int last) {
            this.r = r;
            this.c = c;
            this.last = last;
        }
    }
    static ArrayList<Pos> pos = new ArrayList<>();

    static boolean[][] used;// = new boolean[2001][2001];
    static int[] rows = {-1,1,0,0};
    static int[] cols = {0,0,-1,1};
    int LAST = 0;
    int lastRow = 1;
    int lastCol = 1;
    public static void main(String[] args) throws IOException {
        Fire_Again fire_again = new Fire_Again();
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("input.txt"));
        String[] nm = bufferedReader.readLine().split(" ");
        N = Integer.parseInt(nm[0]) + 1;
        M = Integer.parseInt(nm[1]) + 1;
        K = Integer.parseInt(bufferedReader.readLine());
        used = new boolean[N][M];
        String[] rc = bufferedReader.readLine().split(" ");
        for(int k = 0;k < rc.length;k+=2) {
            int r = Integer.parseInt(rc[k]);
            int c = Integer.parseInt(rc[k+1]);
            pos.add(fire_again.new Pos(r,c,0));
        }
        fire_again.bfs();
        PrintStream ps = new PrintStream("output.txt");
        ps.printf("%d %d\n",fire_again.lastRow,fire_again.lastCol);
        ps.flush();
        ps.close();
    }
     Queue<Pos> queue = new LinkedList<>();
    private void bfs() {
      queue.addAll(pos);
      for(Pos p : pos) {
          used[p.r][p.c] = true;
        //  System.out.println("r = "+(p.r) + " c = " + (p.c));
      }
      while(!queue.isEmpty()) {
          Pos p = queue.poll();
          if(p.last > LAST) {
              LAST = p.last;
              lastRow = p.r;
              lastCol = p.c;
          }
          for(int i = 0;i < rows.length;i++) {
              int currR = p.r;
              int currC = p.c;
              if(currR + rows[i] >= 1 && currR + rows[i] < N &&
              currC + cols[i] >= 1 && currC + cols[i] < M &&
              !used[currR + rows[i] ] [currC + cols[i] ] ) {
              //    System.out.println("r = "+(currR+rows[i]) + " c = " + (currC+cols[i]));
                  queue.add(new Pos(currR+rows[i],currC+cols[i],p.last+1));
                  used[currR + rows[i] ] [currC + cols[i] ] = true;
              }
          }
      }

    }

}
