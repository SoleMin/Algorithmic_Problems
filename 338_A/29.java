import java.io.*;
import java.util.*;

public class ProblemA {
    InputReader in; PrintWriter out;

    long power(long a, long b, long mod) {
        long ret = 1;
        long mul = a;
        while (b > 0) {
            if (b % 2 == 1) {
                ret = (ret * mul % mod);                
            }
            mul = (mul * mul) % mod;
            b = b / 2;
        }
        return ret;
    }
    
    void solve() {
        long n = in.nextLong();
        long m = in.nextLong();
        long k = in.nextLong();
        long mod = 1000000009;
        long x = m - (n - n / k);
        if (x <= 0) {
            out.println(m);
        }
        else {
            long score = 1;
            score = power(2, x + 1, mod);
            score = (score + mod - 2) % mod;
//          out.println(score);
            long ans = ((score * k) + m - x * k + mod) % mod;
            out.println(ans);
        }
    }
    
    ProblemA(){
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        try {
            if (oj) {
                in = new InputReader(System.in);
                out = new PrintWriter(System.out);
            }
            else {
                Writer w = new FileWriter("output.txt");
                in = new InputReader(new FileReader("input.txt"));
                out = new PrintWriter(w);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        solve();
        out.close();
    }
    public static void main(String[] args){
        new ProblemA();
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    
    public InputReader(FileReader fr) {
        reader = new BufferedReader(fr);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble() {
        return Double.parseDouble(next());
    }

}