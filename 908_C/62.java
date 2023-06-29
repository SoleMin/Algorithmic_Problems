
import java.util.*;
import java.io.*;

public class Solution2 {


    private void solve() throws IOException {
        int n = in.nextInt();
        double r = in.nextDouble();
        List<Double> xes = new ArrayList<>(n);
        List<Double> yes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            xes.add(in.nextDouble());
        }
        for (int i = 0; i < n; i++) {
            double max = r;
            for (int j = 0; j < i; j++) {
                double x = xes.get(j);
                double y = yes.get(j);
                if (xes.get(i) <= x + 2 * r && xes.get(i) >= x - 2 * r) {
                    max = Math.max(max, y + Math.sqrt(4 * r * r - Math.abs(x - xes.get(i))* Math.abs(x - xes.get(i))));
                }
            }
            yes.add(max);
        }
        for (double y : yes) {
            System.out.print(y + " ");
        }
        System.out.println();
        System.out.flush();
    }

    private static String filename = "";
    private PrintWriter out;
    private MyScanner in;

    private void run() throws IOException {
        in = new MyScanner();
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    private class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        MyScanner() throws IOException {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public MyScanner(String fileTitle) throws IOException {
            this.br = new BufferedReader(new FileReader(fileTitle));
        }

        public String nextLine() throws IOException {
            String s = br.readLine();
            return s == null ? "-1" : s;
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return "-1";
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public Integer nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public Double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

        void close() throws IOException {
            this.br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new Solution2().run();
    }
}


