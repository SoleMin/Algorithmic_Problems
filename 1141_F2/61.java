import java.io.*;
import java.util.*;
import java.awt.Point;

public class CF_1141F2 {
    public static void main(String args[]) throws Exception {
        BufferedScanner in = new BufferedScanner(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(new BufferedOutputStream(System.out));

        int n = in.nextInt();
        int[] arr = in.nextN(n);

        HashMap<Integer, ArrayList<Point>> lp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j >= 0; j--) {
                curr += arr[j];
                if (!lp.containsKey(curr)) lp.put(curr, new ArrayList<>());

                lp.get(curr).add(new Point(j, i));
            }
        }

        ArrayList<Point> retPs = new ArrayList<>();
        for (ArrayList<Point> ps : lp.values()) {
            Collections.sort(ps, (a, b) -> a.y - b.y);

            ArrayList<Point> currPs = new ArrayList<>();
            for (int i = 0; i < ps.size(); ) {
                Point curr = ps.get(i);
                currPs.add(curr);

                while (i < ps.size() && ps.get(i).x <= curr.y) i++;
            }
            if(currPs.size() > retPs.size()) retPs = currPs;
        }
        out.println(retPs.size());
        for (Point p : retPs) out.println((p.x + 1) + " " + (p.y + 1));


        out.close();
        in.close();
    }

    static class BufferedScanner {
        private BufferedReader in;
        private StringTokenizer st;

        BufferedScanner(Reader in) throws IOException {
            this.in = new BufferedReader(in);
            st = new StringTokenizer(this.in.readLine());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        int[] nextN(int n) throws IOException {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) ret[i] = this.nextInt();
            return ret;
        }

        long[] nextNL(int n) throws IOException {
            long[] ret = new long[n];
            for (int i = 0; i < n; i++) ret[i] = this.nextLong();
            return ret;
        }

        String next() throws IOException {
            if (!st.hasMoreElements()) st = new StringTokenizer(in.readLine());

            return st.nextToken();
        }

        void close() throws IOException {
            in.close();
        }

    }
}
