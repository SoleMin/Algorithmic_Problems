import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nasko
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

    static class TaskC {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] dist = new int[N][M];
            for (int[] ini : dist) Arrays.fill(ini, (1 << 30));


            int K = in.nextInt();
            Queue<Integer> q = new LinkedList<Integer>();
            for (int k = 0; k < K; ++k) {
                int r = in.nextInt() - 1;
                int c = in.nextInt() - 1;
                dist[r][c] = 0;
                q.offer(r);
                q.offer(c);
            }

            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            while (!q.isEmpty()) {
                int rr = q.poll();
                int cc = q.poll();
                for (int a = 0; a < 4; ++a) {
                    int x = dx[a] + rr;
                    int y = dy[a] + cc;
                    if (x >= 0 && x < N && y >= 0 && y < M) {
                        if (dist[x][y] > dist[rr][cc] + 1) {
                            dist[x][y] = dist[rr][cc] + 1;
                            q.offer(x);
                            q.offer(y);
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < M; ++j)
                    max = Math.max(max, dist[i][j]);
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (max == dist[i][j]) {
                        out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }

    }

    static class InputReader {
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
}

