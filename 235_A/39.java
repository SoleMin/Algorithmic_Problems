import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class A235 {
    public static void main(String args[]) throws Exception{
        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(ip.readLine());
        int a,b,c;
        int x = 0,y = 0,z = 0;
        BigInteger l,t;
        
        if(n-2 > 1)
        {
            a = n;
            b = n-1;
            c = n-2;
        }
        else
        {
            a = n;
            if(n-1 > 1)
                b = n-1;
            else
                b = 1;
            c = 1;
            
            System.out.println(a*b);
            return;
        }
    
        if(n-3 > 1)
        {
            x = n-1;
            y = n-2;
            z = n-3;
        }
        
        if(n % 2 == 0)
            if(n % 3 == 0)
                l = BigInteger.valueOf(x).multiply(BigInteger.valueOf(y).multiply(BigInteger.valueOf(z)));
            else
            {
                l = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b).multiply(BigInteger.valueOf(c-1)));
                t = BigInteger.valueOf(x).multiply(BigInteger.valueOf(y).multiply(BigInteger.valueOf(z)));
                if(l.compareTo(t) < 0)
                    l = t;
            }
        else
            l = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b).multiply(BigInteger.valueOf(c)));
        
        System.out.println(l);
    }
}