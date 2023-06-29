import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner();
        StringBuilder output = new StringBuilder();

        int n = input.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }

        Arrays.sort(a);
        boolean[] colored = new boolean[n];
        int colors = 0;
        for (int i = 0; i < n; i++) {
            if (!colored[i]) {
                colors ++;
                colored[i] = true;
                for (int j = i+1; j < n; j++) {
                    if (a[j] % a[i] == 0) {
                        colored[j] = true;
                    }
                }
            }
        }

        System.out.println(colors);
    }

    private static class Scanner {
        BufferedReader br; StringTokenizer st;
        public Scanner(Reader in) { br = new BufferedReader(in); }
        public Scanner() { this(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine());
                } catch (IOException e) { e.printStackTrace(); } }
            return st.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String readNextLine() {
            String str = "";
            try { str = br.readLine();
            } catch (IOException e) { e.printStackTrace(); }
            return str; }
        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) { a[idx] = nextInt(); }
            return a; }
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) { a[idx] = nextLong(); }
            return a; }
    } // end Scanner
}
