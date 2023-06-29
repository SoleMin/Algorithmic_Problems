/*
Keep solving problems.
*/

import java.util.*;
import java.io.*;

public class CFA {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    private static final long MOD = 1000L * 1000L * 1000L + 7;
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final String yes = "Yes";
    private static final String no = "No";

    int n;
    int[] arr;
    class Segment {
        int start;
        int end;
        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
    Map<Integer, List<Segment>> hm = new HashMap<>();
    void solve() throws IOException {
        n = nextInt();
        arr = nextIntArr(n);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (!hm.containsKey(sum)) {
                    hm.put(sum, new ArrayList<>());
                }

                hm.get(sum).add(new Segment(i, j));
            }
        }

        int max = -1;
        int idx = -1;
        for (Map.Entry<Integer, List<Segment>> entry : hm.entrySet()) {
            int key = entry.getKey();
            List<Segment> values = entry.getValue();
            Collections.sort(values, new Comparator<Segment>() {
                @Override
                public int compare(Segment o1, Segment o2) {
                    return Integer.compare(o1.end, o2.end);
                }
            });
            int cnt = findSeg(values).size();
            if (cnt > max) {
                max = cnt;
                idx = key;
            }
        }

        List<Segment> res = findSeg(hm.get(idx));
        outln(res.size());
        for (int i = 0; i < res.size(); i++) {
            outln((1 + res.get(i).start) + " " + (1 + res.get(i).end));
        }
    }

    List<Segment> findSeg(List<Segment> input) {
        List<Segment> res = new ArrayList<>();
        int bound = -1;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).start > bound) {
                res.add(input.get(i));
                bound = input.get(i).end;
            }
        }

        return res;
    }

    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    long gcd(long a, long b) {
        while(a != 0 && b != 0) {
            long c = b;
            b = a % b;
            a = c;
        }
        return a + b;
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    private void formatPrint(double val) {
        outln(String.format("%.9f%n", val));
    }
    public CFA() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }
    public static void main(String[] args) throws IOException {
        new CFA();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}