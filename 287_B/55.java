import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Character.*;

@SuppressWarnings("unused")
public class round176B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    static StringTokenizer st = new StringTokenizer("");

    static int nextInt() throws Exception {
        return Integer.parseInt(next());
    }

    static String next() throws Exception {
        while (true) {
            if (st.hasMoreTokens()) {
                return st.nextToken();
            }
            String s = br.readLine();
            if (s == null) {
                return null;
            }
            st = new StringTokenizer(s);
        }
    }

    public static void main(String[] args) throws Exception {
        long n = parseLong(next());
        long k = parseLong(next());
        if(n == 1){
            System.out.println(0);
            return;
        }
        if (n <= k) {
            System.out.println(1);
            return;
        }
        if ((((k * (k + 1)) / 2) - 1) - (k - 2) < n) {
            System.out.println(-1);
        } else {
            long lo = 1;
            long hi = k + 1;
            int best = Integer.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + ((hi - lo) / 2);
                long first = ((mid * (2 + (2 + (mid - 1)))) / 2) - (mid - 1);
                long last = ((mid * (k - mid + 1 + k)) / 2) - (mid - 1);                
                if (n < first) {
                    hi = mid;
                } else {
                    if (n >= first && n <= last) {
                        hi = mid;
                        best = min(best, (int) mid);
                    } else
                        lo = mid + 1;
                }
            }
            System.out.println(best);
        }
    }
}
