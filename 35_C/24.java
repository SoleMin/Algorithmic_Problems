import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Zyflair Griffane
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("input.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("output.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		PandaScanner in = new PandaScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		C solver = new C();
		solver.solve(1, in, out);
		out.close();
	}
}

class C {
    final int dx[] = { -1, 0, 1, 0};
    final int dy[] = { 0, -1, 0, 1};
    final int SHIFT = 15;
    final int COLUMN_MASK = (1 << SHIFT) - 1;
    public void solve(int testNumber, PandaScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        boolean burning[][] = new boolean[n][m];
        int k = in.nextInt();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            burning[x][y] = true;
            q.add((x << SHIFT) + y);
        }
        int last = 0;
        while (!q.isEmpty()) {
            last = q.poll();
            int x = last >> SHIFT;
            int y = last & COLUMN_MASK;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !burning[nx][ny]) {
                    burning[nx][ny] = true;
                    q.add((nx << SHIFT) + ny);
                }
            }
        }
        out.printf("%d %d\n", (last >> SHIFT) + 1, (last & COLUMN_MASK) + 1);
    }
}

class PandaScanner {
    public BufferedReader br;
    public StringTokenizer st;
    public InputStream in;

    public PandaScanner(InputStream in) {
        br = new BufferedReader(new InputStreamReader(this.in = in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        }
        catch (Exception e) {
            return null;
        }
    }

    public String next() {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(nextLine().trim());
            return next();
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    }

