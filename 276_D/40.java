import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class con169_D {

	private static final boolean DEBUG = false;

	public static void main( final String[] args ) throws Exception {
		final BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		final String line = br.readLine();
		final StringTokenizer tok = new StringTokenizer( line );

		final long L = Long.parseLong( tok.nextToken() );
		final long R = Long.parseLong( tok.nextToken() );

		System.out.println( solve( L, R ) );
	}

	public static long solve( final long L, final long R ) {
		if ( L == R ) return L ^ R;
		if ( DEBUG ) System.out.printf( "L=%d (%s), R=%d (%s)\n", L, Long.toBinaryString( L ), R,
				Long.toBinaryString( R ) );

		final int ld = length( L );
		final int ldm1 = ld - 1;
		final int rd = length( R );

		if ( ld < rd ) {
			long max = 1;
			while ( length( max ) < rd ) {
				max <<= 1;
			}
			long min = 1;
			while ( length( min ) < rd - 1 ) {
				min <<= 1;
				++min;
			}
			if ( DEBUG ) System.out.printf( "min=%d (%s), max=%d (%s)\n", min, Long.toBinaryString( min ), max,
						Long.toBinaryString( max ) );
			return min ^ max;
		} else {
			final char[] minStr = Long.toBinaryString( L ).toCharArray();
			final char[] maxStr = Long.toBinaryString( R ).toCharArray();
			final char[] res = new char[minStr.length];
			Arrays.fill( res, '0' );
			{
				int i = 0;
				while ( i < res.length ) {
					if ( minStr[ i ] == maxStr[ i ] ) {
						res[ i ] = '0';
					} else {
						break;
					}
					++i;
				}
				if ( DEBUG ) System.out.println( "diff at pos: " + i );
				if ( minStr[ i ] == '0' ) {
					res[ i++ ] = '1';
					for ( int j = i; j < res.length; ++j ) {
						res[ j ] = '1';
					}
				} else {
					throw new IllegalArgumentException();
				}
			}
			return Long.parseLong( new String( res ), 2 );
		}
	}

	private static int length( long l ) {
		int res = 0;
		while ( l > 0 ) {
			++res;
			l >>= 1;
		}
		return res;
	}

}
