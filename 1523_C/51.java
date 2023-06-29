import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    static void debug(Object... args) {
        System.out.println(Arrays.deepToString(args));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Stack<LN> nodes = new Stack<>();
            int a0 = Integer.parseInt(br.readLine());
            LN root = new LN(1, 0, "");
            nodes.add(root);
            pw.println(root);
            for (int i = 0; i < N - 1; i++) {
                int ai = Integer.parseInt(br.readLine());
                while (!nodes.isEmpty()) {
                    LN nn = nodes.pop();
                    if (ai == 1) {
                        LN e = new LN(1, nn.depth + 1, nn.toString());
                        nodes.add(nn);
                        nodes.add(e);
                        pw.println(e);
                        break;
                    } else if (nn.lv == ai - 1) {
                        LN e = new LN(ai, nn.depth, nn.base);
                        nodes.add(e);
                        pw.println(e);
                        break;
                    }
                }
            }
        }
        pw.flush();
    }

    static class LN {
        int lv;
        int depth;
        String base;

        public LN(int lv, int depth, String prev) {
            this.lv = lv;
            this.depth = depth;
            base = prev;
        }

        @Override
        public String toString() {
            StringBuilder bob = new StringBuilder(base);
            if (depth > 0) {
                bob.append(".");
            }
            bob.append(lv);
            return bob.toString();
        }
    }
}
