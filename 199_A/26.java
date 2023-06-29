import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Solver solver = new Solver();
        solver.open();
        solver.solve();
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }

    public void solve() throws NumberFormatException, IOException {
        int n = nextInt();
        out.println(0+" "+0+" "+n);
    }

    public void close() {
        out.flush();
        out.close();
    }

}