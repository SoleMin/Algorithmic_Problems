import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    private BufferedReader in;
    private StringTokenizer st;
    private PrintWriter out;

    private void solve() throws IOException {
        String s = next();
        for (int length = s.length() - 1; length > 0; --length) {
            Set<String> h = new HashSet<String>();
            int count = 0;
            for (int i = 0; i + length <= s.length(); ++i) {
                h.add(s.substring(i, i + length));
                ++count;
            }
            if (count != h.size()) {
                out.println(length);
                return;
            }
        }
        out.println(0);
    }

    public void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        out.close();
        in.close();
    }

    private void eat(String s) {
        st = new StringTokenizer(s);
    }

    private String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new A().run();
    }
}