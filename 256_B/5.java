import java.io.*;
import java.util.*;

public class bender {
    static long[] dx = new long[]{0, 1, 0, -1};
    static long[] dy = new long[]{-1, 0, 1, 0};
    static long n, x, y, c;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader in = new BufferedReader(new FileReader("bender.in"));
        
        StringTokenizer dxdync = new StringTokenizer(in.readLine());
        n = Long.parseLong(dxdync.nextToken());
        x = Long.parseLong(dxdync.nextToken());
        y = Long.parseLong(dxdync.nextToken());
        c = Long.parseLong(dxdync.nextToken());
        
        long a = 0;
        long b = c;
        
        while(a < b){
            long m = (a + b)/2;
            
            long[] dxn = new long[4];
            long[] dyn = new long[4];
            
            for(int d = 0; d < 4; d++){
                dxn[d] = x + dx[d] * m;
                dyn[d] = y + dy[d] * m;
            }
            
            long ret = (m+1)*(m+1) + m*m;
            
            ret -= h(1 - dyn[0]);
            ret -= h(dyn[2] - n);
            ret -= h(dxn[1] - n);
            ret -= h(1 - dxn[3]);
            
            ret += q(1 - dyn[0] - (n-x+1));
            ret += q(1 - dyn[0] - x);
            ret += q(dyn[2] - n - (n - x + 1));
            ret += q(dyn[2] - n - (x));
            
            if (ret < c) a = m + 1;
            else b = m;
        }
        
        System.out.println(a);
    }
    
    public static long h(long x) {
        if (x <= 0) return 0;
        return 2*q(x) - x;
    }
    private static long q(long x){
        if (x <= 0) return 0;
        return x*(x+1)/2;
    }
}