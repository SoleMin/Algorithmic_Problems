import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String[] str = in.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int v = Integer.parseInt(str[1]);
        str = in.nextLine().split(" ");
        int l = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);
        int w = Integer.parseInt(str[2]);


        double minTime = 0.;
        if (w >= v) {
            minTime = getTimeAfterSign(0, v, l, a);
            out.format(Locale.US, "%.6f", minTime);
            return;
        }
        double whenGetSpeedWPath = (w * w) / (2. * a);
        if (whenGetSpeedWPath >= d) {
            double time = Math.sqrt((2.0 * d) / a);
            minTime = time + getTimeAfterSign(a * time, v, l - d, a);
        } else {
            double stopPath = (v * v - w * w) / (2. * a);
            double vMaxPath = (v * v) / (2. * a);
            if (stopPath + vMaxPath > d) {
//                double topSpeed = (Math.sqrt(2. * a * d) + w) / 2;
//                minTime = (topSpeed / a) + (topSpeed - w) / a + getTimeAfterSign(w, v, l - d, a);
                double topSpeed = Math.sqrt((2. * a * d + w * w) / 2);
                minTime = (2. * topSpeed - w) / a + getTimeAfterSign(w, v, l - d, a);
            } else {
                double stopTime = (v - w) / (a + 0.);
                double getMaxTime = v / (a + 0.);
                double maxTime = (d - (stopPath + vMaxPath)) / v;
                minTime = stopTime + getMaxTime + maxTime + getTimeAfterSign(w, v, l - d, a);
            }
        }
        out.format(Locale.US, "%.6f", minTime);

    }

    double getTimeAfterSign(double startSpeed, double maxSpeed, double path, int a) {
        double maxSpeedTime = (maxSpeed - startSpeed) / a;
        double maxSpeedPath = startSpeed * maxSpeedTime + (a * maxSpeedTime * maxSpeedTime) / 2;
        if (maxSpeedPath > path) {
            return (-startSpeed + Math.sqrt(startSpeed * startSpeed + 2 * a * path)) / a;
        } else {
            return maxSpeedTime + (path - maxSpeedPath) / maxSpeed;
        }
    }
}

