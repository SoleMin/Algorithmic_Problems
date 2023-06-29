import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author George Marcus
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
    ArrayList<Integer>[] G;
    int[] st, dr;
    boolean[] v;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int N = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] A = new int[N];
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            map.put(A[i], i);
        }
        G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int val = a - A[i];
            if (map.containsKey(val)) {
                int p = map.get(val);
//                if (p != i) {
                    G[i].add(p);
                    G[p].add(i);
//                }
            }
            val = b - A[i];
            if (map.containsKey(val)) {
                int p = map.get(val);
//                if (p != i) {
                    G[i].add(p);
                    G[p].add(i);
//                }
            }
        }

        st = new int[N];
        dr = new int[N];
        Arrays.fill(st, -1);
        Arrays.fill(dr, -1);
        v = new boolean[N];

        boolean ok = true;
        int match = 0;
        while (ok) {
            ok = false;
            Arrays.fill(v, false);
            for (int i = 0; i < N; i++) {
                if (dr[i] == -1) {
                    if (pairup(i)) {
                        ok = true;
                        match++;
                    }
                }
            }
        }

        if (match == N) {
            out.println("YES");
            for (int i = 0; i < N; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                int other = dr[i];
                if (A[i] == b - A[other]) {
                    out.print(1);
                }
                else {
                    out.print(0);
                }
            }
        }
        else {
            out.println("NO");
        }
    }

    private boolean pairup(int node) {
        if (v[node]) {
            return false;
        }
        v[node] = true;
        for (int x : G[node]) {
            if (st[x] == -1) {
                st[x] = node;
                dr[node] = x;
                return true;
            }
        }
        for (int x : G[node]) {
            if (pairup(st[x])) {
                st[x] = node;
                dr[node] = x;
                return true;
            }
        }
        return false;
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

    public int nextInt() {
        return Integer.parseInt(nextString());
    }

    public String nextString() {
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

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

}

