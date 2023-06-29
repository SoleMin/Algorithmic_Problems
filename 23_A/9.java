import java.io.*;
import java.util.*;

public class Main{
	public static void main( String[] args ){
		Scanner cin = new Scanner( System.in );
		String s = cin.next();
		int n = s.length();
		char[] ss = new char[ n ];
		ss = s.toCharArray();
		
		int ans = 0;
		
		for (int i=0; i<n; i++)
			for (int j=i+1; j<n; j++){
				int k = 0;
				while ( i+k<n && j+k<n && ss[i+k] == ss[j+k] ) k++;
				
				ans = Math.max( ans, k );
			}
		
		System.out.println( ans );
	}
}
