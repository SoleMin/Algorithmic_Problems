import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        double a = in.nextInt();
        double v = in.nextInt();
        double l = in.nextInt();
        double d = in.nextInt();
        double w = in.nextInt();

        if (w * w / (a * 2) > d || v < w) {
            if (v * v / (a * 2) > l) {
                out.println(Math.sqrt(l * 2 / a));
            }
            else {
                double t = v / a;
                double s = l - t * v / 2;
                t = t + s / v;
                out.println(t);
            }
            return;
        }
        double t = solveD(a, v, w, d);
        if ((v + w) * (v - w) / (a * 2) > l - d) {
            double dis = w * w + a * (l - d) * 2;
            double t1 = (Math.sqrt(dis) - w) / a;
            System.out.println(t + t1);
        }
        else {
            double t1 = (v - w) / a;
            double s = l - d - (v + w) * t1 / 2;
            double t2 = s / v;
            System.out.println(t + t1 + t2);
        }
    }

    public double solveD(double a, double vMax, double wBound, double s) {
        double v = Math.sqrt(a * s + wBound * wBound / 2);
        if (v > vMax) {
            v = vMax;
        }
        double t1 = v / a;
        double t2 = (v - wBound) / a;
        double s1 = v * t1 / 2;
        double s2 = (v + wBound) * t2 / 2;
        double sr = s - s1 - s2;
        double tr = sr / v;
        return t1 + t2 + tr;

    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] arg) {
        new Main().run();
    }
}
