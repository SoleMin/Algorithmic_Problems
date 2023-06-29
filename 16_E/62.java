import java.io.*;
import static java.lang.Math.*;
import java.util.*;
import java.util.function.*;
import java.lang.*;

public class Main {
    final static boolean debug = false;
    final static String fileName = "";
    final static boolean useFiles = false;

    public static void main(String[] args) throws FileNotFoundException {
        long start;
        if (debug)
            start = System.nanoTime();
        InputStream inputStream;
        OutputStream outputStream;
        if (useFiles) {
            inputStream = new FileInputStream(fileName + ".in");
            outputStream = new FileOutputStream(fileName + ".out");
        } else {
            inputStream = System.in;
            outputStream = System.out;
        }
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task(in, out);
        solver.solve();
        if(debug)
            out.println((System.nanoTime() - start) / 1e+9);
        out.close();
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public byte nextByte() {
        return Byte.parseByte(next());
    }

    byte[][] nextBitMatrix(int n, int m) {
        byte[][] a = new byte[n][m];
        for (int i = 0; i < n; i++) {
            String s = next();
            for (int j = 0; j < m; j++) {
                a[i][j] = (byte) (s.charAt(j) - '0');
            }
        }
        return a;
    }

    char[][] nextCharMatrix(int n, int m) {
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        return a;
    }

    long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }
}

class Task {
    boolean get(int mask, int i){
        return (mask & (1 << i)) > 0;
    }

    int zero(int mask, int i){
        return mask & (~(1 << i));
    }

    public void solve() {
        int n = in.nextInt();
        double[][] a = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = in.nextDouble();
        }
        double[] d = new double[1 << n];
        d[(1 << n) - 1] = 1;
        for (int mask = (1 << n) - 1; mask >= 0; mask--) {
            int bits = Integer.bitCount(mask);
            double transfer = 1.0 / (bits * (bits - 1) / 2);
            for (int i = 0; i < n; i++) {
                if (get(mask, i)) {
                    for (int j = i + 1; j < n; j++) {
                        if (get(mask, j)) {
                            d[zero(mask, j)] += a[i][j] * transfer * d[mask];
                            d[zero(mask, i)] += a[j][i] * transfer * d[mask];
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)
            out.print(d[1 << i] + " ");
    }

    private InputReader in;
    private PrintWriter out;

    Task(InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}
