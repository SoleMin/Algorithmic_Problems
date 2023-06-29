import java.io.*;
import java.util.*;


public class Main {

    static boolean used[][];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");
        n = nextInt();
        m = nextInt();
        int k = nextInt();
        used = new boolean[n][m];
        Deque<point> deq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            deq.addLast(new point(nextInt() - 1, nextInt() - 1));
            used[deq.peekLast().x][deq.peekLast().y] = true;
        }
        point last = new point(0, 0);
        while (!deq.isEmpty()) {
            point v = deq.pollFirst();
            int x = v.x;
            int y = v.y;
            if (checker(x, y + 1)) {
                last = new point(x, y + 1);
                deq.addLast(new point(x, y + 1));
                used[x][y + 1] = true;
            }
            if (checker(x, y - 1)) {
                last = new point(x, y - 1);
                deq.addLast(new point(x, y - 1));
                used[x][y - 1] = true;
            }
            if (checker(x + 1, y)) {
                last = new point(x + 1, y);
                deq.addLast(new point(x + 1, y));
                used[x + 1][y] = true;
            }
            if (checker(x - 1, y)) {
                last = new point(x - 1, y);
                deq.addLast(new point(x - 1, y));
                used[x - 1][y] = true;
            }
        }
        out.println(last.x + 1 + " " + (last.y + 1));
        out.close();
    }

    static boolean checker(int x, int y) {
        if (x < n && y < m && x >= 0 && y >= 0 && !used[x][y]) return true;
        return false;
    }


    static StringTokenizer st = new StringTokenizer("");
    static BufferedReader br;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}

class point {
    int x, y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}