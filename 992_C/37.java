import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tok;
    static boolean hasNext()
    {
        while(tok==null||!tok.hasMoreTokens())
            try{
                tok=new StringTokenizer(in.readLine());
            }
            catch(Exception e){
                return false;
            }
        return true;
    }
    static String next()
    {
        hasNext();
        return tok.nextToken();
    }
    static long nextLong()
    {
        return Long.parseLong(next());
    }
    static int nextInt()
    {
        return Integer.parseInt(next());
    }
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String args []){
        long x = nextLong();
        long a = 2, b = nextLong(), c = 1000000000+7;
        long res = 1;
        a %= c;
        if (x==0){
            out.println(0);
            out.flush();
            return;
        }
        for (; b != 0; b /= 2) {
            if (b % 2 == 1)
                res = (res * a) % c;
            a = (a * a) % c;
        }
        BigInteger r = new BigInteger(String.valueOf(res));
        BigInteger y = new BigInteger(String.valueOf(x));
        BigInteger ans = y.multiply(new BigInteger("2")).subtract(new BigInteger("1")).multiply(r).add(new BigInteger("1")).mod(new BigInteger(String.valueOf(c)));
        out.println(ans);
        out.flush();
    }
}
