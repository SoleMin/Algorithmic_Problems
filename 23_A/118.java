
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.io.*;

public class Mulitple
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		
		String s = r.readLine();

		System.out.println(num(s));
	}

	public static int num(String s)
	{
		int answer = 0;
		Set<String> set = new HashSet<String>();
		for(int j = s.length()-1; j>=1; j--)
		{
			for(int i = 0; i<s.length()-j+1; i++)
			{
				if(set.contains(s.substring(i,i+j)))
				{
					return s.substring(i,i+j).length();
				}
				else
				{
					set.add(s.substring(i,i+j));
				}
			}
		}

		return 0; 

	}
}


