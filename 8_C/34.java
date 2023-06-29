import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bag implements Runnable {
    private void solve() throws IOException {
        int xs = nextInt();
        int ys = nextInt();
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; ++i) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        final int[][] pair = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                pair[i][j] = (x[i] - xs) * (x[i] - xs) + (y[i] - ys) * (y[i] - ys) + (x[j] - xs) * (x[j] - xs) + (y[j] - ys) * (y[j] - ys) + (x[j] - x[i]) * (x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]);
        final int[] single = new int[n];
        for (int i = 0; i < n; ++i) {
            single[i] = 2 * ((x[i] - xs) * (x[i] - xs) + (y[i] - ys) * (y[i] - ys));
        }
        final int[] best = new int[1 << n];
        final int[] prev = new int[1 << n];
        for (int set = 1; set < (1 << n); ++set) {
            int i;
            for (i = 0; i < n; ++i)
                if ((set & (1 << i)) != 0)
                    break;
            int bestC = best[set ^ (1 << i)] + single[i];
            int prevC = 1 << i;
            int nextSet = set ^ (1 << i);
            int unoI = 1 << i;
            for (int j = i + 1, unoJ = 1 << (i + 1); j < n; ++j, unoJ <<= 1)
                if ((set & unoJ) != 0) {
                    int cur = best[nextSet ^ unoJ] + pair[i][j];
                    if (cur < bestC) {
                        bestC = cur;
                        prevC = unoI | unoJ;
                    }
                }
            best[set] = bestC;
            prev[set] = prevC;
        }
        writer.println(best[(1 << n) - 1]);
        int now = (1 << n) - 1;
        writer.print("0");
        while (now > 0) {
        	int differents = prev[now];
        	for(int i = 0; i < n; i++)
				if((differents & (1 << i)) != 0)
				{
					 writer.print(" ");
		             writer.print(i + 1);
		             now ^= 1 << i;
				}
            writer.print(" ");
            writer.print("0");
        }
        writer.println();
    }


    public static void main(String[] args) {
        new Bag().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}