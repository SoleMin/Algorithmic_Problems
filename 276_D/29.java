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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long left = in.nextLong();
        long right = in.nextLong();

        long ans = go(left, right);
        out.println(ans);
    }

    private long go(long A, long B) {
        int bA = -1;
        for(int i = 62; i >= 0; i--)
            if((A & (1L << i)) > 0) {
                bA = i;
                break;
            }
        int bB = -1;
        for(int i = 62; i >= 0; i--)
            if((B & (1L << i)) > 0) {
                bB = i;
                break;
            }

        if(bB == -1)
            return 0;
        if(bA < bB)
            return allOne(bB);
        else
            return go(A ^ (1L << bA), B ^ (1L << bB));
    }

    private long allOne(int bits) {
        long ret = 0;
        for(int i = 0; i <= bits; i++)
            ret |= (1L << i);
        return ret;
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

