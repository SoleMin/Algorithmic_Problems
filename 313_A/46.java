/**
 * Created with IntelliJ IDEA.
 * User: Venky
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static void solve() throws IOException {
        String str = br.readLine();
        StringBuffer sb1 = new StringBuffer(str);
        StringBuffer sb2 = new StringBuffer(str);
        StringBuffer sb3 = new StringBuffer(str);
        sb1.deleteCharAt(sb1.length()-1);
        sb2.deleteCharAt(sb2.length()-2);
        int n1 = Integer.parseInt(sb1.toString());
        int n2 = Integer.parseInt(sb2.toString());
        int n3 = Integer.parseInt(sb3.toString());
        out.println(Math.max(n1, Math.max(n2, n3)));
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}
