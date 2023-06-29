import java.io.*;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter("output.txt");

        String[] raw = in.readLine().split(" ");
        int n = Integer.parseInt(raw[0]);
        int m = Integer.parseInt(raw[1]);

        int k = Integer.parseInt(in.readLine());

        raw = in.readLine().split(" ");

        boolean[][] map = new boolean[n][m];
        LinkedList<Point> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            Point fireStarter = new Point(Integer.parseInt(raw[i * 2]) - 1, Integer.parseInt(raw[i * 2 + 1]) - 1);

            queue.addLast(fireStarter);
        }

        int treesLeft = n * m;

        while (true) {
            Point firepoint = queue.removeFirst();

            if (map[firepoint.x][firepoint.y])
                continue;

            treesLeft--;
            map[firepoint.x][firepoint.y] = true;

            if (treesLeft == 0) {
                out.printf("%d %d", firepoint.x + 1, firepoint.y + 1);
                out.flush();
                return;
            }

            if (firepoint.x > 0 && !map[firepoint.x - 1][firepoint.y])
                queue.add(new Point(firepoint.x - 1, firepoint.y));

            if (firepoint.y > 0 && !map[firepoint.x][firepoint.y - 1])
                queue.add(new Point(firepoint.x, firepoint.y - 1));

            if (firepoint.x < n - 1 && !map[firepoint.x + 1][firepoint.y])
                queue.add(new Point(firepoint.x + 1, firepoint.y));

            if (firepoint.y < m - 1 && !map[firepoint.x][firepoint.y + 1])
                queue.add(new Point(firepoint.x, firepoint.y + 1));

//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.printf("%d ", map[i][j] ? 1 : 0);
//                }
//                System.out.println();
//            }
//            System.out.println("\n-------\n");
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
