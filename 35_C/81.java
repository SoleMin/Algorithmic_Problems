

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by mostafa on 10/7/17.
 */
public class FireAgain {
    static int n, m, k;
    static int inf = (int) 1e9;
    static class Pair {
        int x, y;
        Pair(int a, int b) {
            x = a; y = b;
        }
    }
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    static int[][] bfs(int[] xs, int[] ys) {
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(dist[i], inf);
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            dist[xs[i]][ys[i]] = 0;
            q.add(new Pair(xs[i], ys[i]));
        }

        while(!q.isEmpty()) {
            Pair p = q.remove();
            for(int d = 0; d < 4; d++) {
                int nx = p.x + dx[d], ny = p.y + dy[d];
                if(valid(nx, ny) && dist[nx][ny] == inf) {
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        int[] xs = new int[k], ys = new int[k];
        for(int i = 0; i < k; i++) {
            xs[i] = sc.nextInt() - 1; ys[i] = sc.nextInt() - 1;
        }

        int[][] dist = bfs(xs, ys);

        int x = 0, y = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(dist[i][j] > dist[x][y]) {
                    x = i; y = j;
                }
        x++; y++;
        PrintWriter out = new PrintWriter("output.txt");
        out.println(x + " " + y);
        out.flush();
        out.close();
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;
        Scanner() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("input.txt"));
        }

        String next() throws IOException {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
