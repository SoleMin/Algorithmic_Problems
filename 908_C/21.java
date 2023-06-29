

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Codeforces {
            
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final double eps = 1e-7;
        String toks[] = in.readLine().split(" ");
        int n = Integer.parseInt(toks[0]);
        double r = Double.parseDouble(toks[1]);
        double x[] = new double[n];
        toks = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            x[i] = Double.parseDouble(toks[i]);
        }
        double lo, hi, mid;
        double y[] = new double[n];
        y[0] = r;
        for (int i = 1; i < n; i++) {
            y[i] = r;
            for(int j=0; j<i; j++) {
                lo = y[j]; hi = 2000*2000;
                while( Math.abs(hi-lo) >= eps ) {
                    mid = (hi+lo)/2;
                    if( Math.sqrt( (x[i]-x[j])*(x[i]-x[j]) + (y[j]-mid)*(y[j]-mid) ) + eps > 2*r ) {
                        hi = mid;
                    } else {
                        lo = mid;
                    }
                }
                if(Math.sqrt( (x[i]-x[j])*(x[i]-x[j]) + (y[j]-lo)*(y[j]-lo) ) < 2*r + eps) {
                    y[i] = Math.max(y[i], lo);
                }
            }
        }
        for (double z : y) {
            System.out.printf(Locale.US, "%.7f ", z);
        }
    }
}

