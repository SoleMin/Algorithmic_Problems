import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class con111_A {

    public static void main( final String[] args ) throws IOException {
        final BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        final int n = Integer.parseInt( br.readLine() );
        final int[] a = new int[n];
        final String[] parts = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            a[ i ] = Integer.parseInt( parts[ i ] );
        }
        System.out.println( solve( n, a ) );
    }

    private static int solve( final int n, final int[] a ) {
        Arrays.sort( a );
        int sum = 0;
        for ( int i = 0; i < n; ++i ) {
            sum += a[ i ];
        }
        int res = 0;
        int ms = 0;
        for ( int i = n - 1; i >= 0; --i ) {
            if ( ms > sum / 2 ) {
                break;
            } else {
                ms += a[ i ];
                ++res;
            }
        }
        return res;
    }

}
