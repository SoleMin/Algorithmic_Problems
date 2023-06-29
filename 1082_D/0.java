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
        int[] notLeaves = new int[501];
        int[] leaves = new int[501];
        int nl = 0;
        int nnl = 0;

        int[] dd = new int[N+1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int deg = in.nextInt();
            dd[i] = deg;
            sum += deg;
            if (deg == 1) leaves[nl++] = i;
            else notLeaves[nnl++] = i;
        }
        if (sum < (N-1)*2) {
            out.println("NO");
            return;
        }

        int diam = nnl-1;
        if (nl >= 2) diam += 2;
        else if (nl == 1) diam++;
        out.println("YES " + diam);
        out.println(N-1);

        int[] deg = new int[N+1];

        for (int i = 1; i < nnl; i++) {
            out.println(notLeaves[i-1] + " " + notLeaves[i]);
            deg[notLeaves[i-1]]++;
            deg[notLeaves[i]]++;
        }


        if (nl >= 2) {
            out.println(leaves[0] + " " + notLeaves[0]);
            out.println(leaves[1] + " " + notLeaves[nnl-1]);
            deg[leaves[0]]++;
            deg[leaves[1]]++;
            deg[notLeaves[0]]++;
            deg[notLeaves[nnl-1]]++;

            int j = 0;
            for (int i = 2; i < nl; i++) {
                while (deg[notLeaves[j]] >= dd[notLeaves[j]]) j++;
                out.println(leaves[i] + " " + notLeaves[j]);
                deg[leaves[i]]++;
                deg[notLeaves[j]]++;
            }
        } else if (nl == 1) {
            out.println(leaves[0] + " " + notLeaves[nnl-1]);
        }


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
