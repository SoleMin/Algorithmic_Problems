import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean[][] map;
    public static int[] color;

    public static boolean color(int id, int toFill) {
        if (color[id] == Integer.MAX_VALUE) {
            boolean check = true;
            color[id] = toFill;
            for (int i = 0; i < map.length && check; i++) {
                if (map[id][i]) {
                    check = color(i, 1 - toFill);
                }
            }
            return check;
        } else if (color[id] != toFill) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int l = sc.nextInt();
            map = new boolean[n][n];
            color = new int[n];
            Arrays.fill(color, Integer.MAX_VALUE);

            for (int i = 0; i < l; i++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                if (src != dest) {
                    map[src][dest] = true;
                    map[dest][src] = true;
                }
            }

            if (color(0, 0)) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }
        }
    }
}