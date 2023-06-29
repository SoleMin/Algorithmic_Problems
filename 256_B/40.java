import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class ProblemB {
    
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] line = s.readLine().split(" ");
        long n = Long.valueOf(line[0]);
        long y = Long.valueOf(line[1]);
        long x = Long.valueOf(line[2]);
        long c = Long.valueOf(line[3]);
        
        long min = 0;
        long max = n*2L+20;
        for (int cnt = 0 ; cnt < 300 ; cnt++) {
            long med = (min+max) / 2L;
            long ct = isok(med, n, x, y, c); 
            if (ct >= c) {
                max = med;
            } else {
                min = med+1;
            }
        }
        
        long lst = max;
        for (long d = -2 ; d <= 2 ; d++) {
            if (max+d >= 0 && isok(max+d, n, x, y, c) >= c) {
                lst = Math.min(lst, max+d);
            }
        }
        
        out.println(lst);
        out.flush();
    }
    

    private static long isok(long time, long n, long x, long y, long c) {
        long total = time * 2 * (time + 1) + 1;
        long top = y - time;
        if (top <= 0) {
            long dy = Math.abs(top)+1;
            total -= dy*dy;
            long over = dy - x;
            if (over >= 1) {
                total += (1L + over) * over / 2; 
            }
            over = dy - ((n + 1) - x);
            if (over >= 1) {
                total += (1L + over) * over / 2; 
            }
        }
        
        long bottom = y + time;
        if (bottom > n) {
            long dy = Math.abs(bottom-n);
            total -= dy*dy;
            long over = dy - x;
            if (over >= 1) {
                total += (1L + over) * over / 2; 
            }
            over = dy - ((n + 1) - x);
            if (over >= 1) {
                total += (1L + over) * over / 2; 
            }
        }
        
        long left = x - time;
        if (left <= 0) {
            long dy = Math.abs(left)+1;
            total -= dy*dy;
        }

        long right = x + time;
        if (right > n) {
            long dy = Math.abs(right-n);
            total -= dy*dy;
        }
        return total;
    }

    public static void debug(Object... os){
        System.err.println(Arrays.deepToString(os));
    }
}