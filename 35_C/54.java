import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FireAgain {
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        BufferedWriter write = new BufferedWriter(new FileWriter("output.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] v = new boolean[n][m];
        int k = sc.nextInt();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            q.add(x);
            q.add(y);
            v[x][y] = true;
        }
        int lastx = 0;
        int lasty = 0;
        while (!q.isEmpty()) {
            lastx = q.poll();
            lasty = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = lastx + dx[i];
                int c = lasty + dy[i];
                if (r >= 0 && c >= 0 && r < n && c < m && !v[r][c]) {
                    v[r][c] = true;
                    q.add(r);
                    q.add(c);
                }
            }
        }
        write.write((lastx + 1) + " " + (lasty + 1));
        write.close();
    }

}
