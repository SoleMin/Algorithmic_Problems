import java.util.Map;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
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
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; ++i)
            p[i] = in.nextInt();
        Map<Integer, Integer> position = new HashMap<>(n);
        for (int i = 0; i < n; ++i)
            position.put(p[i], i);
        DisjointSet sets = new DisjointSet(n);
        for (int i = 0; i < n; ++i) {
            if (position.containsKey(a - p[i]))
                sets.joinSet(i, position.get(a - p[i]));
            if (position.containsKey(b - p[i]))
                sets.joinSet(i, position.get(b - p[i]));
        }
        Group[] groups = new Group[n];
        for (int i = 0; i < n; ++i)
            if (sets.getSet(i) == i)
                groups[i] = new Group();
        for (int i = 0; i < n; ++i)
            groups[sets.getSet(i)].value.add(p[i]);
        int[] answer = new int[n];
        for (Group group : groups) if (group != null) {
            if (group.check(a)) {
                for (int key : group.value)
                    answer[position.get(key)] = 0;
            } else if (group.check(b)) {
                for (int key : group.value)
                    answer[position.get(key)] = 1;
            } else {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
        for (int i = 0; i < n; ++i) {
            if (i > 0) out.print(' ');
            out.print(answer[i]);
        }
        out.println();
    }

    class Group {
        Set<Integer> value = new HashSet<>();

        boolean check(int sum) {
            for (int key : value)
                if (!value.contains(sum - key))
                    return false;
            return true;
        }
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens())
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

class DisjointSet {
    private final int[] label;
    private int numSets;
    private Listener listener;

    public DisjointSet(int n, Listener listener) {
        label = new int[n];
        Arrays.fill(label, -1);
        numSets = n;
        this.listener = listener;
    }

    public DisjointSet(int n) {
        this(n, null);
    }

    public int getSet(int at) {
        if (label[at] < 0) return at;
        return label[at] = getSet(label[at]);
    }

    public boolean sameSet(int u, int v) {
        return getSet(u) == getSet(v);
    }

    public boolean joinSet(int u, int v) {
        if (sameSet(u, v)) return false;
        u = getSet(u);
        v = getSet(v);
        if (label[u] < label[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        label[v] += label[u];
        label[u] = v;
        --numSets;
        if (listener != null) listener.joined(u, v);
        return true;
    }

    public static interface Listener {
        public void joined(int joinedRoot, int root);
    }
}

