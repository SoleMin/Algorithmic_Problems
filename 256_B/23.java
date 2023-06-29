import java.io.*;
import java.util.*;

public class ProblemB {
    InputReader in; PrintWriter out;
    void solve() {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int c = in.nextInt();
        int cur = 1;
        for (int k = 1; k <= c; k++) {
//          out.println(k + " " + cur);
            if (cur >= c) {
                out.println(k - 1);
                return;
            }
            //x + i; y + k - i;
            int iLess = n - x;
            int iMore = y + k - n;
            if (iLess > k)
                iLess = k;
            if (iMore < 0)
                iMore = 0;
//          out.println("iless == " + iLess + " imore == " + iMore);
            int add = iLess - iMore + 1;
            if (add < 0)
                add = 0;
//          out.println("add == " + add);
            cur += add;
            //x + i; y - k + i;
            iLess = n - x;
            iMore = 1 + k - y;
            if (iLess > k)
                iLess = k;
            if (iMore < 0)
                iMore = 0;          
//          out.println("iless == " + iLess + " imore == " + iMore);
            add = iLess - iMore + 1;
            if (add < 0)
                add = 0;
//          out.println("add == " + add);
            cur += add;
            //x - i; y - k + i;
            iLess = x - 1;
            iMore = 1 + k - y;
            if (iLess > k)
                iLess = k;
            if (iMore < 0)
                iMore = 0;
//          out.println("iless == " + iLess + " imore == " + iMore);
            add = iLess - iMore + 1;
            if (add < 0)
                add = 0;
//          out.println("add == " + add);
            cur += add;
            //x - i; y + k - i;
            iLess = x - 1;
            iMore = y + k - n;
            if (iLess > k)
                iLess = k;
            if (iMore < 0)
                iMore = 0;
//          out.println("iless == " + iLess + " imore == " + iMore);
            add = iLess - iMore + 1;
            if (add < 0)
                add = 0;
//          out.println("add == " + add);
            cur += add;
//          out.println("cur == " + cur);
            //delete double
            if (x + k <= n)
                cur--;
            if (y - k >= 1)
                cur--;
            if (x - k >= 1)
                cur--;
            if (y + k <= n)
                cur--;
        }
//      throw new RuntimeException();
    }
    
    ProblemB(){
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
        new ProblemB();
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