import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zakhar Voit
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(solve(in.nextLong(), in.nextLong()));
        /*for (long l = 1; l < 500; l++) {
            for (long r = l; r < 500; r++) {
                if (badSolve(l, r) != solve(l, r)) {
                    out.println(l + " " + r);
                    return;
                }
            }
        }
        out.println("OK");*/
    }

    long solve(long l, long r) {
        if (l == r)
            return 0;
        long ans = l ^ (l + 1);

        for (int i = 0; i < 62; i++) {
            l |= (1l << i);
            if (l + 1 <= r)
                ans = (1l << (i + 2l)) - 1;
        }

        return ans;
    }
}

class Scanner {
    BufferedReader in;
    StringTokenizer tok;

    public Scanner(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
        tok = new StringTokenizer("");
    }

    public String nextToken() {
        if (!tok.hasMoreTokens()) {
            try {
                String newLine = in.readLine();
                if (newLine == null)
                    throw new InputMismatchException();
                tok = new StringTokenizer(newLine);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            return nextToken();
        }

        return tok.nextToken();
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    }

