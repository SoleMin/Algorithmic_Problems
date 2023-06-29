import java.io.*;
import java.util.*;

public class Main{
	public static void main(String []args){
		Scanner cin = new Scanner( System.in );
		int n  = cin.nextInt();
		int [] num = new int [ n ];
		
		for (int i=0; i<n; i++)
			num[i] = cin.nextInt();
		
		Arrays.sort( num );
		
		int i = 0;
		while ( i < n ){
			if ( num[i] != num[0] ) break;
			i++;
		}
		
		if ( i == n ) System.out.println("NO");
		else System.out.println(num[i]);
	}
}
