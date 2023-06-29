import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;

    static class House implements Comparable<House> {
        final int x, a;

        House(int x, int a) {
            this.x = x;
            this.a = a;
        }

        public int compareTo(House h) {
            return x - h.x;
        }
    }

    void solve() throws IOException {
        int n = nextInt();
        int t = nextInt();
        House[] h = new House[n];
        for (int i = 0; i < n; ++i) {
            h[i] = new House(2 * nextInt(), nextInt());
        }
        Arrays.sort(h);
        int ans = 2;
        for (int i = 1; i < n; ++i) {
            House prev = h[i - 1];
            House curr = h[i];
            int diff = 2 * t + curr.a + prev.a;
            if (curr.x - prev.x == diff) {
                ++ans;
            } else if (curr.x - prev.x > diff) {
                ans += 2;
            }
        }
        out.println(ans);
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