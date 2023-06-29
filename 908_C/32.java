/**
 * Created by Ariana Herbst on 12/29/17.
 */

import java.util.*;
import java.io.*;

/**
 * Created by Ariana Herbst on 12/29/17
 */
public class GB2017C {
    static int n, r;
    static int[] x;
    static Map<Integer, Double> horo;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        r = sc.nextInt();
        x = new int[n];
        horo = new HashMap<Integer, Double>();
        for (int x = 0; x <= r*2; x++) {
            double y = 2.0 *Math.sqrt(r * r - (r - x/2.0) * (r - x/2.0));
            horo.put(x, y);
        }
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        List<Double> y = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            double max = r;
            for (int j = 0; j < y.size(); j++) {
                int dx = intersects(i, j);
                if (dx >= 0) {
                    double dy = horo.get(dx);
                    max = Math.max(max, dy + y.get(j));
                }
            }
            y.add(max);
        }
        for (int i = 0; i < n; i++) {
            sb.append(y.get(i) + " ");
        }
        System.out.println(sb);
    }

    static int intersects(int i, int j) {
        if (Math.abs(x[i] - x[j]) <= 2*r) {
            return 2*r - Math.abs(x[i] - x[j]);
        } else
            return -1;
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
