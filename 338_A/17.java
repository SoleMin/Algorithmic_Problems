import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputStreamReader in = new InputStreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {

    int MOD = 1000000009;

    public void solve(int testNumber, InputStreamReader inSt, PrintWriter out) {
        InputReader in = new InputReader(inSt);
        long n = in.nextInt();
        long m = in.nextInt();
        long k = in.nextInt();

        long t = find(n, m, k);

        long twoPow = binPow(2, (int) t);
        twoPow--;

        long result = (2 * (k * twoPow % MOD)) % MOD;

        result += (m - t * k);
        result = result % MOD;

        out.println(result);
    }

    int binPow(int a, int n) {
        if (n == 0) {
            return 1;

        }

        if (n % 2 == 1) {
            return (int) ((binPow(a, n - 1) * (a+ 0l)) % MOD);
        } else {
            int b = (binPow(a, n / 2)) % MOD;

            return (int) (((b+0l) * b) % MOD);
        }
    }


    long find(long n, long m, long k) {
        long l = 0;
        long r = m / k;
        while (l < r) {
            long mid = (l + r) / 2;

            long m1 = m - mid * k;
            long n1 = n - mid * k;


            if (isPossible(n1, m1, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    boolean isPossible(long n, long m, long k) {
        long r = m / (k - 1);
        long q = m - (k - 1) * r;

        if (q == 0) {
            return r * (k - 1) + r - 1 <= n;
        }

        return r * (k - 1) + q + r <= n;
    }

    class InputReader {
        public BufferedReader reader;
        private String[] currentArray;
        int curPointer;

        public InputReader(InputStreamReader inputStreamReader) {
            reader = new BufferedReader(inputStreamReader);
        }

        public String next() {
            try {
                currentArray = null;
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void nextChars(char[] t) {
            try {
                currentArray = null;
                reader.read(t);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public char nextChar() {
            try {
                currentArray = null;
                return (char) reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            if ((currentArray == null) || (curPointer >= currentArray.length)) {
                try {
                    currentArray = reader.readLine().split(" ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                curPointer = 0;
            }
            return Integer.parseInt(currentArray[curPointer++]);
        }

        public long nextLong() {
            if ((currentArray == null) || (curPointer >= currentArray.length)) {
                try {
                    currentArray = reader.readLine().split(" ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                curPointer = 0;
            }
            return Long.parseLong(currentArray[curPointer++]);
        }

    }
}

