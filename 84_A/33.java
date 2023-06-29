import java.io.*;
import java.util.*;

public class Main {

    public void solve() throws IOException {
        int n = nextInt();
        output.println(n / 2 * 3);
    }

    public void run() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new PrintWriter(System.out);
        solve();
        input.close();
        output.close();
    }

    BufferedReader input;
    PrintWriter output;
    StringTokenizer tok;

    String nextToken() throws IOException {
        while(tok == null || !tok.hasMoreTokens())
            tok = new StringTokenizer(input.readLine());

        return tok.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.valueOf(nextToken());
    }

    long nextLong() throws IOException {
        return Long.valueOf(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.valueOf(nextToken());
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
