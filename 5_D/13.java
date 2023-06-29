import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    static final double EPS = 1e-10;

    Parser parser;

    enum Result {
        UNDER, OVER
    }

    private void solve() throws IOException {
        this.parser = new Parser(new BufferedReader(new InputStreamReader(System.in)));
        double a = parser.nextInt();
        double vmax = parser.nextInt();
        double l = parser.nextInt();
        double d = parser.nextInt();
        double w = parser.nextInt();
        double low = 0;
        double high = 20000;
        while (Math.abs(high - low) > 1e-10) {
            double accelerateTime = (low + high) / 2;
            Result res = check(accelerateTime, a, vmax, d, w).result;
            if (res == Result.UNDER) {
                low = accelerateTime;
            } else {
                high = accelerateTime;
            }
        }
        IP ip = check(high, a, vmax, d, w);
        TV tv = tv(ip.v, l - d, a, vmax);
        PrintWriter pw = new PrintWriter(System.out);
        pw.printf("%.5f\n", ip.time + tv.time);
        pw.close();
    }

    private IP check(double accelerateTime, double a, double vmax, double d, double w) {
        DV dv = dv(0, a, accelerateTime, vmax);
        if (dv.d > d) {
            return new IP(accelerateTime, dv.v, Result.OVER);
        }
        Double slowTime = time2MakeDist(-a, dv.v, d - dv.d);
        if (slowTime == null) {
            return new IP(0, 0, Result.UNDER);
        }
        double vDown = dv.v - a * slowTime;
        if (vDown < w) {
            return new IP(0, 0, Result.UNDER);
        } else {
            return new IP(accelerateTime + slowTime, vDown, Result.OVER);
        }
    }

    static class IP {
        final double time;
        final double v;
        final Result result;

        IP(double time, double v, Result result) {
            this.time = time;
            this.v = v;
            this.result = result;
        }
    }

    static class DV {
        final double d;
        final double v;

        DV(double d, double v) {
            this.d = d;
            this.v = v;
        }
    }

    static class TV {
        final double time;
        final double v;

        TV(double time, double v) {
            this.time = time;
            this.v = v;
        }
    }

    static Double time2MakeDist(double a, double v0, double dist) {
        return quadric(a / 2, v0, -dist);
    }

    static TV tv(double v0, double d, double a, double vmax) {
        double acTime = (vmax - v0) / a;
        double unboundedTime = time2MakeDist(a, v0, d);
        if (unboundedTime > acTime) {
            double ad = dist(v0, a, acTime);
            return new TV(acTime + (d - ad) / vmax, vmax);
        } else {
            return new TV(unboundedTime, v0 + a * unboundedTime);
        }
    }

    static DV dv(double v0, double a, double time, double vmax) {
        double time2maxV = (vmax - v0) / a;
        if (time2maxV < time) {
            return new DV(dist(v0, a, time2maxV) + dist(vmax, 0, time - time2maxV), vmax);
        } else {
            return new DV(dist(v0, a, time), v0 + a * time);
        }
    }

    static double dist(double v0, double a, double time) {
        return v0 * time + a * time * time / 2;
    }

    static Double quadric(final double a, final double b, final double c) {
        double d = b * b - 4 * a * c;
        if (d < -EPS) {
            return null;
        }
        d = Math.abs(d);
        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);
        double r = Integer.MAX_VALUE;
        if (x1 > -EPS) {
            r = x1;
        }
        if (x2 > -EPS) {
            r = Math.min(r, x2);
        }
        if (r == Integer.MAX_VALUE) {
            throw new RuntimeException("BOTVA");
        }
        return r;
    }

    static class Parser {

        final BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public Parser(BufferedReader bufferedReader) {
            this.br = bufferedReader;
        }

        String nextToken() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }
    }
}
