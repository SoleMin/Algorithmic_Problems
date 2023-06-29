import java.util.Map;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
        int n = in.readInt();
        int a = in.readInt();
        int b = in.readInt();
        TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            mp.put(in.readInt(), i);
        }
        int aname = 0;
        int bname = 1;
        if (a > b) {
            int t = a;
            a = b;
            b = t;
            aname = 1;
            bname = 0;
        }
        int[] res = new int[n];
        while (mp.size() > 0) {
            Map.Entry<Integer, Integer> e = mp.firstEntry();
            int val = e.getKey();
            if (mp.containsKey(b - val)) {
                res[mp.get(val)] = res[mp.get(b - val)] = bname;
                mp.remove(val);
                mp.remove(b - val);
            } else if (mp.containsKey(a - val)) {
                res[mp.get(val)] = res[mp.get(a - val)] = aname;
                mp.remove(val);
                mp.remove(a - val);
            } else {
                break;
            }
        }
        if (mp.size() > 0) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n; ++i) {
                if (i > 0) out.print(" ");
                out.print(res[i]);
            }
            out.println();
        }
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
        // InputMismatchException -> UnknownError
        if (numChars == -1)
            throw new UnknownError();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new UnknownError();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        } else if (c == '+') {
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}

