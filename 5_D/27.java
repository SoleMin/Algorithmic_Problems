import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class Main implements Runnable {

    static Throwable sError;

    public static void main(String[] args) throws Throwable {
        Thread t = new Thread(new Main());
        t.start();
        t.join();
        if (sError != null)
            throw sError;
    }

    PrintWriter pw;
    BufferedReader in;
    StringTokenizer st;

    void initStreams() throws FileNotFoundException,
            UnsupportedEncodingException {
        pw = new PrintWriter(System.out);
        if (System.getProperty("ONLINE_JUDGE") == null) {
            System.setIn(new FileInputStream("1"));
        }
        in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-9"));
    }

    String nextString() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextString());
    }

    double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextString());
    }

    public void run() {
        try {
            initStreams();
            double a = nextDouble(), vmax = nextDouble(), l = nextDouble(), d = nextDouble(), w = nextDouble();
            if (vmax <= w) {
                double v = Math.sqrt(2 * a * l);
                if (v <= vmax) {
                    out(v / a);
                } else {
                    double s = vmax * vmax / (2 * a);
                    double t = (l - s) / vmax;
                    out(vmax / a + t);
                }
            } else {
                double v = Math.sqrt(a * d + w * w / 2);
                double t1 = 0;
                if (w <= Math.sqrt(2 * a * d)) {
                    if (v <= vmax) {
                        t1 = v / a + (v - w) / a;
                    } else {
                        double s = d - vmax * vmax / (2 * a) - (vmax * vmax - w * w) / (2 * a);
                        t1 = s / vmax + vmax / a + (vmax - w) / a;
                    }   
                } else {
                    t1 = Math.sqrt(2 * d / a);
                    w = a * t1;
                }
                v = Math.sqrt(2 * a * (l - d) + w * w);
                double t2 = 0;
                if (v <= vmax) {
                    t2 = (v - w) / a;
                } else {
                    double s = l - d - (vmax * vmax - w * w) / (2 * a);
                    t2 = (vmax - w) / a + s / vmax;
                }
                out(t1 + t2);
            }
        } catch (Throwable e) {
            sError = e;
        } finally {
            pw.flush();
            pw.close();
        }
    }

    private void out(double t) {
        pw.println(t);
    }

}
