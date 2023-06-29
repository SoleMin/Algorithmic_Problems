import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter printer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer tokenizer;
    final int[][] d;
    final int n;
    final int[] time;
    final Action[] actions;

    private static final class Action {
        int a;
        int b;

        public Action(int a) {
            this.a = this.b = a;
        }

        public Action(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            if (a == b)
                return " " + (a+1);
            return " " + (a+1) + " " + (b+1);
        }
    }

    private static final int dist(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    private final boolean in(int x, int set) {
        return ((1 << x) & set) != 0;
    }

    private final int off(int x, int set) {
        return (set ^ (set & (1 << x)));
    }

    private final int solve(int set) {
        if (time[set] > 0)
            return time[set];
        int min = Integer.MAX_VALUE;
        if (set == 0)
            min = 0;
        else {
            int a;
            for (a = 0; a < n; a++)
                if (in(a, set))
                    break;
            int subset = off(a, set);
            int aux = 2 * d[a][a] + solve(subset);
            if (aux < min) {
                min = aux;
                actions[set] = new Action(a);
            }
            for (int b = a + 1; b < n; b++)
                if (in(b, subset)) {
                    aux = d[a][a] + d[b][b] + d[a][b] + solve(off(b, subset));
                    if (aux < min) {
                        min = aux;
                        actions[set] = new Action(a, b);
                    }
                }
        }
        time[set] = min;
        return min;
    }

    private B() throws IOException {
        int bx = nextInt();
        int by = nextInt();
        n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        reader.close();

        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            d[i][i] = dist(bx, by, x[i], y[i]);// |A|
            for (int j = i + 1; j < n; j++)
                d[i][j] = dist(x[i], y[i], x[j], y[j]);// |AB|
        }
        int set = 1 << n;
        time = new int[set];
        actions = new Action[set];
        set--;
        printer.println(solve(set));
        printer.print("0");
        while (set != 0) {
            solve(set);
            Action action = actions[set];
            printer.print(action);
            printer.print(" 0");
            set = off(action.a, set);
            set = off(action.b, set);
        }

        printer.println();
        printer.close();
    }

    private final int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private final String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static void main(String[] args) throws IOException {
        new B();
    }

}
