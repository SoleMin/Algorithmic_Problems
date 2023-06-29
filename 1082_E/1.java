import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        EIncreasingFrequency solver = new EIncreasingFrequency();
        solver.solve(1, in, out);
        out.close();
    }

    static class EIncreasingFrequency {
        int n;
        int c;
        int[] arr;
        ArrayList<Integer>[] lists;
        int[] countC;

        public void readInput(Scanner sc) {
            n = sc.nextInt();
            c = sc.nextInt();
            arr = new int[n];
            lists = new ArrayList[(int) 5e5 + 1];
            for (int i = 0; i < lists.length; i++)
                lists[i] = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] != c)
                    lists[arr[i]].add(i);
            }
        }

        public void solve(int testNumber, Scanner sc, PrintWriter pw) {
            int q = 1;
            while (q-- > 0) {
                readInput(sc);
                int max = 0;
                countC = new int[n];
                for (int i = 0; i < n; i++) {
                    if (arr[i] == c)
                        countC[i] = 1;
                    if (i != 0)
                        countC[i] += countC[i - 1];
                }
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i].isEmpty())
                        continue;
                    max = Math.max(max, maxSubSeg(lists[i]));
                }
                pw.println(max + countC[n - 1]);
            }
        }

        private int maxSubSeg(ArrayList<Integer> list) {
            int sum = 1;
            int max = 1;
            for (int i = 1; i < list.size(); i++) {
                int idx = list.get(i);
                int prev = list.get(i - 1);
                int remove = countC[idx] - countC[prev];
                sum += -remove + 1;
                if (sum <= 0)
                    sum = 1;
                max = Math.max(max, sum);
            }
            return max;
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

