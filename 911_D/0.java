import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = 1;
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            int n = scan.nextInt();
            int parity = 0;
            int[] a = new int[n];

            for(int i = 0; i < n; i++) a[i] = scan.nextInt();
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(a[i] > a[j]) parity++;
                }
            }
            parity %= 2;
            int q = scan.nextInt();
            String[] get = {"even", "odd"};
            for(int i = 0; i < q; i++) {
                int l = scan.nextInt(), r = scan.nextInt();
                parity ^= (r - l + 1) / 2 % 2;
                out.println(get[parity]);
            }
        }
    }

    static void ruffleSort(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        Arrays.sort(a);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}