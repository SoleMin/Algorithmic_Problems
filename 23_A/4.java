import java.util.Scanner;


public class Prob023A
{
    public static void main( String[] Args )
    {
        Scanner scan = new Scanner( System.in );
        String s = scan.next();

        all: for ( int x = s.length() - 1; x >= 0; x-- )
            for ( int y = 0; x + y <= s.length(); y++ )
            {
                String sub = s.substring( y, y + x );
                if ( s.indexOf( sub, y + 1 ) >= 0 )
                {
                    System.out.println( x );
                    break all;
                }
            }
    }
}
