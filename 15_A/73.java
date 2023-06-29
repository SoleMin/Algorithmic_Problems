import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Prob015A
{
    public static void main( String[] Args )
    {
        Scanner scan = new Scanner( System.in );
        int numHouses = scan.nextInt();
        int side = scan.nextInt() * 2;

        ArrayList<Integer> sides = new ArrayList<Integer>();
        for ( int x = 0; x < numHouses; x++ )
        {
            int c = scan.nextInt() * 2;
            int s = scan.nextInt();

            int l = c - s;
            int r = c + s;

            int li = Collections.binarySearch( sides, l );
            int ri = Collections.binarySearch( sides, r );

            if ( li >= 0 && ri >= 0 )
            {
                sides.remove( li );
                sides.remove( li );
            }
            else if ( li >= 0 )
                sides.set( li, r );
            else if ( ri >= 0 )
                sides.set( ri, l );
            else
            {
                sides.add( -li - 1, r );
                sides.add( -li - 1, l );
            }
        }

        int possibilities = 2;
        for ( int x = 1; x < sides.size() - 1; x += 2 )
            if ( sides.get( x + 1 ) - sides.get( x ) > side )
                possibilities += 2;
            else if ( sides.get( x + 1 ) - sides.get( x ) == side )
                possibilities += 1;

        System.out.println( possibilities );
    }
}
