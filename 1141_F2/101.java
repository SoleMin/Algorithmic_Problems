import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    static final int INF = (int) 1e9;
    static final int mod = (int) (1e9 + 7);
    static final short UNCALC = -1;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = sc.nextIntArray(n);
        long[] cum = new long[n];
        cum[0] = a[0];
        for (int i = 1; i < n; i++)
            cum[i] = a[i] + cum[i - 1];
        HashMap<Long, ArrayList<Pair>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long cur = get(cum, i, j);
                if (!hm.containsKey(cur)) hm.put(cur, new ArrayList<>());
                hm.get(cur).add(new Pair(i, j));
            }
        }
        int max = 0;
        StringBuilder ans = new StringBuilder();
        for (long sum : hm.keySet()) {
            ArrayList<Pair> cur = hm.get(sum);
            Collections.sort(cur);
            int poss = 0;
            int r = -1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i).left > r) {
                    poss++;
                    r = cur.get(i).right;
                    sb.append(cur.get(i));
                }
            }
            if (poss> max){
                max = poss;
                ans = sb;
            }
        }
        out.println(max);
        out.println(ans);
        out.flush();
        out.close();
    }

    static long get(long[] a, int i, int j) {
        return a[j] - (i > 0 ? a[i - 1] : 0);
    }

    static class Pair implements Comparable<Pair> {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Pair o) {
            return right - o.right;
        }

        @Override
        public String toString() {
            return (left + 1) + " " + (right + 1) + "\n";
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }
}