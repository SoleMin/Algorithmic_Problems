import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] p = new int[3][2];
        p[0][0] = sc.nextInt();
        p[0][1] = sc.nextInt();
        p[1][0] = sc.nextInt();
        p[1][1] = sc.nextInt();
        p[2][0] = sc.nextInt();
        p[2][1] = sc.nextInt();
        int dx0 = Math.abs(p[0][0] - p[1][0]);
        int dx1 = Math.abs(p[1][0] - p[2][0]);
        int dx2 = Math.abs(p[2][0] - p[0][0]);
        int x_max = Math.max(Math.max(dx0, dx1), dx2);
        int dy0 = Math.abs(p[0][1] - p[1][1]);
        int dy1 = Math.abs(p[1][1] - p[2][1]);
        int dy2 = Math.abs(p[2][1] - p[0][1]);
        int y_max = Math.max(Math.max(dy0, dy1), dy2);
        int total = x_max + y_max + 1;
        System.out.println(total);
        int count = 0;
        int x = -1, y = -1;
        for (int i = 0; i < 3; i++) {
            x = p[i][0];
            y = p[i][1];
            int x1 = p[(i + 1) % 3][0], y1 = p[(i + 1) % 3][1];
            int x2 = p[(i + 2) % 3][0], y2 = p[(i + 2) % 3][1];
            do {
                if ((x - x1) * (x - x2) > 0 || (y - y1) * (y - y2) > 0) {
                    System.out.println(x + " " + y);
                    count++;
                }
                if ((x - x1) * (x - x2) > 0) {
                    x += (x - x1 > 0) ? -1 : +1;
                } else if ((y - y1) * (y - y2) > 0) {
                    y += (y - y1 > 0) ? -1 : +1;
                } else {
                    break;
                }
            } while (true);
        }
        if (count < total) {
            System.out.println(x + " " + y);
        }
    }
}

		  					       	   	  			 			