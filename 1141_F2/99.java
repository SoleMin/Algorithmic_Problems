import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

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
        TaskF2 solver = new TaskF2();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskF2 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Map<Long, List<Pair>> map = new HashMap<>();
            for (int r = 0; r < n; r++) {
                long sum = 0;
                for (int l = r; l >= 0; l--) {
                    sum += arr[l];
                    if (map.containsKey(sum)) {
                        map.get(sum).add(new Pair(l, r));
                    } else {
                        map.put(sum, new ArrayList<>());
                        map.get(sum).add(new Pair(l, r));
                    }
                }
            }
            int ans = -1;
            List<Pair> ansPairs = new ArrayList<>();
            for (long sum : map.keySet()) {
                List<Pair> pairs = map.get(sum);
                int count = 0;
                int idx = -1;
                List<Pair> tempPairs = new ArrayList<>();
                for (Pair pair : pairs) {
                    if (pair.i > idx) {
                        idx = pair.j;
                        tempPairs.add(pair);
                        count++;
                    }
                }
                if (ans < count) {
                    ans = count;
                    ansPairs = tempPairs;
                }
            }
            out.println(ans);
            for (Pair pair : ansPairs) {
                out.print((pair.i + 1) + " " + (pair.j + 1));
                out.println();
            }
        }

        class Pair {
            int i;
            int j;

            Pair(int p, int q) {
                i = p;
                j = q;
            }

        }

    }
}

