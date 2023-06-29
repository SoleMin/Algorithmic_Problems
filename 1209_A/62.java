/**
 * Created by Alyssa Herbst on 9/14/19 9:05 AM.
 */

import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class B {
    static StringBuilder sb;
    static int N;
    static int[] A;
    static boolean[] B;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        //Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        B = new boolean[N];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if(B[i]) {
                continue;
            }
            else {
                count++;
                B[i] = true;
            }
            for (int j = i + 1; j < A.length; j++) {
                if(A[j] % A[i] == 0) {
                    B[j] = true;
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner() {
            this(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readNextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readIntBrray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongBrray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}