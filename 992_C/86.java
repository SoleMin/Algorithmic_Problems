import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class C extends PrintWriter {

    final long mod = 1_000_000_007;

    long pow(long n, long p) {
        long r = 1;

        while (p > 0) {
            if (p % 2 == 1) {
                r = (r * n) % mod;
            }
            n = (n * n) % mod;
            p /= 2;
        }

        return r;
    }

    long solve(long n, long k) {

        if (k == 0) {
            return (2 * n) % mod;
        }

        if (n == 0) {
            return 0;
        }

        long m = pow(2, k);

        long a = 2;

        a = (a * n) % mod;
        a = (a * m) % mod;

        long b = (m + mod - 1) % mod;

        return ((a - b + mod) % mod);
    }

    void run() {
        long n = nextLong();
        long k = nextLong();

        println(solve(n, k));
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