import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeForces {
    public static void main(String[] args) throws FileNotFoundException {
        FastIO io = new FastIO();

        int width = io.nextInt();
        int height = io.nextInt();

        int initials = io.nextInt();

        boolean[][] visited = new boolean[width][height];

        Queue<Coordinate> q = new ArrayDeque<>();

        for (int i = 0; i < initials; i++) {
            q.add(new Coordinate(io.nextInt() - 1, io.nextInt() - 1));
        }

        Coordinate oneOfLast = null;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int times = 0; times < len; times++) {
                Coordinate c = q.poll();
                if (visited[c.x][c.y]) {
                    continue;
                }

                oneOfLast = c;
                visited[c.x][c.y] = true;

                int[][] deltas = new int[][]{
                        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
                };

                for (int[] delta : deltas) {
                    int ci = c.y + delta[0];
                    int cj = c.x + delta[1];

                    if (ci >= 0 && cj >= 0 && ci < height && cj < width) {
                        q.add(new Coordinate(cj, ci));
                    }
                }
            }
        }

        io.println((oneOfLast.x + 1) + " " + (oneOfLast.y + 1));

        io.close();
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastIO extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        public FastIO() throws FileNotFoundException {
            super(new BufferedOutputStream(new FileOutputStream("output.txt")));
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}