

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt() * 2;
        Point[] A = new Point[n];
        for (int i = 0; i < n; i++) {
            int center = in.nextInt() * 2;
            int side = in.nextInt();
            A[i] = new Point(center - side, center + side);
        }
        Arrays.sort(A, new Comparator<Point>() {
            public int compare(Point x, Point y) {
                return x.x - y.x;
            }
        });
        int ans = 2;
        for (int i = 1; i < n; i++) {
            if (A[i].x - A[i - 1].y > t)
                ans += 2;
            else if (A[i].x - A[i - 1].y == t)
                ans++;
        }
        System.out.println(ans);
    }
}
