import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Date: 19.02.2010
 * Time: 14:56:28
 *
 * @author Sergey Bankevich (Sergey.Bankevich@gmail.com)
 */
public class B1 {
    static Scanner in;

    public static void main( String[] args ) throws FileNotFoundException {
        in = new Scanner( System.in );
        int tn = in.nextInt();
        for ( int i = 0; i < tn; i ++ ) {
            String s = in.next();
        /*for ( int i = 1; i <= 100; i ++ ) {
            for ( int j = 1; j <= 100; j ++ ) {
                String s = "R" + i + "C" + j;
            for ( char j = 'A'; j <= 'Z'; j ++ ) {
            String s = j + "" + i;
                System.out.println( s );*/
            char[] c = s.toCharArray();
            boolean second = true;
            second &= c[0] == 'R';
            int r = s.indexOf( "C" );
            if ( r > 0 ) {
                second &= isNumber( s.substring( 1, r ) ) && isNumber( s.substring( r + 1 ) );
            } else {
                second = false;
            }
            if ( second ) {
                System.out.println( toLetters( s.substring( r + 1 ) ) + s.substring( 1, r ) );
            } else {
                r = 0;
                while ( c[r] >= 'A' && c[r] <= 'Z' ) {
                    r ++;
                }
                System.out.println( "R" + s.substring( r ) + "C" + fromLetters( s.substring( 0, r ) ) );
            }
             
        }
    }

    private static int fromLetters( String s ) {
        int r = 0;
        int l = s.length();
        for ( int i = 0; i < l; i ++ ) {
            r = r * 26 + s.charAt( i ) - 'A';
        }
        r ++;
        for ( int i = 1, c = 26; i < l; i ++, c *= 26 ) {
            r += c;
        }
        return r;
    }

    private static String toLetters( String s ) {
        int x = new Integer( s ) - 1;
        int c = 26;
        int l = 1;
        while ( true ) {
            if ( x < c ) {
                String r = "";
                for ( int i = 0; i < l; i ++ ) {
                    r = ( char ) ( 'A' + x % 26 ) + r;
                    x /= 26;
                }
                return r;
            }
            x -= c;
            c *= 26;
            l ++;
        }
    }

    private static boolean isNumber( String s ) {
        try {
            int x = new Integer( s );
        } catch ( NumberFormatException e ) {
            return false;
        }
        return true;
    }
}