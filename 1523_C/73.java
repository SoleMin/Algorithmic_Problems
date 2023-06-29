// package contest;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class teama {

    static int mod = 2_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack();
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(br.readLine());
                if (a != 1) {
                    while (stack.peek() + 1 != a) {
                        stack.pop();
                    }
                    stack.pop();
                }
                stack.push(a);

                boolean dummy = false;
                for (int j : stack) {
                    if (dummy) {
                        pw.print(".");
                    }
                    pw.print(j);
                    dummy = true;
                }
                pw.println();
            }
        }

        pw.close();
        br.close();
    }
}
