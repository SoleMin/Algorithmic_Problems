
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProblemA {

    private final BufferedReader in;
    private final PrintStream out;
    private StringTokenizer tok = new StringTokenizer("");
    private String nextLine = null;

    public static void main(String[] args) throws Exception {
        new ProblemA();
    }

    private ProblemA() throws Exception {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
        start();
        end();
    }

    private int nextInt() {
        return Integer.parseInt(nextWord());
    }

    private String nextWord() {
        if (tok.hasMoreTokens()) {
            return tok.nextToken();
        } else {
            while (!tok.hasMoreTokens()) {
                try {
                    nextLine = in.readLine();
                    if (nextLine == null) {
                        return null;
                    } else {
                        tok = new StringTokenizer(nextLine);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ProblemA.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return tok.nextToken();
        }
    }

    private void start() {
        int n = nextInt();
        int k = nextInt();
        T[] ts = new T[n];
        for (int i = 0; i < n; i++) {
            ts[i] = new T(nextInt(), nextInt());
        }
        Arrays.sort(ts, new Comparator<T>() {

            @Override
            public int compare(T o1, T o2) {
                if (o1.p > o2.p) {
                    return -1;
                }
                if (o1.p < o2.p) {
                    return 1;
                }
                if (o1.t < o2.t) {
                    return -1;
                }
                if (o1.t > o2.t) {
                    return 1;
                }
                return 0;
            }
        });
        int t = ts[k - 1].t;
        int p = ts[k - 1].p;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ts[i].p == p && ts[i].t == t) {
                res++;
            }
        }
        out.println(res);
    }

    class T {

        int p;
        int t;

        public T(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }

    private void end() {
        out.close();
    }
}
