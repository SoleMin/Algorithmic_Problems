import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class A extends PrintWriter {

    void run() {
        int n = nextInt();
        int m = 101;
        boolean[] c = new boolean[m];

        for (int i = 0; i < n; i++) {
            int v = nextInt();
            c[v] = true;
        }

        int ans = 0;

        for (int v = 1; v < m; v++) {
            if (c[v]) {
                ++ans;
                for (int u = v; u < m; u += v) {
                    c[u] = false;
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

    public A(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        OJ = System.getProperty("ONLINE_JUDGE") != null;
        A solution = new A(System.out);
        if (OJ) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            solution.run();
        } else {
            reader = new BufferedReader(new FileReader(new File(A.class.getName() + ".txt")));
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
