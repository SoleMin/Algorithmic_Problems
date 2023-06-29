import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class C extends PrintWriter {

    void run() {

        int n = nextInt();
        int r = nextInt();
        int[] x = nextArray(n);

        double[] y = new double[n];
        Arrays.fill(y, r);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int dx = abs(x[i] - x[j]);
                int sdy = 4 * r * r - dx * dx;

                if (sdy >= 0) {
                    double dy = sqrt(sdy);
                    y[i] = max(y[i], y[j] + dy);
                }
            }
        }

        for (double v : y) {
            printf(Locale.ENGLISH, "%.10f ", v);
        }

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

    public C(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        OJ = System.getProperty("ONLINE_JUDGE") != null;
        C solution = new C(System.out);
        if (OJ) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            solution.run();
        } else {
            reader = new BufferedReader(new FileReader(new File(C.class.getName() + ".txt")));
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