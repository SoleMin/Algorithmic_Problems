import java.util.*;
import java.io.*;
public class Longest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int max=0;
		for(int i=0;i<str.length();i++)
		{
			for(int x=0;x+i<=str.length();x++)
			{
				if(contains(str,str.substring(x,x+i),x))
				{
					//System.out.println(str.substring(x,x+i));
					max=Math.max(max, i);
				}
			}
		}
		System.out.println(max);
	}
	public static boolean contains(String whole,String part,int start)
	{
		
		if(whole.indexOf(part, start+1)>=0)return true;
		return false;
	}
}
