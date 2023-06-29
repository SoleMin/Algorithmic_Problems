import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B implements Runnable {

    int a;
    int[] b;
    int[] l;

    public void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        a = in.nextInt();
        b = new int[n];
        l = new int[n];
        for ( int i = 0; i < n; i ++ ) {
            b[i] = in.nextInt();
            l[i] = in.nextInt();
        }
        out.println( best( 0, k ));
    }

    double best( int cur, int left ) {
        double r = 0.0;
        if ( cur < l.length ) {
            for ( int i = 0; i <= left && l[cur] + 10 * i <= 100; i ++ ) {
                l[cur] += i * 10;
                r = Math.max( r, best( cur + 1, left - i ) );
                l[cur] -= i * 10;
            }
        } else {
            for ( int m = 0; m < ( 1 << l.length ); m ++ ) {
                int sum = 0;
                double p = 1.0;
                int pro = 0;
                for ( int i = 0; i < l.length; i ++ ) {
                    if ( ( m & ( 1 << i ) ) == 0 ) {
                        p *= 1.0 - l[i] * 0.01;
                        sum += b[i];
                    } else {
                        p *= l[i] * 0.01;
                        pro ++;
                    }
                }
                if ( pro * 2 > l.length ) {
                    r += p;
                } else {
                    r += ( p * a ) / ( a + sum );
                }
            }
        }
        return r;
    }

    public Scanner in;

    public PrintWriter out;

    B() throws IOException {
        in = new Scanner(System.in);
        // in = new StreamTokenizer( new InputStreamReader( System.in ) );
        out = new PrintWriter(System.out);
    }

//    int nextInt() throws IOException {
//        in.nextToken();
//        return ( int ) in.nval;
//    }

    void check(boolean f, String msg) {
        if (!f) {
            out.close();
            throw new RuntimeException(msg);
        }
    }

    void close() throws IOException {
        out.close();
    }

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace(out);
            out.flush();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new B()).start();
    }
}