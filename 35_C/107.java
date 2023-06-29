import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

/**
 * 35C
 *
 * @author artyom
 */
public class FireAgain implements Runnable {
    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok;

    private void solve() throws IOException {
        int n = nextInt(), m = nextInt();
        int[][] sources = readIntMatrix(nextInt(), 2);
        int max = -1, maxI = 0, maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;
                for (int[] source : sources) {
                    int dist = abs(source[0] - i) + abs(source[1] - j);
                    if (dist < min) {
                        min = dist;
                    }
                }
                if (min > max) {
                    max = min;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        out.print((maxI + 1) + " " + (maxJ + 1));
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new FireAgain().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
            tok = null;
            solve();
            in.close();
            out.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private int[][] readIntMatrix(int n, int m) throws IOException {
        int[][] mx = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mx[i][j] = nextInt() - 1;
            }
        }
        return mx;
    }
}