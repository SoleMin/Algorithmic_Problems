import java.io.*;
import java.util.*;

public class Main {
    
    public static long func(long a, long b) {
        
        if (a < b)
            return func(b, a);
    	if (b < 2)
            return a;
        long q = a / b;
        long r = a - q * b;
        return q + func(b, r);
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" +");
        long a = Long.parseLong(ss[0]);
        long b = Long.parseLong(ss[1]);
        
        System.out.println(func(a, b));
        
    }
    
}
