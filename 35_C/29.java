import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
public class Solution{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Pair> q ;
    static boolean[][] visited ;
    static Pair result = new Pair(0,0);
    static int n,m,k;
    public static void main(String[] args){
        try(BufferedReader in = new BufferedReader(new FileReader("input.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter("output.txt")))
        {
            StringTokenizer s = new StringTokenizer(in.readLine());
            n = Integer.parseInt(s.nextToken());
            m = Integer.parseInt(s.nextToken());
            k = Integer.parseInt(in.readLine());
            visited = new boolean[n][m];
            q = new LinkedList <>();
            s = new StringTokenizer(in.readLine());
            for(int i=0;i<k;i++){
                int x = Integer.parseInt(s.nextToken());
                int y = Integer.parseInt(s.nextToken());
                q.add(new Pair(--x,--y));
            }
            bfs();
            String ans = "" + (result.x+1) +" "+ (result.y+1);
            out.write(ans);
        }catch(IOException e){

        }
    }
    static void bfs(){
        while(!q.isEmpty()){
            Pair temp = q.poll();
            if(visited[temp.x][temp.y]) continue;
            visited[temp.x][temp.y] = true;
            result.x = temp.x;
            result.y= temp.y;
            for(int i=0;i<4;i++){
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                if(x>=0 && x<n && y>=0 && y<m && !visited[x][y])
                    q.add(new Pair(x,y));
            }
            
        }
    }
    
}
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}