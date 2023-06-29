import java.io.*;
import java.util.*;
public class CF_35C {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        boolean[][] visited = new boolean[n][m];

        int k = Integer.parseInt(f.readLine());
        LinkedList<state1> ll = new LinkedList<state1>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ll.add(new state1(x - 1, y - 1));
            visited[x - 1][y - 1] = true;
        }

        int lastx = 1;
        int lasty = 1;
        while(!ll.isEmpty()) {
            state1 focus = ll.remove();
            lastx = focus.x+1;
            lasty = focus.y+1;

            //System.out.println(lastx + " " + lasty);

            visited[focus.x][focus.y] = true;
            if(focus.x+1 < n && !visited[focus.x+1][focus.y]) {
                ll.add(new state1(focus.x+1, focus.y));
                visited[focus.x+1][focus.y] = true;
            }
            if(focus.x-1 >= 0 && !visited[focus.x-1][focus.y]) {
                ll.add(new state1(focus.x-1, focus.y));
                visited[focus.x-1][focus.y] = true;
            }
            if(focus.y+1 < m && !visited[focus.x][focus.y+1]) {
                ll.add(new state1(focus.x, focus.y+1));
                visited[focus.x][focus.y+1] = true;
            }
            if(focus.y-1 >= 0 && !visited[focus.x][focus.y-1]) {
                ll.add(new state1(focus.x, focus.y-1));
                visited[focus.x][focus.y-1] = true;
            }
        }
        out.println(lastx + " " + lasty);
        out.close();
    }
}

class state1 {
    int x, y;
    state1(int x, int y) {
        this.x = x; this.y = y;
    }
}