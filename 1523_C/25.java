import java.io.*;
import java.util.StringTokenizer;

public class C2 {
    String filename = null;
    InputReader sc;

    void solve() {
        int n = sc.nextInt();
        int[] a = sc.nextArray(n);

        int[] ps = new int[n];
        int[] q = new int[n];
        int[] qs = new int[n];
        int nq = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == 1) {
                qs[nq] = i - 1;
                q[nq++] = a[i - 1] + 1;
                ps[i] = i - 1;
            } else {
                if (a[i] == a[i - 1] + 1) {
                    qs[nq] = i - 1;
                    q[nq++] = 1;
                    ps[i] = i - 1;
                } else {
                    for (int j = nq - 1; j >= 0; j--) {
                        if (a[i] == q[j]) {
                            ps[i] = qs[j];
                            nq = j;
                            break;
                        }
                    }
                }
            }
        }

        int[] parents = ps;
        String[] strs = new String[n];
        strs[0] = "1";
        System.out.println(strs[0]);
        for (int i = 1; i < n; i++) {
            String p = strs[parents[i]];
            if (a[i] == 1) {
                strs[i] = p + ".1";
            } else {
                int lastDot = p.lastIndexOf(".");
                if (lastDot == -1) {
                    strs[i] = a[i] + "";
                } else {
                    strs[i] = p.substring(0, lastDot) + "." + a[i];
                }
            }
            System.out.println(strs[i]);
        }
    }

    public void run() throws FileNotFoundException {
        if (filename == null) {
            sc = new InputReader(System.in);
        } else {
            sc = new InputReader(new FileInputStream(new File(filename)));
        }

        int nTests = sc.nextInt();
        for (int test = 0; test < nTests; test++) {
            solve();
        }
    }

    public static void main(String[] args) {
        C2 sol = new C2();
        try {
            sol.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Float.parseFloat(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
    }
}