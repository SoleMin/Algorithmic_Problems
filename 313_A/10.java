/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author N-AssassiN
 */
public class Main {

    private static BufferedReader reader;
    private static BufferedWriter out;
    private static StringTokenizer tokenizer;
    //private final static String filename = "filename";

    private static void init(InputStream input, OutputStream output) {
        reader = new BufferedReader(new InputStreamReader(input));
        out = new BufferedWriter(new OutputStreamWriter(output));
        //reader = new BufferedReader(new FileReader(filename + ".in"));
        //out = new BufferedWriter(new FileWriter(filename + ".out"));
        tokenizer = new StringTokenizer("");
    }

    private static String nextLine() throws IOException {
        return reader.readLine();
    }

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        init(System.in, System.out);
        int n = nextInt();
        //long startTime = System.currentTimeMillis();
        if (n > 0) {
            out.write(n + "\n");
        } else {
            String s = n + "";
            String s2 = s.substring(0, s.length() - 1);
            String s3 = s.substring(0, s.length() - 2) + s.charAt(s.length() - 1);
            int a = Integer.parseInt(s2);
            int b = Integer.parseInt(s3);
            int ans = Math.max(a, b);
            out.write(ans + "\n");
        }
        //long runTime = System.currentTimeMillis() - startTime;
        //out.write(runTime + "\n");
        out.flush();
    }
}