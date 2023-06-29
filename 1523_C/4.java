import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    private static void solve() {
        int t = nextInt();
        int[] stack = new int[1000000];
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            stack[0] = nextInt();
            int id = 1;
            pp(stack, id);
            for (int j = 1; j < n; j++) {
                int x = nextInt();
                if (x == 1) {
                    stack[id++] = x;
                } else {
                    while (true) {
                        int p = stack[--id];
                        if (p + 1 == x) {
                            stack[id++] = x;
                            break;
                        }
                    }
                }
                pp(stack, id);
            }
        }
    }

    private static void pp(int[] stack, int size) {
        for (int i = 0; i < size - 1; i++) {
            pw.print(stack[i] + ".");
        }
        pw.println(stack[size - 1]);
    }


}
