import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public int[] parse(FastScanner in, int n) {
            String s = in.next();
            int[] temp = new int[n];
            for (int i = 0; i < n; ++i) {
                temp[i] = s.charAt(i) - 'A';
            }
            return temp;
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] s = parse(in, n);

            Map<Integer, TreeSet<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                if (map.containsKey(s[i])) {
                    map.get(s[i]).add(i);
                } else {
                    TreeSet<Integer> temp = new TreeSet<>();
                    temp.add(i);
                    map.put(s[i], temp);
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                int finalI = i;
                final Int integer = new Int();
                integer.x = i;
                map.forEach((Integer x, TreeSet set) -> {
                    if (x != s[finalI]) {
                        Integer temp = (Integer) set.higher(finalI);
                        if (temp == null) {
                            integer.x = -2;
                        } else {
                            if (integer.x != -2)
                                integer.x = Integer.max(integer.x, temp);
                        }
                    } else {
                    }
                });

                if (integer.x != -2) {
                    ans = Integer.min(ans, integer.x - i + 1);
                }
            }

            out.print(ans);
        }

        public class Int {
            int x;

            public Int() {
                x = -1;
            }

        }

    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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

