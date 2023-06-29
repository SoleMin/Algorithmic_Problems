import java.io.*;
import java.math.*;
import java.util.*;

public class Main
{
    BufferedReader reader;
    FastScanner sc;
    
    void solve() throws Exception
    {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        if (arr[n - 1] == 1)
            arr[n - 1] = 2;
        else
            arr[n - 1] = 1;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
        
    public static void main(String[] args) throws Exception
    {
        new Main().solve();
    }
    
    Main() throws Exception
    {
        if (System.getProperty("ONLINE_JUDGE") == null)
        {
            //System.setIn(new FileInputStream("input.txt"));
            //System.setOut(new PrintStream("output.txt"));
        }
        
        reader = new BufferedReader(new InputStreamReader(System.in));
        sc = new FastScanner(reader);
    }
}

class FastScanner
{
    BufferedReader reader;
    StringTokenizer strTok;
    
    public FastScanner(BufferedReader reader)
    {
        this.reader = reader;
    }
    
    public String nextToken() throws IOException
    {
        if (strTok == null || !strTok.hasMoreTokens())
        {
            strTok = new StringTokenizer(reader.readLine());
        }
        return strTok.nextToken();
    }
    
    public int nextInt() throws IOException
    {
        return Integer.parseInt(nextToken());
    }
    
    public long nextLong() throws IOException
    {
        return Long.parseLong(nextToken());
    }
    
    public double nextDouble() throws IOException
    {
        return Double.parseDouble(nextToken());
    }
    
    public BigInteger nextBigInteger() throws IOException
    {
        return new BigInteger(nextToken());
    }
    
    public BigDecimal nextBigDecimal() throws IOException
    {
        return new BigDecimal(nextToken());
    }
}
