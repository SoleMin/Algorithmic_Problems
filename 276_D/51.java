import java.io.*;
import java.util.*;

public class ProblemD {
    InputReader in; PrintWriter out;
    void solve() {
        long l = in.nextLong();
        long r = in.nextLong();
        long ans = 0;
        boolean add = false;
        for (int k = 62; k >= 0; k--) {
            long cb = (1L << k);
            if ((l & cb) != (r & cb))
                add = true;
            if (add)
                ans += (1L << k);
        }
        out.println(ans);
    }
    
    ProblemD(){
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
        new ProblemD();
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