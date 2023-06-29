
import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.*;
import static java.lang.Math.*;
@SuppressWarnings("unused")
public class round35C {
    static class state{
        int x, y, time;
        public state(int xx, int yy, int t){
            x = xx;
            y = yy;
            time = t;
        }
    }
    static int N,M;
    static int [] dx = new int [] {1,-1,0,0};
    static int [] dy = new int [] {0,0,1,-1};
    static Queue<state> bfs = new LinkedList<round35C.state>();
    public static Point runBFS(){
        boolean [][] vis = new boolean [N + 1][M + 1];
        int max = -(int)1e9;
        int bestx = -1;
        int besty = -1;
        while(!bfs.isEmpty()){
            state p = bfs.poll();
            int x = p.x;
            int y = p.y;
            int time = p.time;
            if(vis[x][y])
                continue;
            vis[x][y] = true;
            if(time > max){
                max = time;
                bestx = x + 1;
                besty = y + 1;
            }
            for(int i = 0 ; i < 4 ; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if(vis[nx][ny] == false)
                    bfs.offer(new state(nx, ny, time + 1));
            }
        }
        return new Point(bestx, besty);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
        String [] use = null;
        use = br.readLine().split(" ");
        N = parseInt(use[0]);
        M = parseInt(use[1]);
        int K = parseInt(br.readLine());
        use = br.readLine().split(" ");
        for(int i = 0 ; i < 2 * K ; i += 2){
            int f = parseInt(use[i]) - 1;
            int t = parseInt(use[i + 1]) - 1;
            bfs.offer(new state(f, t, 0));
        }
        Point ans = runBFS();
        out.println(ans.x + " " + ans.y);
        out.flush();
        out.close();
    }

}
