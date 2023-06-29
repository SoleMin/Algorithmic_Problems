import java.io.*;

public class B14G {

    public static void main(String[] args) throws IOException {
        init_io();
        int t = nint();
        while(t-- > 0) {
            int N = nint();
            if (N % 2 != 0) {
                out.println("NO"); continue;
            }
            N /= 2;
            int sqrt = (int)(Math.round(Math.sqrt(N)));
            int sqrt2 = (int)(Math.round(Math.sqrt(N/2)));
            if (sqrt * sqrt == N || sqrt2 * sqrt2 * 2 == N) {
                out.println("YES");
            }
            else {
                out.println("NO");
            }
        }
        out.close();
    }

    static StreamTokenizer in;
    static PrintWriter out;
    static BufferedReader br;

    static int nint() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    static void init_io() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        in = new StreamTokenizer(br);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}