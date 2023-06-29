import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author vadimmm
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long l = in.nextLong();
        long r = in.nextLong();
        /*
        long max = 1;
        boolean good = false;
        for (int i = 0; i < 62; ++i) {
            max <<= 1;
            if (max > r) {
                max >>= 1;
                if (max >= l) {
                    good = true;
                }
                break;
            }
        }
        if (good) {
            if (max - 1 >= l)
                out.println(max ^ (max - 1));
            else
                out.println(max ^ r);
            return;
        }
        */
        boolean[][] answer = new boolean[2][100];
        int cur = 0;
        while (r > 0) {
            answer[0][cur] = (r % 2 != 0);
            ++cur;
            r >>= 1;
        }
        cur = 0;
        while (l > 0) {
            answer[1][cur] = (l % 2 != 0);
            ++cur;
            l >>= 1;
        }
        int old = -1;
        for (int i = 63; i >= 0; --i) {
            if (answer[0][i] && !answer[1][i]) {
                old = i;
                break;
            }
        }
        if (old == -1) {
            out.println(0);
            return;
        }
        long a = 1;
        for (int i = 0; i < old; ++i) {
            a <<= 1;
            a += 1;
        }
        out.println(a);
    }
}

class InputReader {

    private static BufferedReader bufferedReader;
    private static StringTokenizer stringTokenizer;

    public InputReader(InputStream inputStream) {
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        stringTokenizer = null;
    }

    public String next() {
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    }

