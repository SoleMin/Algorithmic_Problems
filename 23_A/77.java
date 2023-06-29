import java.io.*;
import java.util.Scanner;
import java.lang.String;
public class A23 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    int i=0,j=0,n=0,t=0,count=0;
    n=s.length();
    String s1="y",s2="yu6j";
    for(t=1;t<n;t++)
        {
        for(i=0;i<t;i++)
            {
            s1=s.substring(i,i+n-t);
            for(j=i+1;j<=t;j++)
                {
                s2=s.substring(j,j+n-t);
                if(s1.equalsIgnoreCase(s2))
                    {
                    count++;break;
                    }
                if(count==1) break;
                }
            if(count==1) break;
            }
        if(count==1) break;
        }
	if(n==0)
		{
	  System.out.println("0");
		}
	else
	{
    if(count==1)
    {
    System.out.println(s1.length());
    }
    else  System.out.println("0");
    }
	}
}