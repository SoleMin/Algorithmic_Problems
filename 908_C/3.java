
/**
 * @author: Mehul Raheja
 */

import java.util.*;
import java.io.*;

public class p3{

    /*
        Runtime = O()
     */
    static int N, M, K;
    static String s;
    static StringTokenizer st;
    static int[] d;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        double[] x = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Double.parseDouble(st.nextToken());
        }
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
          //  int found = -1;
            double maxy = R;
            for (int j = i-1; j >= 0; j--) {
                if(Math.abs(x[j] - x[i]) <= 2 * R){
                    maxy = Math.max(y[j] + inc(x[j] - x[i],R), maxy);
                }
            }
            
            y[i] = maxy;
        }
        
        for (int i = 0; i < y.length-1; i++) {
            System.out.print(y[i] + " ");
        }
        System.out.println(y[y.length-1]);
       // System.out.println(Arrays.toString(y));
    }  
    
    public static  double inc(double x, double R){
        return Math.sqrt((4*R*R)-(x*x));
    }
}
