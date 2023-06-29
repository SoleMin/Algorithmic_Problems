import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
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
        F2SameSumBlocksHard solver = new F2SameSumBlocksHard();
        solver.solve(1, in, out);
        out.close();
    }

    static class F2SameSumBlocksHard {
        public void solve(int testNumber, inputClass sc, PrintWriter out) {
            int n = sc.nextInt();
            int[] tab = new int[n];
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                tab[i] = sc.nextInt();
                if (i > 0)
                    s[i] = s[i - 1] + tab[i];
                else
                    s[0] = tab[0];
            }
            HashMap<Integer, F2SameSumBlocksHard.Pair> sums = new HashMap<>();
            F2SameSumBlocksHard.Pair p;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j > 0) {
                        if (sums.get(s[i] - s[j - 1]) != null) {
                            if (sums.get(s[i] - s[j - 1]).last < j) {
                                sums.get(s[i] - s[j - 1]).sum++;
                                sums.get(s[i] - s[j - 1]).last = i;
                            }
                        } else {
                            p = new F2SameSumBlocksHard.Pair();
                            p.sum = 1;
                            p.last = i;
                            sums.put(s[i] - s[j - 1], p);
                        }
                    } else {
                        if (sums.get(s[i]) != null) {
                            if (sums.get(s[i]).last < j) {
                                sums.get(s[i]).sum++;
                                sums.get(s[i]).last = i;
                            }
                        } else {
                            p = new F2SameSumBlocksHard.Pair();
                            p.sum = 1;
                            p.last = i;
                            sums.put(s[i], p);
                        }
                    }
                }
            }

            Iterator<Map.Entry<Integer, F2SameSumBlocksHard.Pair>> it = sums.entrySet().iterator();
            Map.Entry<Integer, F2SameSumBlocksHard.Pair> t;
            int maxsum = 0;
            int cnt = 0;
            while (it.hasNext()) {
                t = it.next();
                if (t.getValue().sum > cnt) {
                    maxsum = t.getKey();
                    cnt = t.getValue().sum;
                }
            }

            out.println(cnt);
            int start = 0;
            for (int i = 0; i < n; i++) {
                for (int j = start; j <= i; j++) {
                    if (j > 0) {
                        if (s[i] - s[j - 1] == maxsum) {
                            out.println((j + 1) + " " + (i + 1));
                            start = i + 1;
                            break;
                        }
                    } else {
                        if (s[i] == maxsum) {
                            out.println((j + 1) + " " + (i + 1));
                            start = i + 1;
                            break;
                        }
                    }
                }
            }


        }

        static class Pair {
            int sum;
            int last;

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

