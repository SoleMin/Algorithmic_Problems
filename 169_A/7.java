import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class A {

    private void solve() throws IOException {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        
        int[] h = new int[n];
        
        for (int i = 0; i < n; i++)
            h[i] = nextInt();
        
        Arrays.sort(h);
        
        int fstB = h[h.length - a];
        int lstA = h[h.length - a - 1];
        
        pl((fstB - lstA) > 0 ? (fstB - lstA) : 0);
    }

    public static void main(String[] args) {
        new A().run();
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
