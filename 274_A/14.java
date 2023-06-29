import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt(), k = input.nextInt();
    TreeSet<Integer> ts = new TreeSet<Integer>();
    int[] data = new int[n];
    for(int i = 0; i<n; i++)
    {
        data[i] = input.nextInt();
    }
    Arrays.sort(data);
    if(n>1 && k==1.*data[n-1]/data[0])
        System.out.println(n-1);
    else
    {
    for(int i = 0; i<n; i++)
    {
        if(data[i]%k != 0)
            ts.add(data[i]);
        else
        {
            if(!ts.contains(data[i]/k))
                ts.add(data[i]);
        }
    }
    System.out.println(ts.size());
    }
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
}
