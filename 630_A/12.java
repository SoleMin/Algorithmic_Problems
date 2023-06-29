import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;


public class Main {

    private static void solve() throws IOException {
        long n = nextLong();
        out.println(25);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("System.in");
        InputStream input = System.in;
        PrintStream output = System.out;
        if (file.exists() && file.canRead()) {
            input = new FileInputStream(file);
            output = new PrintStream("System.out");
        }
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(output);
        solve();
        out.close();
    }

    private static BufferedReader br;
    private static StringTokenizer st;
    private static PrintWriter out;

    private static boolean hasNextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return false;
            }
            st = new StringTokenizer(line);
        }
        return true;
    }

    private static String nextToken() throws IOException {
        return hasNextToken() ? st.nextToken() : null;
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

}



