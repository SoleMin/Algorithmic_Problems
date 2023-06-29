import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author AlexFetisov
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
        long n = in.nextInt();
        long x = in.nextInt();
        long y = in.nextInt();
        long c = in.nextInt();
        if (c == 1) {
            out.println(0);
            return;
        }

        long left = 1, right = 2 * n, middle, res = -1;
        long val = getNumberOfCells(x, y, n, 2);

        while (left <= right) {
            middle = (left + right) / 2;
            long numberOfCells = getNumberOfCells(x, y, n, middle);
            if (numberOfCells < c) {
                left = middle + 1;
            } else {
                res = middle;
                right = middle - 1;
            }
        }
        out.println(res);
    }

    private long getNumberOfCells(long x, long y, long n, long middle) {
        long res = 0;
        res += calc(x, y, middle + 1);
        res += calc(n - x + 1, y, middle + 1);
        res += calc(x, n - y + 1, middle + 1);
        res += calc(n - x + 1, n - y + 1, middle + 1);
        res -= calcX(x, n, middle);
        res -= calcX(y, n, middle);
        --res;
        return res;
    }

    private long calcX(long x, long n, long size) {
        long left = x - size;
        long right = x + size;
        left = Math.max(left, 1);
        right = Math.min(right, n);
        if (left <= right) {
            return right - left + 1;
        }
        return 0;
    }

    private long calc(long x, long y, long size) {
        if (size <= Math.min(x, y)) {
            return (1 + size) * size / 2;
        }
        if (size >= x + y - 1) {
            return x * y;
        }
        if (size > Math.max(x, y)) {
            return x * y - calc(x, y, x + y - 1 - size);
        }
        long min = Math.min(x, y);
        long res = (1 + min) * min / 2;
        long rest = size - min;
        res += rest * min;
        return res;
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer stt;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public String nextString() {
        while (stt == null || !stt.hasMoreTokens()) {
            stt = new StringTokenizer(nextLine());
        }
        return stt.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

}

