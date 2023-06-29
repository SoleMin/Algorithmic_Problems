/**
 * Created by IntelliJ IDEA.
 * User: Taras_Brzezinsky
 * Date: 9/16/11
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */



import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskC extends Thread {
    public TaskC() {
        try {
            this.input = new BufferedReader(new FileReader("input.txt"));
            this.output = new PrintWriter("output.txt");
            this.setPriority(Thread.MAX_PRIORITY);
        } catch (Throwable e) {
            System.exit(666);
        }
    }

    private void solve() throws Throwable {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        Queue<Integer> qX = new ArrayDeque<Integer>();
        Queue<Integer> qY = new ArrayDeque<Integer>();
        boolean [][]was = new boolean[n][m];
        for (int i = 0; i < k; ++i) {
            int x = nextInt() - 1, y = nextInt() - 1;
            qX.add(x);
            qY.add(y);
            was[x][y] = true;
        }
        int lastX = -1, lastY = -1;
        while (!qX.isEmpty()) {
            lastX = qX.poll();
            lastY = qY.poll();
            for (int i = 0; i < dx.length; ++i) {
                int nextX = lastX + dx[i], nextY = lastY + dy[i];
                if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0 && !was[nextX][nextY]) {
                    qX.add(nextX);
                    qY.add(nextY);
                    was[nextX][nextY] = true;
                }
            }
        }
        ++lastX;
        ++lastY;
        output.println(lastX + " " + lastY);



    }

    public void run() {
        try {
            solve();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(666);
        } finally {
            output.flush();
            output.close();
        }
    }

    public static void main(String[] args) {
        new TaskC().start();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private String nextToken() throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            tokens = new StringTokenizer(input.readLine());
        }
        return tokens.nextToken();
    }
    static final int PRIME = 3119;
    static final int[]dx = {1, -1, 0, 0}, dy = {0, 0, -1, 1};
    private BufferedReader input;
    private PrintWriter output;
    private StringTokenizer tokens = null;
}
