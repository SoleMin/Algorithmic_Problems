import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s;
		int i,j;
		for(i=0;i<n;i++)
		{
			s = sc.next();
			j = 0;
			boolean ok;
                        while((s.charAt(j)>='A')&&(s.charAt(j)<='Z')) j++;
                        while((j<s.length())&&(s.charAt(j)>='0')&&(s.charAt(j)<='9')) j++;
                        if (j==s.length()) ok = true; else ok = false;
                        String s1="",s2="";
                        if (ok)
                        {
                        	j = 0;
                        	while((s.charAt(j)>='A')&&(s.charAt(j)<='Z')) 
                        	{
                        		s1 += s.charAt(j);
                        		j++;
                        	}
                        	while(j<s.length()) 
                        	{
                        		s2 += s.charAt(j);
                        		j++;
                        	}
                        	int v = 0,p = 1;
                        	for(j=s1.length()-1;j>=0;j--)
                        	{
                        		v += p*(s1.charAt(j)-'A'+1);
                        		p*=26;
                        	}
                        	System.out.println("R"+s2+"C"+v);
                        } else
                        {
                        	j = 1;
                        	while((s.charAt(j)>='0')&&(s.charAt(j)<='9'))
                        	{
                        		s1 += s.charAt(j);
                        		j++;
                        	}
                        	j++;
                        	while(j<s.length())
                        	{
                        		s2 += s.charAt(j);
                        		j++;
                        	}
				Integer a = new Integer(s2);
                        	String s3="";
                        	int d;
                        	while(a > 0)
                        	{
                        		d = a%26; a/=26;
                        		if (d==0) {d=26; a--;} 
                        		s3 = Character.toUpperCase(Character.forDigit(9+d,36)) + s3;          
                        	}
                        	System.out.println(s3+s1);
                        }
		}
	}
}