import java.io.*;
import java.util.*;

public class Main
{
	long sum ( long n ) { return (n*(n+1))/2; }

	public void solve ( ) throws Exception
	{
		Scanner in = new Scanner ( System.in );
		long n = in.nextLong()-1;
		long k = in.nextLong()-1;
		
		long lo = 0, hi = k, mi;
		while ( lo < hi )
		{
			mi = ( lo + hi ) / 2;
			if ( sum(k)-sum(k-mi-1) <= n ) lo = mi+1;
			else hi = mi;
		}
		
		long ans = lo;
		n -= ( sum(k) - sum(k-ans) );
		k -= ans;

		if ( n > k ) println ( "-1" );
		else if ( n == 0 ) println ( ans );
		else println ( (ans+1) );
	}
	
	public static void main ( String[] args ) throws Exception { (new Main()).solve(); }
	public static void print ( Object o ) { System.out.print ( o ); }
	public static void println ( Object o ) { System.out.println ( o ); }
	public static void println ( ) { System.out.println ( ); }
}
