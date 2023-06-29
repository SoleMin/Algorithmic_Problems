import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n, r;
        n = scan.nextInt();
        r = scan.nextInt();

        int[] locs = new int[n];

        for (int i = 0; i < n; i++) {
            locs[i] = scan.nextInt();
        }

        double[] yPos = new double[n];
        Arrays.fill(yPos, 10e100);

        yPos[0] = r;
        for (int i = 1; i < n; i++) {
            double pos = r;
            for (int j = 0; j < i; j++) {
                int xDist = Math.abs(locs[i] - locs[j]);
                if (xDist <= 2 * r) {
                    double y = (2.0 * r) * (2.0 * r) - (xDist * xDist);
                    if (Math.abs(y - 0.0) < 0.0000000001) {
                        y = 0;
                    } else {
                        y = Math.sqrt(y);
                    }
                    y += yPos[j];
                    pos = Math.max(pos, y);

                } else {
                    continue;
                }
            }
            yPos[i] = pos;
        }
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = "" + yPos[i];
        }

        System.out.println(String.join(" ", ans));

    }
}