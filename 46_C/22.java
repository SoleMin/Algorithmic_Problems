import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C implements Runnable {

    private static final boolean USE_FILE_IO = false;
    private static final String FILE_IN = "c.in";
    private static final String FILE_OUT = "c.out";

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new C()).start();
    }

    int n, h, t;
    char[] c;

    private void solve() throws IOException {
        n = nextInt();
        c = nextToken().toCharArray();
        if (c.length != n) {
            throw new IllegalStateException();
        }

        for (char l : c)
            if (l == 'H') {
                h++;
            }
        t = n - h;

        if (h == 0) {
            out.print(0);
            return;
        }

        int answer = Integer.MAX_VALUE;
        for (int hLo = 0; hLo < n; hLo++)
            if (c[hLo] == 'H') {
                int hHi = (hLo + h) % n;

                int current = 0;
                int j = hLo;
                while (j != hHi) {
                    if (c[j] == 'T') {
                        current++;
                    }
                    j = (j + 1) % n;
                }

                answer = Math.min(answer, current);
            }

        out.print(answer);
    }

    public void run() {
        long timeStart = System.currentTimeMillis();
        try {

            if (USE_FILE_IO) {
                in = new BufferedReader(new FileReader(FILE_IN));
                out = new PrintWriter(new FileWriter(FILE_OUT));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }

            solve();

            in.close();
            out.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeEnd - timeStart) + " ms");
    }

    private String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private BigInteger nextBigInt() throws IOException {
        return new BigInteger(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

}