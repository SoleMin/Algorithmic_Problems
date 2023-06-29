import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Collection;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Queue;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("input.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        Queue<Point> points = new LinkedList<Point>();
        int[][] burnTime = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            visited[x][y] = true;
            burnTime[x][y] = 0;
            points.add(new Point(x, y));

        }
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        while (points.size() != 0) {
            Point cur = points.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < dx.length; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && (burnTime[x][y] + 1 < burnTime[nextX][nextY] || !visited[nextX][nextY])) {
                    points.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    burnTime[nextX][nextY] = burnTime[x][y] + 1;
                }
            }
        }
        int x, y;
        x = y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (burnTime[i][j] > burnTime[x][y]) {
                    x = i;
                    y = j;
                }
            }
        }
        out.printf("%d %d", x + 1, y + 1);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}
