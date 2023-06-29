import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D1_958 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Point[] P = new Point[N];
        for (int n=0; n<N; n++) {
            P[n] = normalize(in.next());
        }
        Map<Point, Integer> map = new HashMap<>();
        for (Point p : P) {
            int count = map.getOrDefault(p, 0);
            count++;
            map.put(p, count);
        }
        StringBuilder output = new StringBuilder();
        for (Point p : P) {
            int count = map.get(p);
            output.append(count).append(' ');
        }
        System.out.println(output);
    }

    static Point normalize(String s) {
        int idx = s.indexOf('/');
        int down = Integer.parseInt(s.substring(idx+1));
        s = s.substring(1,idx-1);
        idx = s.indexOf('+');
        int left = Integer.parseInt(s.substring(0,idx));
        int right = Integer.parseInt(s.substring(idx+1));
        int up = left + right;
        int gcd = gcd(up, down);
        up /= gcd;
        down /= gcd;
        return new Point(up, down);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a%b);
    }

}
