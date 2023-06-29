
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FireAgain {

    int k, i, j,n,m,x,y;
    void run() {
        try {
            BufferedReader bfd = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
//          BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tk = new StringTokenizer(bfd.readLine());
            
            n = Integer.parseInt(tk.nextToken());
            m = Integer.parseInt(tk.nextToken());
            boolean vis[][] = new boolean[n][m];
            k = Integer.parseInt(bfd.readLine());
            tk = new StringTokenizer(bfd.readLine());
            Queue<Point> q = new LinkedList<Point>();
            Point last = new Point(0,0);
            while(k-->0){
                x = Integer.parseInt(tk.nextToken())-1;
                y = Integer.parseInt(tk.nextToken())-1;
                q.add(new Point(x,y));
                vis[x][y] = true;
            }
            while(!q.isEmpty()) {
                Point frnt = q.poll();
                for(i=frnt.x-1;i<=frnt.x+1;++i)
                    for(j=frnt.y-1;j<=frnt.y+1;++j)
                        if(val(i,j)&& !vis[i][j]&&(frnt.x==i||frnt.y==j)){
                            q.add(new Point(i,j));
                            last = new Point(i,j);
                            vis[i][j] = true;
                        }
            }
//          System.out.println(last.x+1 + " " +(last.y+1));
            out.write(last.x+1 + " " +(last.y+1)+"\n");
            out.flush();
            out.close();
        } catch (Exception e) {

        }
    }
    
    boolean val(int x,int y){
        return x>=0&&x<n&&y>=0&&y<m;
    }
    public static void main(String[] args) {
        new FireAgain().run();
    }

}
