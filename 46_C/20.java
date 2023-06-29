import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class C43 {

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    
    static int nextInt() throws IOException {
        in.nextToken();
        return Integer.valueOf(in.sval);
    }
    
    static double nextDouble() throws IOException {
        in.nextToken();
        return Double.valueOf(in.sval);
    }
    
    static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }
    
    static {
        in.ordinaryChars('0', '9');
        in.wordChars('0', '9');
        
        in.ordinaryChars('.', '.');
        in.wordChars('.', '.');
        
        in.ordinaryChars('-', '-');
        in.wordChars('-', '-');
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        char[] s = nextString().toCharArray();
        int h = 0;
        for (int i = 0; i < n; i++)
            if (s[i] == 'H')
                h++;
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int p = i, t = 0;
            for (int j = 0; j < h; j++, p = (p+1)%n)
                if (s[p] == 'T')
                    t++;
            ans = Math.min(ans, t);
        }
        
        out.println(ans);
        out.flush();
    }

}
