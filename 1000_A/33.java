/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Collections;
import java.util.HashSet;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<String> s1=new ArrayList<String> ();
		ArrayList<String> s2=new ArrayList<String> ();
			ArrayList<String> s3=new ArrayList<String> ();
			int i;
		for(i=0;i<n;i++)
		s1.add(sc.next());
		
		for(i=0;i<n;i++)
		s2.add(sc.next());
		s3.addAll(s2);
		for(i=0;i<n;i++)
		{
			if(s2.contains(s1.get(i)))
			s3.remove(s1.get(i));
			
			
		}
	System.out.println(s3.size());
		
	}
}