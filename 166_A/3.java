
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt() - 1;
        Point[] A = new Point[n];
        for (int i = 0; i < n; i++)
            A[i] = new Point(in.nextInt(), in.nextInt());
        Arrays.sort(A, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if (o1.x != o2.x)
                    return o2.x - o1.x;
                if (o1.y != o2.y)
                    return o1.y - o2.y;
                return 0;
            }
        });
        int i = k;
        int j = k;
        while (i >= 0 && A[i].x == A[k].x && A[i].y == A[k].y)
            i--;
        while (j < n && A[j].x == A[k].x && A[j].y == A[k].y)
            j++;
        System.out.println(j - i - 1);
    }
}
