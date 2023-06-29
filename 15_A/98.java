import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution  implements Runnable{
    private static BufferedReader br = null;
    private static PrintWriter out = null;
    private static StringTokenizer stk = null;
    
    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
       (new Thread(new Solution())).start();
    }
    
    private void loadLine() {
        try {
            stk = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String nextLine() {
        try {
            return br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Integer nextInt() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Integer.parseInt(stk.nextToken());
    }
    
    private Long nextLong() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Long.parseLong(stk.nextToken());
    }
    
    private String nextWord() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return (stk.nextToken());
    }
    
    private Double nextDouble() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Double.parseDouble(stk.nextToken());
    }
    
    public void run() {
        int n = nextInt();
        int t = nextInt();
        
        double[] d = new double[2*n];
        for (int i = 0; i < n; ++i) {
            double x = nextDouble();
            double a = nextDouble();
            d[2*i] = x-a/2;
            d[2*i+1] = x+a/2;
        }
        
        Arrays.sort(d);
        int res = 2;
        for (int i = 1; i < 2*n-1; i+=2) {
            if (d[i+1] - d[i] >= t) {
                ++res;
            }
            if (d[i+1] - d[i] > t) {
                ++res;
            }
        }
        
        out.println(res);
        out.flush();
    }
}

