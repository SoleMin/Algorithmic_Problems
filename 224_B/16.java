import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class B {

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        
        int[] f = new int[100000 + 2];
        
        int min = Integer.MAX_VALUE;
        int cur = 0;
        int start = 0;
        int from = -1, to = -1;
        
        for (int i = 0; i < n; i++) {
            f[a[i]]++;
            if (f[a[i]] == 1) cur++;
            if (cur == k) {
                while (f[a[start]] > 1) {
                    f[a[start]]--;
                    start++;
                }
                if (i - start + 1 < min) {
                    min = i - start + 1;
                    from = start;
                    to = i;
                }
            }
        }
        pl(from == -1 ? "-1 -1" : ((1 + from) + " " + (1 + to)));
    }

    public static void main(String[] args) {
        new B().run();
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

    BigInteger nextBigInteger() throws IOException {
        return new BigInteger(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    void p(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.flush();
            writer.print(objects[i]);
            writer.flush();
        }
    }

    void pl(Object... objects) {
        p(objects);
        writer.flush();
        writer.println();
        writer.flush();
    }

    int cc;

    void pf() {
        writer.printf("Case #%d: ", ++cc);
        writer.flush();
    }

}