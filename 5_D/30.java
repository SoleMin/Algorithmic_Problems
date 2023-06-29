
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double v = in.nextDouble();
        double l = in.nextDouble();
        double d = in.nextDouble();
        double w = in.nextDouble();
        double ans = 0;
        double maxSpeedBySign = Math.sqrt(2 * a * d);
        double speedAtSign = -1;
        if (v <= w) {
            if (maxSpeedBySign <= v) {
                ans += Math.sqrt(2 * d / a);
                speedAtSign = maxSpeedBySign;

            } else {
                ans += v / a;
                double distanceLeftTillSign = d - v * v / a / 2;
                ans += distanceLeftTillSign / v;
                speedAtSign = v;
            }
        } else {
            if (maxSpeedBySign <= w) {
                ans += Math.sqrt(2 * d / a);
                speedAtSign = maxSpeedBySign;
            } else {
                double S = d / 2 - w * w / 4 / a;
                double X = d - S;
                double speed = Math.sqrt(2 * a * X);
                if (speed <= v) {
                    ans += Math.sqrt(2 * X / a);
                    ans += (speed - w) / a;
                    speedAtSign = w;
                } else {
                    double distanceToAc = v * v / a / 2;
                    double distanceToDe = (v * v - w * w) / a / 2;
                    ans += Math.sqrt(2 * distanceToAc / a);
                    ans += (d - distanceToAc - distanceToDe) / v;
                    ans += (v - w) / a;
                }
                speedAtSign = w;
            }
        }
        l -= d;
        double timeToGetMaxSpeed = (v - speedAtSign) / a;
        double timeToReachEnd = (-2 * speedAtSign + Math.sqrt(4 * speedAtSign
                * speedAtSign + 8 * a * l))
                / 2 / a;
        if (timeToGetMaxSpeed < timeToReachEnd) {
            ans += timeToGetMaxSpeed;
            double distanceCoveredToMaxSpeed = speedAtSign * timeToGetMaxSpeed
                    + 0.5 * a * timeToGetMaxSpeed * timeToGetMaxSpeed;
            l -= distanceCoveredToMaxSpeed;
            ans += l / v;
        } else {
            ans += timeToReachEnd;
        }
        System.out.println(ans);
    }
}
