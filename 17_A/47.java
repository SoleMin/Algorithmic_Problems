import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;

    void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        boolean[] sieve = new boolean[n + 1];
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= n; ++i) {
            if (!sieve[i]) {
                primes.add(i);
                for (int j = 2 * i; j <= n; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i + 1 < primes.size(); ++i) {
            int v = primes.get(i) + primes.get(i + 1) + 1;
            if (v <= n && !sieve[v]) {
                ++count;
            }
        }
//        System.err.println(count);
        out.println(count >= k ? "YES" : "NO");
    }

    public void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        out.close();
        in.close();
    }

    void eat(String s) {
        st = new StringTokenizer(s);
    }

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        new A().run();
    }
}