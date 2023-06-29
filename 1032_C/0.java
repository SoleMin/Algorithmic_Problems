import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static long MOD = 1_000_000_000 + 7;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] c = new boolean[n][5];
        for (int i = 0; i < 5; i++) {
            c[0][i] = true;
        }

        for (int i = 1; i < c.length; i++) {
            if (a[i] > a[i - 1]) {
                for (int j = 0; j < 5; j++) {
                    boolean po = false;
                    for (int k = 0; k < j; k++) {
                        po = po | c[i - 1][k];
                    }
                    c[i][j] = po;
                }
            } else if (a[i] < a[i - 1]) {
                for (int j = 0; j < 5; j++) {
                    boolean po = false;
                    for (int k = j + 1; k < 5; k++) {
                        po = po | c[i - 1][k];
                    }
                    c[i][j] = po;
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    boolean po = false;
                    for (int k = 0; k < 5; k++) {
                        if (k != j)
                            po = po | c[i - 1][k];
                    }
                    c[i][j] = po;
                }
            }
        }
        int in = -1;
        for (int i = 0; i < 5; i++) {
            if (c[n - 1][i]) {
                in = i;
            }
        }
        if (in == -1) {
            System.out.println(-1);
            return;
        }
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i > 0; i--) {
            s.add(in + 1);
            if (a[i] > a[i - 1]) {
                for (int j = 0; j < in; j++) {
                    if (c[i - 1][j]) {
                        in = j;
                        break;
                    }
                }
                continue;
            } else if (a[i] < a[i - 1]) {
                for (int j = in + 1; j < 5; j++) {
                    if (c[i - 1][j]) {
                        in = j;
                        break;
                    }
                }
                continue;
            } else {
                for (int j = 0; j < 5; j++) {
                    if (j != in && c[i - 1][j]) {
                        in = j;
                        break;
                    }
                }
            }
        }
        s.add(in + 1);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }
}