import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Main {
    private static final double EPS = 1e-11;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    
    void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        
        double a = nextDouble();
        double v = nextDouble();
        double l = nextDouble();
        double d = nextDouble();
        double w = nextDouble();
        
        double ans = 0.0;
        
        if (v < w + EPS || sqr(w) / 2 / a > d - EPS) {
            double t1 = sqrt(2 * l / a);
            double t2 = v / a;
            
            if (t1 < t2 + EPS) {
                ans = t1;
            } else {
                ans = t2 + (l - a * sqr(t2) / 2) / v;
            }
        } else {
            double t1 = v / a;
            double t2 = (v - w) / a;
            double s12 = a * sqr(t1) / 2 + w * t2 + a * sqr(t2) / 2;
            
            if (s12 < d + EPS) {
                ans += t1 + t2 + (d - s12) / v;
            } else {
                double ta = sqrt(d / a + sqr(w / a) / 2);
                double tb = ta - w / a;
                ans += ta + tb;
            }
            
            double r = l - d;
            double tm = (v - w) / a;
            double tx = (sqrt(sqr(w) + 2 * a * r) - w) / a;
            
            if (tx < tm + EPS) {
                ans += tx;
            } else {
                ans += tm + (r - w * tm - a * sqr(tm) / 2) / v;
            }
        }           
        
        out.printf(Locale.US, "%.12f%n", ans);
        out.close();
    }
    
    double sqr(double x) { 
        return x * x;
    }
    
    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        
        return st.nextToken();
    }
    
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}
