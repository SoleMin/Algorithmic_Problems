
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @author Polyarniy Nickolay
 */
public class ProblemD {

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tok;
    private final String DELIMETER = " ";
    private final boolean ENABLE_MULTITEST = false;
    private final boolean DEBUG = true;
    private final String FILENAME = null;//if FILENAME = null, then works with console

    public void run() throws Exception {
        initInputOutput();
        do {
            init();
            solve();
        } while (hasMoreTokens() && ENABLE_MULTITEST);
        finish();
    }

    private void init() throws Exception {
    }

    private void solve() throws Exception {
        String a = Long.toBinaryString(nextLong());
        String b = Long.toBinaryString(nextLong());
        while (a.length() < 64) {
            a = "0" + a;
        }
        while (b.length() < 64) {
            b = "0" + b;
        }
//        out.println(a);
//        out.println(b);
        char[] res = new char[a.length()];
        int cur = 0;
        while (cur < a.length() && a.charAt(cur) == b.charAt(cur)) {
            res[cur] = '0';
            cur++;
        }
        while (cur < res.length) {
            res[cur] = '1';
            cur++;
        }

        out.println(Long.valueOf(new String(res), 2));
    }

    public static void main(String[] args) throws Exception {
        ProblemD solution = new ProblemD();
        solution.run();
    }

    private void initInputOutput() throws Exception {
        if (FILENAME == null) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    private void shuffleArray(Object[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            Object tmp = arr[i];
            int j = r.nextInt(arr.length);
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private void shuffleArray(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = r.nextInt(arr.length);
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private int[] nextArrayInt(int n) throws Exception {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    private String nextWord() throws Exception {
        if (updateTokenizer()) {
            return null;
        } else {
            return tok.nextToken();
        }
    }

    private boolean hasMoreTokens() throws Exception {
        return !updateTokenizer();
    }

    private boolean updateTokenizer() throws Exception {
        while (tok == null || !tok.hasMoreTokens()) {
            String nextLine = in.readLine();
            if (nextLine == null || nextLine.isEmpty()) {
                return true;
            }
            tok = new StringTokenizer(nextLine, DELIMETER);
        }
        return false;
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(nextWord());
    }

    private long nextLong() throws Exception {
        return Long.parseLong(nextWord());
    }

    private void finish() throws Exception {
        in.close();
        out.close();
    }

    private void print(String s) {
        if (DEBUG) {
            System.out.print(s);
        }
    }

    private void println(String s) {
        if (DEBUG) {
            System.out.println(s);
        }
    }

    private void println() {
        if (DEBUG) {
            System.out.println();
        }
    }

    private long[] getFirstSimpleNums(int n) {
        boolean[] notPr = new boolean[n];
        int res = n;
        notPr[0] = true;
        res--;
        notPr[1] = true;
        res--;
        for (int i = 2; i < n; ++i) {
            if (!notPr[i]) {
                for (int j = i + i; j < n; j += i) {
                    if (!notPr[j]) {
                        notPr[j] = true;
                        res--;
                    }
                }
            }
        }
        long[] resA = new long[res];
        int next = 0;
        for (int i = 0; i < n; i++) {
            if (!notPr[i]) {
                resA[next] = i;
                next++;
            }
        }
        return resA;
    }

    private static class Pair {

        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public static final Comparator<Pair> comparator = new Comparator<Pair>() {

            @Override
            public int compare(Pair pair1, Pair pair2) {
                return (pair1.a - pair2.a) != 0 ? (pair1.a - pair2.a) : (pair1.b - pair2.b);
            }
        };

        @Override
        public String toString() {
            return "{" + a + "|" + b + '}';
        }
    }
}