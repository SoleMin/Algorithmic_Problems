import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        OutputStream output = System.out;
        InputReader in = new InputReader(new FileReader(new File("input.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        Solution s = new Solution();
        s.solve(1, in, out);
        out.close();
    }

    static class Solution {

        static int[][] grid;
        static int[] dx = {0, 0, 1, -1};
        static int[] dy = {1, -1, 0, 0};
        static int n, m;
        public void solve(int cs, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            int k = in.nextInt();
            grid = new int[n][m];
            for (int[] d : grid)
                Arrays.fill(d, -1);
            for (int i = 0; i < k; i++) {
                Pair tree = new Pair(in.nextInt()-1, in.nextInt()-1);
                bfs(tree);
            }
            int max = 0, idx1 = 0, idx2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        idx1 = i;
                        idx2 = j;
                    }
                }
            }
            out.printf("%d %d%n", idx1+1, idx2+1);


        }
        public boolean isValid(int i, int j) {
            return i >= 0 && i < n && j >= 0 && j < m;
        }


        static class Pair {
            int x, y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public void bfs(Pair src) {
            Queue<Pair> q = new LinkedList<>();
            grid[src.x][src.y] = 0;
            q.add(src);
            while (!q.isEmpty()) {
                Pair p = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = p.x+dx[k];
                    int ny = p.y+dy[k];
                    if (isValid(nx, ny)) {
                        if (grid[nx][ny] > grid[p.x][p.y]+1 || grid[nx][ny] == -1) {
                            grid[nx][ny] = grid[p.x][p.y] + 1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i), 32768);
            st = null;
        }
        
        public InputReader(FileReader s) {
           br = new BufferedReader(s);
           st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
