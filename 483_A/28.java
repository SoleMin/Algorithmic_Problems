import java.io.*;
import java.util.*;
public class Main
{
	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String x[]=br.readLine().split(" ");
		long l=Long.parseLong(x[0]);
		long r=Long.parseLong(x[1]);
		if(l%2!=0)
		{
			l++;
		}
		if(l+2>r)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(l+" "+(l+1)+" "+(l+2));
		}
	}
} 