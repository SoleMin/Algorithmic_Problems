import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A {

    private void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        Point[] p = new Point[n];
        for (int i = 0; i < n; i++)
            p[i] = new Point(nextInt(), nextInt());
        Arrays.sort(p, new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) return o1.y - o2.y;
                return o2.x - o1.x;
            }
        });
        
        Point cur = p[k - 1];
        int res = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].x == cur.x && p[i].y == cur.y) res++;
        }
        pl(res);
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
