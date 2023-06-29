import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class ProblemD {
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String[] data = s.readLine().split(" ");
		double a = Double.valueOf(data[0]);
		double v = Double.valueOf(data[1]);
		
		String[] line = s.readLine().split(" ");
		double l = Double.valueOf(line[0]);
		double d = Double.valueOf(line[1]);
		double w = Double.valueOf(line[2]);

		double ans = solve(a, v, l, d, w);
		out.println(String.format("%.07f", ans));
		
		out.flush();
	}

	private static double solve(double a, double v, double l, double d, double w) {
		double maxSpeedAtD = Math.sqrt(2 * d / a) * a;
		if (v <= w || maxSpeedAtD <= w) {
			// okay. just go
			double maxSpeedAtL = Math.sqrt(2 * l / a) *  a;
			if (maxSpeedAtL <= v) {
				return Math.sqrt(2 * l / a);
			} else {
				double timeToMaxSpeed = v / a;
				double leftDist = l - 0.5 * a * timeToMaxSpeed * timeToMaxSpeed;
				return timeToMaxSpeed + leftDist / v;
			}
		}
		
		double time = 0.0d;
		double maxSpeedTime = Math.sqrt((d / a) + (w * w / (2 * a * a)));
		double maxSpeed = maxSpeedTime * a;
		if (maxSpeed <= v) {
			time = maxSpeedTime + (a * maxSpeedTime - w) / a;
		} else {
			double vtime = (2 * a * d + w * w - 2 * v * v) / (2 * a * v);
			time = v / a + vtime + (v - w) / a;
		}
		
		// after that, just go.
		double timeToV = (v - w) / a;
		double timeToVLen = timeToV * w + 0.5 * timeToV * (v - w);
		if (timeToVLen <= l - d) {
			double leftLen = l - d - timeToVLen;
			time += timeToV + leftLen / v;
		} else {
			time += (-w + Math.sqrt(w*w + a * (2 * l - 2 * d))) / a;
		}
		return time;
	}

	public static void debug(Object... os){
		System.err.println(Arrays.deepToString(os));
	}
}