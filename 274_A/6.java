import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.TreeSet;
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
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        Set <Integer> vis = new TreeSet<Integer>();
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!(a[i] % k == 0 && vis.contains(a[i] / k))) {
                ++ans;
                vis.add(a[i]);
            }
        }

        out.println(ans);
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

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    }

