import java.io.*;
import java.util.*;

public class Quiz {
    public static int mod = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long d = n-m;
        n -= d*k;
        if (n <= 0)
        {
            System.out.println(m);
            return;
        }
        long sum = (n%k) + d*(k-1);
        sum += 2*k*(pow(2,n/k)-1);
        sum %= mod;
        System.out.println(sum);
    }
    
    public static long pow(long a, long n)
    {
        if (n == 0)
            return 1;
        long pow = pow(a,n/2);
        pow = pow*pow % mod;
        if (n % 2 == 1)
            pow = pow*a % mod;
        return pow;
    }
}