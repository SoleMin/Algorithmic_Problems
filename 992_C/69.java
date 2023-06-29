//package com.company;

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static long TIME_START, TIME_END;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("Test.in"));
        PrintWriter pw = new PrintWriter(System.out);
//        PrintWriter pw = new PrintWriter(new FileOutputStream("Test.out"));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("Test.in"));
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.out.println("Memory increased:" + (usedMemoryAfter-usedMemoryBefore) / 1000000 );
        System.out.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    public static class Task {
        int mod = 1_000_000_007;
        public long pow(long a, long b) {
            if (b == 0) return 1L;
            if (b % 2 == 0) return pow(a * a % mod, b >> 1);
            return a * pow(a * a % mod, b >> 1) % mod;
        }
        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            long T = sc.nextLong();
            long k = sc.nextLong();
            if (T == 0) {
                pw.println(0);
                return;
            }
            long a1 = pow(2, k + 1);
            long a2 = pow(2, k);
            long s = a1 * (T % mod) % mod;
            long t = ((1 - a2) + mod) % mod;
            long y = (s + t) % mod;
            pw.println((y + 5L * mod) % mod);
        }





    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(FileReader s) throws FileNotFoundException {br = new BufferedReader(s);}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}