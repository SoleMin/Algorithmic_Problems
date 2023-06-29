import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class C {

    public static void main(String[] args) {

        MyScanner in = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int r = in.nextInt();

        double[] y = new double[n];
        int[] x = new int[n];

        for(int i=0;i<n;++i){
            x[i] = in.nextInt();
            double bestY = r;
            for(int j=0;j<i;++j){
                if(Math.abs(x[i]-x[j]) <= 2*r){
                    double ny = y[j] + Math.sqrt(4*r*r - (x[i]-x[j])*(x[i]-x[j]));
                    if(ny > bestY){
                        bestY = ny;
                    }
                }
            }
            y[i] = bestY;
        }

        for(int i=0;i<n;++i){
            out.println(y[i]);
        }

        out.close();

    }


    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    // --------------------------------------------------------

}