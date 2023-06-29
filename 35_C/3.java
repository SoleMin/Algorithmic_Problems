import java.util.LinkedList;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Collection;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Queue;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author nasko
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
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int[][] dist = new int[N+1][M+1];
        for(int[] ini : dist) Arrays.fill(ini,1 << 30);
        int best = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int k = 0; k < K; ++k) {
            int x = in.nextInt();
            int y = in.nextInt();
            dist[x][y] = 0;
            q.offer(x);
            q.offer(y);

        }

        int[] dx = new int[] { 1,-1,0,0 };
        int[] dy = new int[] {0,0,1,-1};

        while(!q.isEmpty()) {

            int a = q.poll();
            int b = q.poll();
            for(int r = 0; r < 4; ++r) {
                int x = a + dx[r];
                int y = b + dy[r];
                if(x >= 1 && x <= N && y >=1 && y <= M && dist[x][y] > dist[a][b] + 1) {
                    dist[x][y] = dist[a][b] + 1;

                    q.offer(x);
                    q.offer(y);
                }
            }
        }
        for(int i = 1; i <= N; ++i)
            for(int j = 1; j <= M; ++j) best = Math.max(best,dist[i][j]);
        for(int a = 1; a <= N; ++a)
            for(int b = 1; b <= M; ++b) if(dist[a][b] == best) {
                result.add(a);
                result.add(b);
            }

        if(result.size() > 0) {
            out.print(result.get(0) + " " + result.get(1));
        }

        out.println();

    }

}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

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

