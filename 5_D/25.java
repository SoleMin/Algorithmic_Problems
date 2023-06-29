import java.util.*;
import java.io.*;

public class D0005 {

    public static void main(String args[]) throws Exception {
        new D0005();
    }

    D0005() throws Exception {
        PandaScanner sc = null;
        PrintWriter out = null;
        try {
            sc = new PandaScanner(System.in);
            out = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }

        a = sc.nextInt();
        max = sc.nextInt();

        double length = sc.nextInt();
        double dist = sc.nextInt();
        double limit = sc.nextInt();

        if (max <= limit) {
            out.println(travelTime(length, 0));
        }
        else {
            double tLimit = limit / a;
            double dLimit = distance(0, tLimit);
            if (dLimit >= dist) {
                out.println(travelTime(length, 0));
            }
            else {
                double res = tLimit + 2 * (travelTime(0.5 * (dist - dLimit), limit)) +
                        travelTime(length - dist, limit);
                out.println(res);
            }
        }

        out.close();
        System.exit(0);
    }
    double a, max;
    double distance(double v, double t) {
        return v * t + 0.5 * a * t * t;
    }
    double travelTime(double d, double v) {
        double tAll = (-v + Math.sqrt(v * v + 2 * a * d)) / a;
        double tMax = (max - v) / a;
        if (tAll <= tMax) {
            return tAll;
        }
        else {
            return tMax + (d - distance(v, tMax)) / max;
        }
    }

    //The PandaScanner class, for Panda fast scanning!
    public class PandaScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream in;

        PandaScanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(this.in = in));
        }

        public String next() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
                return next();
            }
            return st.nextToken();
        }

        public boolean hasNext() throws Exception {
            return (st != null && st.hasMoreTokens()) || in.available() > 0;
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
