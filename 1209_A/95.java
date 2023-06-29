import java.util.*;
import java.io.*;

import static java.lang.Math.*;


public class cfs584A {
    static long LINF = Long.MAX_VALUE / 4;
    static long IING = Integer.MAX_VALUE / 4;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int[] nums = sc.readIntArray(N);
        ArrayList<Integer> num = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            num.add(nums[i]);
        }


        int count = 0;
        while (!num.isEmpty()) {
            count++;
            int size = num.size();
            int min = 200;
            for (int j = size-1; j >=0; j--) {
                if (num.get(j) < min) {
                    min = num.get(j);
                }
            }
            for (int j = size-1; j >=0; j--) {
                int div = num.get(j) / min;
                if ((div * min) == num.get(j)) {
                    num.remove(j);
                }
            }
        }
        sb.append(count);

        System.out.print(sb);
    }

    static void Assert(boolean b) {
        if (!b) throw new Error("Assertion Failed");
    }

    static class Pair implements Comparable<Pair> {
        int x, y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }

        public int compareTo(Pair o) {
            int c1 = Integer.compare(x, o.x);
            return c1 != 0 ? c1 : Integer.compare(y, o.y);
        }

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

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextInt();
            }
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int idx = 0; idx < n; idx++) {
                a[idx] = nextLong();
            }
            return a;
        }
    }
}
