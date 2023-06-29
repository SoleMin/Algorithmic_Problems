import static java.util.Arrays.deepToString;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static void solve() throws IOException {
        int n = nextInt();
        if (n >= 0) {
            System.out.println(n);
        } else {
            String string = String.valueOf(n);
            int v1 = Integer.valueOf(string.substring(0, string.length() - 1));
            int v2 = Integer.valueOf(string.substring(0, string.length() - 2)
                    + string.charAt(string.length() - 1));
            if (v1 >= v2) {
                System.out.println(v1);
            } else {
                System.out.println(v2);
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);

        setTime();
        solve();
        printTime();
        printMemory();

        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");
    static long systemTime;

    static void debug(Object... o) {
        System.err.println(deepToString(o));
    }

    static void setTime() {
        systemTime = System.currentTimeMillis();
    }

    static void printTime() {
        System.err.println("Time consumed: "
                + (System.currentTimeMillis() - systemTime));
    }

    static void printMemory() {
        System.err.println("Memory consumed: "
                + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
                        .freeMemory()) / 1000 + "kb");
    }

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
}