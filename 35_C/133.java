import java.io.*;
import java.util.*;

/**
 * Created by tmdautov on 07.02.18.
 */
public class ArFireAgain {


    int n, m, k;
    int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
    int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

    int[][] dist;
    ArrayList<Pair> arr;
    // res -> get coordinates of most remote tree

    Scanner sc;
    PrintWriter out;

    public void solve() {

        try {
            sc = new Scanner(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new ArrayList<Pair>();

        for (int i=0; i<k; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            Pair p = new Pair(x, y);
            arr.add(p);
        }


        //out.println("helll");
        Pair last = bfs();
        out.println(last.x + " " + last.y);
        out.flush();
        out.close();
    }


    boolean inBoard(int x, int y) {
        return x >= n || x < 0 || y >= m || y < 0;
    }
    boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private Pair bfs() {
        // 1. create objects
        Queue<Pair> q = new LinkedList<Pair>();
        dist = new int[n][m];

        // 2. fill dist array with -1
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }

        // 3. fill queue with fired k-trees
        for (int i=0; i<k; i++) {
            dist[arr.get(i).x][arr.get(i).y] = 0; // dist to fired trees is 0
            q.add(arr.get(i));
        }

        // 4. run bfs
        while(!q.isEmpty()) {
            Pair cur = q.remove();

            for (int d=0; d<4; d++) {
                int X = cur.x + dx[d];
                int Y = cur.y + dy[d];

                if (isValid(X, Y) && dist[X][Y] == -1) {
                    dist[X][Y] = dist[cur.x][cur.y] + 1;
                    Pair p = new Pair(X, Y);
                    q.add(p);
                }
            }

            //System.out.println(cur);
        }

        // 5. find max pair by dist array
        Pair res = null;
        int maxx = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dist[i][j] > maxx) {
                    maxx = dist[i][j];
                    res = new Pair(i+1, j+1);
                }
            }
        }

        return res;
    }


    // how to sort array of pairs?
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new ArFireAgain().solve();
    }
}
