import java.util.Map;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Hamed Valizadeh (havaliza@gmail.com)
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastInputReader in = new FastInputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    int n, a, b;
    Map<Integer, Integer> position;
    int[] p;
    int[] group;

    public void solve(int testNumber, FastInputReader in, PrintWriter out) {
        n = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();

        position = new TreeMap<Integer, Integer>();
        p = new int[n];
        group = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
            group[i] = -1;
            position.put(p[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (getMate(i) != -1)
                continue;
            out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean aMate = position.containsKey(a - p[i]);
            boolean bMate = position.containsKey(b - p[i]);
            if (aMate && bMate)
                continue;
            if (group[i] != -1)
                continue;
            if (!solve(i)) {
                out.println("NO");
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (group[i] != -1)
                continue;
            if (!solve(i)) {
                out.println("NO");
                return;
            }
        }

        out.println("YES");
        for (int i = 0; i < n; i++) {
            out.print(group[i]);
            out.print(" ");
        }
        out.println();
    }

    private boolean solve(int index) {
        int mate = getMate(index);
        if (mate == -1)
            return false;
        assign(index, mate);
        if (getMate(index) != -1)
            return solve(getMate(index));
        else
            return getMate(mate) == -1 || solve(getMate(mate));
    }

    private void assign(int index, int mate) {
        int sum = p[index] + p[mate];
        if (sum == a) {
            group[index] = group[mate] = 0;
            return;
        }
        if (sum == b) {
            group[index] = group[mate] = 1;
            return;
        }
        throw new RuntimeException("Wrong assignment :(");
    }

    private int getMate(int index) {
        int[] possibleMates = new int[] {a - p[index], b - p[index]};
        for (int mate: possibleMates) {
            if (position.containsKey(mate)) {
                int mateIndex = position.get(mate);
                if (group[mateIndex] == -1)
                    return mateIndex;
            }
        }
        return -1;
    }
}

class FastInputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public FastInputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

