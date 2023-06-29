import java.io.*;
import java.math.*;
import java.util.*;

public class Primes
{
	static Scanner in = new Scanner( new BufferedReader( new InputStreamReader( System.in ) ) );

	public static void main( String[] args )
	{
		int n = in.nextInt(), k = in.nextInt(), count = 0;
		boolean[] isP = new boolean[n+1];
		for( int i = 2; i <= n; i++ ) isP[i] = true;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for( int i = 2; i <= n; i++ ) if( isP[i] )
		{
			primes.add(i);
			if( i <= Math.sqrt(n) ) for( int j = 2*i; j <= n; j += i ) isP[j] = false;
		}
		for( int i = 0; i < primes.size()-1; i++ )
		{
			int sum = primes.get(i)+primes.get(i+1)+1;
			if( sum<=n && isP[sum] ) count++;
		}
		if( count>=k ) System.out.println( "YES" );
		else System.out.println( "NO" );
	}
}
