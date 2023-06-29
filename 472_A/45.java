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
 * @author bdepwgjqet
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		A solver = new A();
		solver.solve(1, in, out);
		out.close();
	}
}

class A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int number = in.nextInt();
        if((number & 1) == 0) {
            out.println(4+" "+(number-4));
        } else {
            out.println(9+" "+(number-9));
        }
    }
}

class InputReader {

    private final BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer;

    public InputReader(InputStream in) {
        bufferedReader = new BufferedReader(new InputStreamReader(in));
        stringTokenizer = null;
    }

    public String nextLine() {
        try {
            return bufferedReader.readLine();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String nextBlock() {
        while(stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(nextLine());
        }
        return stringTokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(nextBlock());
    }

    public double nextDouble() {
        return Double.parseDouble(nextBlock());
    }

    public long nextLong() {
        return Long.parseLong(nextBlock());
    }
}

