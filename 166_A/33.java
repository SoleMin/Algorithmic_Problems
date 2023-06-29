import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nova
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {

    class Team implements Comparable<Team> {
        int solved = 0;
        int penalty = 0;

        Team(int solved, int penalty) {
            this.solved = solved;
            this.penalty = penalty;
        }

        public int compareTo(Team o) {
            return this.solved == o.solved ? this.penalty - o.penalty : -(this.solved - o.solved);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Team) {
                Team o = (Team) obj;
                return ((this.solved == o.solved) && (this.penalty == o.penalty));
            }
            return false;
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        Team[] teams = new Team[n];
        for (int i = 0; i < n; i++)
            teams[i] = new Team(in.nextInt(), in.nextInt());
        Arrays.sort(teams);

        int[] top = new int[n];
        int[] map = new int[n];
        int cur = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || !teams[i].equals(teams[i - 1])) cur = i;
            top[cur]++;
            map[i] = cur;
        }
        out.println(top[map[k - 1]]);
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    }

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(outputStream);
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}

