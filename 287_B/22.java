import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author George Marcus
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long N = in.nextLong();
        long K = in.nextLong();

        if(N == 1) {
            out.println(0);
            return;
        }
        if(N <= K) {
            out.println(1);
            return;
        }

        long st = 1;
        long dr = K - 1;
        long m;
        long ans = -1;

        while(st <= dr) {
            m = (st + dr) / 2;

            if(get(m, K) <= N) {
                ans = m;
                st = m + 1;
            }
            else dr = m - 1;
        }

        N -= get(ans, K);

        if(ans == -1 || (ans == K - 1 && N > 0) ) {
            out.println(-1);
            return;
        }
        if(N > 0)
            ans++;

        out.println(ans);
    }

    private long get(long p, long K) {
        long sum = (K - p + 1 + K) * p / 2;
        long extra = p - 1;
        return sum - extra;
    }
}

class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public long nextLong() {
        return Long.parseLong(nextString());
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuffer res = new StringBuffer();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    }

