
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
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
        int[] a = new int[n];
        boolean allOne = true;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            if (a[i] != 1) {
                allOne = false;
            }
        }
        Arrays.sort(a);
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = a[i - 1];
        }
        if (allOne) {
            for (int i = 0; i < n - 1; i++) {
                out.print(a[i] + " ");
            }
            out.print(2);
        } else {
            for (int i = 0; i < n; i++) {
                out.print(res[i] + " ");
            }
        }
    }

    private void end() {
        out.close();
    }
}
