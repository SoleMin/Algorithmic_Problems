/*
* Author: Nikhil Garg
* Date:   2010-12-05
*
*/
import java.io.*;
import java.util.*;
import java.math.*;

public class javatemp
{
	static String map(int a)
	{
		if( a == 0) return "S";
		else if ( a == 1 ) return "M";
		else if ( a == 2 ) return "L";
		else if ( a == 3 ) return "XL";
		else if ( a == 4 ) return "XXL";
		return "";
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int ans = 1000;
		in.readLine();
		String s = in.readLine();
		int H = 0;
		for(int i =0; i < s.length(); i++)
			if( s.charAt(i) == 'H') H++;

		
		for(int i = 0; i < s.length(); i++)
		{
			int count = 0;
			for(int j = 0; j < H; j++)
				if( s.charAt( (i +j) % s.length()) =='T') count ++;
			ans = Math.min ( ans, count);
		}
		System.out.println(ans);

	}
	
	
	static void debug(Object...os)
	{
		System.out.println(Arrays.deepToString(os));
	}
}