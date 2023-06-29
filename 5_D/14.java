
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author madis
 */
public class Rules {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextInt();
        double v = in.nextInt();
        double l = in.nextInt();
        double d = in.nextInt();
        double w = in.nextInt();

        if (v <= w) {
            double t = v / a;
            if (0.5 * t * t * a > l) {
                t = Math.sqrt(2 * l / a);
            } else {
                t += (l - 0.5 * t * t * a) / v;
            }
            System.out.printf("%.5f", t);

        } else {
            double total = 0.0;
            double t = v / a;
            double t2 = (v - w) / a;
            double tempt = Math.sqrt(2.0 * d / a);
            if (tempt * a <= w) {
                total += tempt;
                w = tempt*a;
            } else if (0.5 * t * t * a +v*t2 - 0.5 * t2 * t2 * a > d) {
                double as = 2.0*a;
                double bs = 4.0*w;
                double cs = ((w * w) / (a) - 2.0 * d );

                double delta = bs * bs - 4.0 * as * cs;
                double root = (-bs + Math.sqrt(delta)) / (2.0 * as);
                if (root < 0.0) {
                    root = (-bs - Math.sqrt(delta)) / (2.0 * as);
                }
                total += (2.0 * root + w / a);
            } else {
                total += t + t2;
                double smd = (d - 0.5 * t * t * a - v*t2 + 0.5 * t2 * t2 * a) / v;
                total += smd;
            }
            double t3 = (v - w) / a;
            if (w * t3 + 0.5 * t3 * t3 * a > l - d) {
                double as = 0.5 * a;
                double bs = w;
                double cs = d - l;

                double delta = bs * bs - 4.0 * as * cs;
                double root = (-bs + Math.sqrt(delta)) / (2.0 * as);
                if (root < 0.0) {
                    root = (-bs - Math.sqrt(delta)) / (2.0 * as);
                }
                total += root;
            } else {
                total += t3;
                double t4 = (l - (w * t3 + 0.5 * t3 * t3 * a) - d) / v;
                total += t4;
            }
            System.out.printf("%.5f", total);
        }
    }
}
