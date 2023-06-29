//package codeforces.contests.cf159;

import java.io.*;
import java.util.Arrays;

public class ProblemA {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));

    int[] readInts() throws IOException {
        String[] strings = reader.readLine().split(" ");
        int[] ints = new int[strings.length];
        for(int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    void solve() throws IOException {
        int[] tt = readInts();
        int n = tt[0];
        int m = tt[1];
        int k = tt[2];
        int[] a = readInts();
        Arrays.sort(a);
        for(int i = 0, j = a.length - 1; i < j; i++, j--) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        int ix = 0;
        while(k < m && ix < n) {
            k += a[ix++] - 1;
        }
        if(k < m) {
            writer.println(-1);
        }
        else {
            writer.println(ix);
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        new ProblemA().solve();
    }
}
