import java.util.*;
import static java.lang.Math.*;

public final class FollowTrafficRules {
    private static double[] acce(double i, double a, double v) {
        double[] r = new double[2];
        r[0] = (v - i)/a;
        r[1] = 1d/2d * a * pow(r[0], 2) + i * r[0];
        return r;
    }

    private static double solve(double i, double a, double l) {
        double e = sqrt(pow(i, 2) + 2d * a * l);
        e = a > 0 ? e : -1d * e;
        return (e - i)/a;
    }

    private static double time(double i, double a, double v, double l) {
        double[] r = acce(i, a, v);
        if (r[1] >= l) return solve(i, a, l);
        return r[0] + (l - r[1])/v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double v = sc.nextDouble();
        double l = sc.nextDouble();
        double d = sc.nextDouble();
        double w = sc.nextDouble();

        double t = 0d;
        if (v <= w) t = time(0, a, v, l);
        else {
            double[] r = acce(0, a, w);
            if (r[1] >= d) t = time(0, a, v, l);
            else {
                t += r[0];
                t += 2d * time(w, a, v, (d - r[1])/2d);
                t += time(w, a, v, l - d);
            }
        }

        System.out.println(t);
    }
}
