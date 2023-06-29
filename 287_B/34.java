import java.io.*;
import java.util.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        boolean online = "true".equals(System.getProperty("ONLINE_JUDGE"));
        if (online) {
            in = new InputReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        else {
            in = new InputReader(new FileReader("input.txt"));
            out = new PrintWriter(new File("output.txt"));
        }
        
        new Solution().run();
        
        out.close();
    }
    
    long sum (int x) {
        return x * 1l * (x+1) / 2;
    }
    
    int bins (long n, int k) {
        int l = 1,
            r = k;
        while (l < r) {
            int w = (l+r)/2;
            long s = sum(k) - sum(w-1);
            if (s == n)
                return w;
            if (s < n)
                r = w;
            else
                l = w+1;
        }
        return l;
    }
    
    private void run () {
        long n = in.nextLong();
        int k = in.nextInt();
        if (n == 1) {
            out.println(0);
            return;
        }
        if (1 + sum(k-1) < n) {
            out.println(-1);
            return;
        }
        int c = bins(n-1,k-1);
        if (1 + sum(k-1) - sum(c-1) == n)
            out.println(k-c);
        else
            out.println(k-c+1);
    }
    
    private static InputReader in;
    private static PrintWriter out;
}

class InputReader {
    public InputReader (Reader r) {
        buff = new BufferedReader(r);
        try {
            str = new StringTokenizer(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String next () {
        while (!str.hasMoreTokens())
            try {
                str = new StringTokenizer(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return str.nextToken();
    }
    
    public int nextInt () {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong () {
        return Long.parseLong(this.next());
    }
    
    private static BufferedReader buff;
    private static StringTokenizer str;
}