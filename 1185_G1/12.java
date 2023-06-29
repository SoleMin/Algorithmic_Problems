import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class G extends PrintWriter {

    void run() {
        long mod = 1_000_000_000 + 7;
        int n = nextInt();
        int m = nextInt();

        int[] t = new int[n];
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = nextInt();
            g[i] = nextInt() - 1;
        }

        int k = 1 << n;

        long[][] dp = new long[k][n];

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 1;
        }

        for (int mask = 0; mask < k; mask++) {
            if (Integer.bitCount(mask) <= 1) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((mask & (1 << j)) == 0 || g[i] == g[j]) {
                            continue;
                        }
                        dp[mask][i] = (dp[mask][i] + dp[mask ^ (1 << i)][j]) % mod;
                    }
                }
            }
        }

        long ans = 0;
        for (int mask = 0; mask < k; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += t[i];
                }
            }
            if (sum == m) {

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        ans = (ans + dp[mask][i]) % mod;
                    }
                }

            }

        }

        println(ans);

    }

    boolean skip() {
        while (hasNext()) {
            next();
        }
        return true;
    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
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

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public G(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        OJ = System.getProperty("ONLINE_JUDGE") != null;
        G solution = new G(System.out);
        if (OJ) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            solution.run();
        } else {
            reader = new BufferedReader(new FileReader(new File(G.class.getName() + ".txt")));
            long timeout = System.currentTimeMillis();
            while (solution.hasNext()) {
                solution.run();
                solution.println();
                solution.println("----------------------------------");
            }
            solution.println("time: " + (System.currentTimeMillis() - timeout));
        }
        solution.close();
        reader.close();
    }
}