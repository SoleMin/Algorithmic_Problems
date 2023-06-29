import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }

    public static long mod = 17352642619633L;

    void run(FastScanner in, PrintWriter out) {

        int N = in.nextInt();
        int K = in.nextInt();

        char[] ca = in.next().toCharArray();

        LinkedList<Integer> ll = new LinkedList<>();

        int totallen = 0;
        // start pos, endpos length
        LinkedList<int[]> added = new LinkedList<>();


        for (int i = 0; i < ca.length && totallen < K; i++) {
            if (ca[i] == '(') {
                ll.offerLast(i);
            } else {

                int start = ll.pollLast();
                int newlen = i-start+1;

                while (!added.isEmpty() && added.peekLast()[0] > start) {
                    int[] top = added.pollLast();
                    newlen -= top[2];
                }

                totallen += newlen;
                added.offerLast(new int[] {start, i, i-start+1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] t : added) {
            for (int i = t[0]; i <= t[1]; i++) sb.append(ca[i]);
        }
        out.println(sb.toString());

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
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
    }
}
