import java.util.*;
import java.io.*;

public class Main {
    
    static final double EPS = 1E-6;
    double a, v, l, d, w, u;
    
    public void run() {
        a = cin.nextDouble();
        v = cin.nextDouble();
        l = cin.nextDouble();
        d = cin.nextDouble();
        w = cin.nextDouble();
        w = Math.min(w, v);
        double s1 = v * v / (2 * a);
        double s2 = w * w / (2 * a);
        double s3 = s1 - s2;
        
        double cost = 0;
        if (d < s2) {
            cost += Math.sqrt(2 * d / a);
            w = cost * a;
        } else if (d < s1 + s3) {
            u = Math.sqrt(d / a + w * w / (2 * a * a)) * a;
            cost = u / a + (u - w) / a;
        } else {
            cost += v / a;
            cost += (v - w) / a;
            cost += (d - s3 - s1) / v;
        }
        d = l - d;
        s3 = (v * v - w * w) / (2 * a);
        if (d < s3) {
            cost += (-w + Math.sqrt(w * w + 2 * a * d)) / a;
        } else {
            cost += (v - w) / a;
            cost += (d - s3) / v;
        }
        out.println(cost);
    }

    public static void main(String[] args) throws IOException {
        Main sloved = new Main();
        sloved.run();
        sloved.out.close();
    }

    Scanner cin = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
}
