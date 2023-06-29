import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.System.out;

public class Flatville
{
    public static void main( String args[] )
    {
        class SquareHouse implements Comparable<SquareHouse>
        {
            public SquareHouse( double posLeft, double sideLen )
            { 
                _posLeft = posLeft;
                _sideLen = sideLen;
            }

            public double posLeft()
            { return _posLeft; }

            public double posRight()
            { return _posLeft + _sideLen; }

            public int compareTo( SquareHouse house )
            {
                double dist = _posLeft - house.posLeft();
                if ( dist < 0 )
                    return -1;
                else if ( dist > 0 )
                    return 1;
                else return 0;
            }

            private double _posLeft;
            private double _sideLen;
        }

        Scanner scanner = new Scanner( System.in );

        // Read the header
        final int nHouses    = scanner.nextInt();
        final double sideLen = scanner.nextDouble();

        ArrayList<SquareHouse> houses = new ArrayList<SquareHouse>();

        // Read the houses
        for ( int iHouse = 0; iHouse < nHouses; ++iHouse )
        {
            double pos  = scanner.nextDouble();
            double size = scanner.nextDouble();
            double posLeft = pos - size / 2.0;
            houses.add( new SquareHouse( posLeft, size ) );
        }

        // Sort the houses
        Collections.sort( houses );

        int nPositions = 2;
        for ( int iHouse = 0; iHouse < nHouses - 1; ++iHouse )
        {
            double space = houses.get( iHouse + 1 ).posLeft() - houses.get( iHouse ).posRight();
            if ( sideLen < space )
                nPositions += 2;
            else if ( sideLen == space )
                nPositions++;
        }

        out.println( nPositions );
    }
}
