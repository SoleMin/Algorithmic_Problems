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
    public void solve(int testNumber, InputStreamReader inSt, PrintWriter out) {
        InputReader in = new InputReader(inSt);
        long a = in.nextLong();
        long b = in.nextLong();

        long result = 0;
        while (b != 1) {
            result += a / b;
            long r = a % b;
            long q = b;
            long top = q % r;
            long bottom = r;
            result += q / r;
            a = top;
            b = bottom;
        }
        result += a;

        out.println(result);
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

