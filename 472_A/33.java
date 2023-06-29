import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Anirudh Rayabharam (anirudhrb@yandex.com)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        if (n % 2 == 0) {
            out.println("4 " + (n - 4));
        } else {
            out.println("9 " + (n - 9));
        }
    }
}

class InputReader {
    public BufferedReader reader;
    private int tokenCount, nextTokenIndex;
    private String[] tokens;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenCount = nextTokenIndex = 0;
    }

    public String next() {
        String nextLine;
        if (nextTokenIndex == tokenCount) {
            try {
                nextLine = reader.readLine();
                nextTokenIndex = 0;
                tokens = nextLine.split("\\s");
                tokenCount = tokens.length;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return tokens[nextTokenIndex++];
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

