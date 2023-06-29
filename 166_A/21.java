import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class P166A {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Point[] P = new Point[n];
        for(int i=0; i<n; i++)
            P[i] = new Point(in.nextInt(), in.nextInt());
        Arrays.sort(P, new Comparator<Point>() {
            public int compare(Point A, Point B) {
                if(A.x != B.x) return B.x-A.x;
                return A.y - B.y;
            }
        });
        int cnt = 0;
        Point ans = P[k-1];
        for(int i=0; i<n; i++) {
            if(P[i].x == ans.x && P[i].y==ans.y)
                cnt++;
        }
        System.out.println(cnt);
    }
}
