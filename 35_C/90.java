import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author MaxHeap
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
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FireAgain solver = new FireAgain();
        solver.solve(1, in, out);
        out.close();
    }

    static class FireAgain {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int INF = 10000000;
            int[][] g = new int[n][m];
            for (int[] temp : g) Arrays.fill(temp, -1);
            ArrayDeque<IntPair> q = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                int x = in.nextInt() - 1;
                int y = in.nextInt() - 1;
                g[x][y] = 0;
                q.add(new IntPair(x, y));
            }
            while (!q.isEmpty()) {
                IntPair cur = q.poll();
                int x = cur.getFirst();
                int y = cur.getSecond();
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0 || Math.abs(i) + Math.abs(j) != 1) continue;
                        int xx = x + i;
                        int yy = y + j;
                        if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                        if (g[xx][yy] != -1) continue;
                        g[xx][yy] = g[x][y] + 1;
                        q.add(new IntPair(xx, yy));
                    }
                }
            }
            int ans = 0, x = -1, y = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] >= ans) {
                        ans = g[i][j];
                        x = i + 1;
                        y = j + 1;
                    }
                }
            }
            out.println(x + " " + y);
        }

    }

    static class IntPair implements Comparable<IntPair> {
        int first;
        int second;

        public IntPair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public int compareTo(IntPair a) {
            if (second == a.second) {
                return Integer.compare(first, a.first);
            }
            return Integer.compare(second, a.second);
        }


        public String toString() {
            return "<" + first + ", " + second + ">";
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntPair a = (IntPair) o;

            if (first != a.first) return false;
            return second == a.second;
        }


        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

