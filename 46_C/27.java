import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class C43 implements Runnable {

    public Scanner in;

    public PrintWriter out;

    final static String TASK_NAME = "";

    C43() throws IOException {
        in = new Scanner( System.in );
        // in = new StreamTokenizer( new InputStreamReader( System.in ) );
        out = new PrintWriter( System.out );
    }

    void close() throws IOException {
        out.close();
    }

    public void run() {
        try {
            solve();
            close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        char[] c = in.next().toCharArray();
        int t = 0;
        for ( int i = 0; i < n; i ++ ) {
            if ( c[i] == 'T' ) {
                t ++;
            }
        }
        int ct = 0;
        for ( int i = 0; i < t; i ++ ) {
            if ( c[i] == 'T' ) {
                ct ++;
            }
        }
        int r = 0;
        for ( int i = 0; i < n; i ++ ) {
            r = Math.max( r, ct );
            if ( c[i] == 'T' ) {
                ct --;
            }
            if ( c[( i + t ) % n] == 'T' ) {
                ct ++;
            }
        }
        out.println( t - r );
    }

    public static void main( String[] args ) throws IOException {
        new Thread( new C43() ).start();
    }
}
