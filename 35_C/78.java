import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    
    static int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    static boolean correct(int x, int y, int n, int m) {
        return (x >= 0 && x < n && y >= 0 && y < m); 
    }
    
    static void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[][] order = new int[n][m];
        boolean[][] used = new boolean[n][m];
        Queue<Integer[]> q = new LinkedList<>();
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < k; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            order[x][y] = 1;
            used[x][y] = true;
            q.add(new Integer[] {x, y});
            set.add(x + "" + y);
        }
        while(!q.isEmpty()) {
            Integer[] v = q.remove();
            for(int[] move : moves) {
                int x = v[0] + move[0];
                int y = v[1] + move[1];
//              if(set.contains(x + "" + y)) {
//                  continue;
//              }
                if(correct(x, y, n, m) && !used[x][y]) {
                    q.add(new Integer[] {x, y});
                    used[x][y] = true;
                    order[x][y] = order[v[0]][v[1]] + 1; 
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(order[i][j] > max) {
                    max = order[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        maxI++;
        maxJ++;
        out.println(maxI + " " + maxJ);
    }
    
 
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public static void main(String[] args) {
        try {
            InputStream input = System.in;
            OutputStream output = System.out;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
            out = new PrintWriter(new PrintStream(new File("output.txt")));
            solve();
            out.close();
            br.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}