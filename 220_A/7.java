import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCount = 1;
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
}

class Task {
    int n;
    int[] a;
    int[] b;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.readInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = b[i] = in.readInt();
        sort(0, n - 1);
        int different = 0;
        for (int i = 0; i < n; ++i)
            if (a[i] != b[i])
                ++different;
        out.println(different <= 2 ? "YES" : "NO");
    }

    public void sort(int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            sort(lo, mid);
            sort(mid + 1, hi);
            merge(lo, mid, hi);
        }
    }

    public void merge(int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - (mid + 1) + 1;
        int[] x = new int[n1 + 1];
        int[] y = new int[n2 + 1];
        for (int i = 0; i < n1; ++i)
            x[i] = b[lo + i];
        for (int j = 0; j < n2; ++j)
            y[j] = b[mid + 1 + j];
        x[n1] = y[n2] = Integer.MAX_VALUE;
        for (int k = lo, i = 0, j = 0; k <= hi; ++k)
            b[k] = x[i] < y[j] ? x[i++] : y[j++];
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

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
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

    public Long readLong() {
        return Long.parseLong(readString());
    }

    public Double readDouble() {
        return Double.parseDouble(readString());
    }

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}