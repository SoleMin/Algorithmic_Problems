import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    StreamTokenizer in;
    PrintWriter out;
    static public void main(String[] args) throws IOException {
        new Main().run();
    }
    int ni() throws IOException {
        in.nextToken(); return (int) in.nval;
    }
    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));

        int n = ni(), t = ni();
        if(n == 0) {
            out.println(0); out.flush(); return;
        }
        House[] h = new House[n];
        for(int i = 0; i < n; i++) {
            h[i] = new House();
            h[i].x = ni(); h[i].a = ni();
        }
        Arrays.sort(h);
        int ret = 2;
        for(int i = 0; i < n - 1; i++) {
            if(2*(h[i + 1].x - h[i].x) - h[i].a - h[i + 1].a > 2*t) ret+=2;
            else if(2*(h[i + 1].x - h[i].x) - h[i].a - h[i + 1].a == 2*t) ret++;
        }
        out.println(ret);

        out.flush();
    }
    void run1() throws IOException {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            int t = ni();
            long n = ni(), m = ni();
            long x1 = ni(), y1 = ni(), x2 = ni(), y2 = ni();
        long tx1 = Math.min(x1, x2), tx2 = x1 + x2 - tx1;
        long ty1 = Math.min(y1, y2), ty2 = y1 + y2 - ty1;
        long dx = tx2 - tx1;
        long dy = ty2 - ty1;
        
    }

    class House implements Comparable<House> {
        int x, a;
        public int compareTo(House h) {
            return x < h.x ? -1 : 1;
        }
    }
}