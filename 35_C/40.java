
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader//(new InputStreamReader(System.in));
                                            (new FileReader("input.txt"));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        PrintWriter pw = new PrintWriter("output.txt", "UTF-8");
        
        int [] dx = {-1,1,0,0},dy = {0,0,-1,1};
        
        tk = new StringTokenizer(in.readLine());
        int n = parseInt(tk.nextToken()),m = parseInt(tk.nextToken());
        int k = parseInt(in.readLine());
        
        int [][] dist = new int[n][m];
        for(int i=0; i<n; i++) 
            Arrays.fill(dist[i], -1);
        
        int ans = -1,atx = -1,aty = -1;
        
        Queue<point> q = new LinkedList<point>();
        
        tk = new StringTokenizer(in.readLine());
        while(k-- > 0) {
            int x = parseInt(tk.nextToken())-1,y = parseInt(tk.nextToken())-1;
            
            dist[x][y] = 0;
            q.add(new point(x,y));
        }
        
        while(!q.isEmpty()) {
            point p = q.remove();
            
            if(dist[p.x][p.y]>ans) {
                ans = dist[p.x][p.y];
                atx = p.x+1;
                aty = p.y+1;
            }
            
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && dist[nx][ny]==-1) {
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    q.add(new point(nx,ny));
                }
            }
        }
        
        pw.println(atx+" "+aty);
        pw.close();
    }
   
}

class point {
    int x,y;
    
    public point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}