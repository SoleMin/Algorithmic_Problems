import java.io.*;

public class D7182 {
    public static void main(String[] args) throws IOException {
        init_io();
        int N = nint(), M = nint(), K = nint();
        if (K % 2 == 0) {
            int[][][] grid = new int[K+1][N][M];
            int[][][] edges = new int[4][N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M-1; j++) {
                    edges[0][i][j] = edges[2][i][j+1] = nint();
                }
            }
            for (int i = 0; i < N-1; i++) {
                for (int j = 0; j < M; j++) {
                    edges[1][i][j] = edges[3][i+1][j] = nint();
                }
            }
            for (int k = 1; k <= K/2; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int min = Integer.MAX_VALUE;
                        if (i != N-1) {
                            min = Math.min(min, grid[k-1][i+1][j] + edges[1][i][j]);
                        }
                        if (j != M-1) {
                            min = Math.min(min, grid[k-1][i][j+1] + edges[0][i][j]);
                        }
                        if (i != 0) {
                            min = Math.min(min, grid[k-1][i-1][j] + edges[3][i][j]);
                        }
                        if (j != 0) {
                            min = Math.min(min, grid[k-1][i][j-1] + edges[2][i][j]);
                        }
                        grid[k][i][j] = min;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    out.print(grid[K/2][i][j]*2 + " ");
                }
                out.println();
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    out.print(-1 + " ");
                }
                out.println();
            }
        }
        out.close();
    }

    static StreamTokenizer in;
    static PrintWriter out;
    static BufferedReader br;

    static int nint() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static void init_io() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        in = new StreamTokenizer(br);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}