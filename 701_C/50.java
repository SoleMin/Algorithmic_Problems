import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rene
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.next();
            HashMap<Character, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (!indexMap.containsKey(c)) {
                    indexMap.put(c, indexMap.size());
                }
            }
            int[] last = new int[indexMap.size()];
            Arrays.fill(last, -1_000_000);
            int answer = n;
            for (int i = 0; i < n; i++) {
                int index = indexMap.get(s.charAt(i));
                last[index] = i;
                int first = i;
                for (int a : last) first = Math.min(first, a);
                int visits = i - first + 1;
                answer = Math.min(answer, visits);
            }
            out.println(answer);
        }

    }
}

