import java.io.*;
import java.util.*;

public class RationalResistance {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(f(a,b));
    }
    
    public static long f(long a, long b)
    {
        if (a == 1 || b == 1)
            return a+b-1;
        if (a > b)
            return f(a%b,b) + a/b;
        else
            return f(a,b%a) + b/a;
    }
}