import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author xwchen
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

            int[] cnt = new int[26];
            int[] cnt2 = new int[26];
            int j = 0;
            int res = n;
            HashSet<Character> set = new HashSet<Character>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            int m = set.size();

            for (int i = 0; i < n; ++i) {
                if (Character.isLowerCase(s.charAt(i))) {
                    cnt[s.charAt(i) - 'a']++;
                } else {
                    cnt2[s.charAt(i) - 'A']++;
                }
                while (isOK(cnt, cnt2, m)) {
                    res = Math.min(res, i - j + 1);
                    if (Character.isLowerCase(s.charAt(j))) {
                        cnt[s.charAt(j) - 'a']--;
                    } else {
                        cnt2[s.charAt(j) - 'A']--;
                    }
                    ++j;
                }
            }
            out.println(res);
        }

        boolean isOK(int[] cnt, int[] cnt2, int m) {
            int c = 0;
            for (int i = 0; i < 26; ++i) {
                if (cnt[i] > 0) {
                    ++c;
                }
            }
            for (int i = 0; i < 26; ++i) {
                if (cnt2[i] > 0) {
                    ++c;
                }
            }
            return c >= m;
        }

    }
}

