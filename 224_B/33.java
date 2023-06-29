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
		StreamInputReader in = new StreamInputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, StreamInputReader in, PrintWriter out) {
        int N = in.readInt();
        int K = in.readInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = in.readInt();

        int num = 0;
        int left = 0;
        int right = 0;
        int[] seen = new int[100005];
        while(right < N && num < K) {
            if(seen[A[right]] == 0)
                num++;
            seen[A[right]]++;
            right++;
        }
        right--;

        if(num == K) {
            while(seen[A[left]] > 1) {
                seen[A[left]]--;
                left++;
            }

            out.print((left + 1) + " " + (right + 1));
            return;
        }
        out.print("-1 -1");
	}
}

class StreamInputReader extends InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar, numChars;

    public StreamInputReader(InputStream stream) {
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

    }

abstract class InputReader {

    public abstract int read();

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public String readString() {
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

