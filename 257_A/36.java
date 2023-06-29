import java.io.*;
import java.util.*;

public class ProblemA {
    InputReader in; PrintWriter out;
    void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        Arrays.sort(a);
        int d = k;
        int cur = n - 1;
        int ans = 0;
        while (d < m && cur >= 0) {
            d += a[cur] - 1;
            cur--;
            ans++;
        }
        if (d >= m)
            out.println(ans);
        else
            out.println("-1");
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