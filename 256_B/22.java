import java.util.*;
import java.math.*;
import java.io.*;
public class b2 {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), x = input.nextInt(), y = input.nextInt(),  c = input.nextInt();
    long lo = 0, hi = 2*n;
    while(hi > lo+1)
    {
        long mid = (hi+lo)/2;
        long covered = go(n, x, y, mid);
        if(covered < c)
            lo = mid;
        else hi = mid;
    }
    if(go(n, x, y, lo) < c) lo++;
    System.out.println(lo);
    
}
public static long go(int n, int x, int y, long d)
{
    long res = d*d + (d+1)*(d+1);
    long maxLeft = d - x;
    if(maxLeft >= 0) res -= (maxLeft+1)*(maxLeft+1);
    long maxTop = d - y;
    if(maxTop >= 0) res -= (maxTop+1)*(maxTop+1);
    long maxRight = d - (n+1-x);
    if(maxRight >= 0) res -= (maxRight+1)*(maxRight+1);
    long maxBot = d - (n+1-y);
    if(maxBot >= 0) res -= (maxBot+1)*(maxBot+1);
    long maxTopLeft = d - (x+y);
    if(maxTopLeft >= 0) res += (maxTopLeft+1)*(maxTopLeft+2)/2;
    long maxTopRight = d - ((n+1-x)+y);
    if(maxTopRight >= 0) res += (maxTopRight+1)*(maxTopRight+2)/2;
    long maxBotLeft = d - (x+(n+1-y));
    if(maxBotLeft >= 0) res += (maxBotLeft+1)*(maxBotLeft+2)/2;
    long maxBotRight = d - ((n+1-x)+(n+1-y));
    if(maxBotRight >= 0) res += (maxBotRight+1)*(maxBotRight+2)/2;
    return res;

}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
}
