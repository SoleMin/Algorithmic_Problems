import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Washoum
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        inputClass in = new inputClass(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        APaintTheNumbers solver = new APaintTheNumbers();
        solver.solve(1, in, out);
        out.close();
    }

    static class APaintTheNumbers {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            Integer[] tab = new Integer[n];
            for (int i = 0; i < n; i++) {
                tab[i] = sc.nextInt();
            }
            Arrays.sort(tab);
            boolean[] done = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!done[i]) {
                    ans++;
                    done[i] = true;
                    for (int j = i + 1; j < n; j++) {
                        if (!done[j] && tab[j] % tab[i] == 0) {
                            done[j] = true;
                        }
                    }
                }
            }
            out.println(ans);
        }

    }

    static class inputClass {
        BufferedReader br;
        StringTokenizer st;

        public inputClass(InputStream in) {

            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

