import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class D5 {
    
    static StringTokenizer st;
    static BufferedReader in;
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        double a = nextInt();
        double v = nextInt();
        double L = nextInt();
        double d = nextInt();
        double w = nextInt();
        double ans = 0;
        if (w >= v)
            ans = go(0, a, L, v);
        else {
            ans = go(Math.min(w, Math.sqrt(2*a*d)), a, L-d, v);
            if (2*a*d < w*w)
                ans += Math.sqrt(2*d/a);
            else {
                if (d-v*v/(2*a) >= (v*v-w*w)/(2*a))
                    ans += v/a+(v-w)/a+(d-v*v/(2*a)-(v*v-w*w)/(2*a))/v;
                else {
                    double x = Math.sqrt((w*w+2*a*d)/2);
                    ans += x/a+(x-w)/a;
                }
            }
        }
        System.out.println(ans);
        pw.close();
    }
    
    private static double go(double v0, double a, double s, double vmax) {
        double t = (vmax-v0) / a;
        if (v0*t+a*t*t/2 < s)
            return t+(s-v0*t-a*t*t/2) / vmax;
        else {
            double D = v0*v0+2*a*s;
            return (-v0+Math.sqrt(D))/a;
        }
    }
    
    private static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }
    
    private static long nextLong() throws IOException{
        return Long.parseLong(next());
    }
    
    private static double nextDouble() throws IOException{
        return Double.parseDouble(next());
    }
    
    private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    
}
