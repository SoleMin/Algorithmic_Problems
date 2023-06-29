
import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()),
            s = Long.parseLong(st.nextToken());
        long m = s;
        while (m-f(m)<s && m<=n) m++;
        System.out.println(Math.max(n-m+1, 0));
    }
    
    public static int f(long n) {
        int sum = 0;
        for (long i=0, j=1L ; i<(int)Math.log10(n)+1 ; i++, j*=10) {
            sum += (n/j)%10;
        }
        return sum;
    }
    
}


