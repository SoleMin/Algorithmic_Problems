import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class A {
    private static StreamTokenizer in;
    private static PrintWriter out;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
    }
    
    public static void main(String[] args)throws Exception{
        int n = nextInt();
        
        out.println(n*3/2);
        
        out.flush();
    }
}
