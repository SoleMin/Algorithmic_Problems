import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static InputStream IN;
    public static OutputStream OUT;
    public static PrintWriter out;
    public static BufferedReader in;
    
    public static StringTokenizer st = null;
    public static int ni() throws Exception {
        for (;st == null || !st.hasMoreTokens();){
            st = new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws Exception {
        IN = new FileInputStream("input.txt");
        OUT = new FileOutputStream("output.txt");
        out = new PrintWriter(OUT);
        in = new BufferedReader(new InputStreamReader(IN));
        int n = ni();
        int m = ni();
        int k = ni();
        int[] x = new int[k];
        int[] y = new int[k];
        for (int i = 0 ; i < k; i++){
            x[i] = ni() - 1;
            y[i] = ni() - 1;
        }
        int w = Integer.MIN_VALUE;
        int aa = -1;
        int ab = -1;
        for (int i = 0 ; i < n ; i++){
            for (int j = 0; j < m; j++){
                int min = Integer.MAX_VALUE;
                for (int q = 0; q < k; q++){
                    int cur = Math.abs(i - x[q]) + Math.abs(j - y[q]);
                    min = Math.min(cur, min);
                }
                if (min > w){
                    w = min;
                    aa = i;
                    ab = j;
                }
            }
        }
        out.println((aa + 1) + " " + (ab + 1));
        
        out.flush();
    }
}
