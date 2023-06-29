import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        IntStream.range(0, 1).forEach(tc -> {
            new Solver(tc, in, out).solve();
            out.flush();
        });
        out.close();
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    InputReader(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.valueOf(next());
    }

    double nextDouble() {
        return Double.valueOf(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Solver {
    private InputReader in;
    private PrintWriter out;
    private Integer tc;

    Solver(Integer tc, InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
        this.tc = tc;
    }

    void solve() {
        Integer n = in.nextInt();
        TreeSet<Integer> list = IntStream.range(0, n)
                .map(i -> in.nextInt())
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));

        Integer answer = 0;
        while (!list.isEmpty()) {
            Integer x = list.pollFirst();
            list = list.stream().filter(y -> y % x != 0).collect(Collectors.toCollection(TreeSet::new));
            answer++;
        }

        out.println(answer);
    }
}
