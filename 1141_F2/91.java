import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javafx.util.Pair;

public class Solve6 {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        new Solve6().solve(pw);
        pw.flush();
        pw.close();
    }

    public void solve(PrintWriter pw) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, LinkedList<Pair<Integer, Integer>>> h = new HashMap();
        for (int i = 1; i <= n; i++) {
            int s = 0;
            for (int j = i; j >= 1; j--) {
                s += a[j];
                LinkedList<Pair<Integer, Integer>> l;
                if (!h.containsKey(s)) {
                    l = new LinkedList();
                } else {
                    l = h.get(s);
                }
                l.add(new Pair(j, i));
                h.put(s, l);
            }
        }
        LinkedList<Pair<Integer, Integer>>[] l = new LinkedList[h.size() + 1];
        for (int i = 1; i <= h.size(); i++) {
            l[i] = new LinkedList();
        }
        int k = 0, max = 0, index = 0;
        for (LinkedList<Pair<Integer, Integer>> temp : h.values()) {
            k++;
            int i = 0, size = 0;
            for (Pair<Integer, Integer> pair : temp) {
                if (pair.getKey() > i) {
                    i = pair.getValue();
                    l[k].add(pair);
                    size++;
                    if (size > max) {
                        max = size;
                        index = k;
                    }
                }
            }
        }
        pw.println(l[index].size());
        for (Pair<Integer, Integer> pair : l[index]) {
            pw.println(pair.getKey() + " " + pair.getValue());
        }
    }

    static class FastReader {

        StringTokenizer st;
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public boolean hasNext() throws IOException {
            String s = br.readLine();
            if (s == null || s.isEmpty()) {
                return false;
            }
            st = new StringTokenizer(s);
            return true;
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String s = br.readLine();
                if (s.isEmpty()) {
                    return null;
                }
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
