

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class C {
    static class Struct {
        int x, y, count;

        public Struct(int xx, int yy, int c) {
            x = xx;
            y = yy;
            count = c;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
        FileWriter fw=new FileWriter("output.txt");
        boolean[][] grid = new boolean[n][m];
        int[] dx = new int[] { 1, 0, -1, 0 };
        int[] dy = new int[] { 0, -1, 0, 1 };
        int k = sc.nextInt();
        LinkedList<Struct> a = new LinkedList<Struct>();
        for (int i = 0; i < k; i++) {
            a.add(new Struct(sc.nextInt() - 1, sc.nextInt() - 1, 0));
        }
        int max = Integer.MIN_VALUE, maxX = -1, maxY = -1;
        while (!a.isEmpty()) {
            Struct tmp = a.remove();
            if (grid[tmp.x][tmp.y] == true)
                continue;
            grid[tmp.x][tmp.y] = true;
            if (tmp.count > max) {
                max = tmp.count;
                maxX = tmp.x;
                maxY = tmp.y;
            }
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0) {
                    if (grid[nx][ny] == false) {
                        a.add(new Struct(nx, ny, tmp.count + 1));
                    }
                }
            }
        }
        fw.write((maxX + 1) + " " + (maxY + 1)+"\n");
        System.out.println((maxX + 1) + " " + (maxY + 1));
        fw.flush();
    }
}
