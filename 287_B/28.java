import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B implements Runnable {

    // leave empty to read from stdin/stdout
    private static final String TASK_NAME_FOR_IO = "";

    // file names
    private static final String FILE_IN = TASK_NAME_FOR_IO + ".in";
    private static final String FILE_OUT = TASK_NAME_FOR_IO + ".out";

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new B()).start();
    }

    private void solve() throws IOException {
        long n = nextLong();
        long k = nextLong();

        n--;
        k--;
        long answer = 0;
        while (n > 0 && k >= 1) {

            if (k > 2000) {
                long step1000 = (k + (k - 999)) * 500;
                if (n - step1000 >= 0) {
                    n -= step1000;
                    answer += 1000;
                    k -= 1000;
                    continue;
                }
            }

            if (n - k >= 0) {
                n -= k;
                answer++;
            }

            k--;
            k = Math.min(n, k);
        }

        if (n == 0) {
            out.println(answer);
        } else {
            out.println(-1);
        }
    }

    public void run() {
        long timeStart = System.currentTimeMillis();

        boolean fileIO = TASK_NAME_FOR_IO.length() > 0;
        try {

            if (fileIO) {
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

        if (fileIO) {
            System.out.println("Time spent: " + (timeEnd - timeStart) + " ms");
        }
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