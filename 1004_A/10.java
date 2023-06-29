import java.util.*;
import java.io.*;

public class A6 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int d = in.nextInt();
		int ans=2;
		
		int[] a = new int[n];
		
		for(int i=0;i<n;i++)
			a[i] = in.nextInt();
		
		for(int i=1;i<n;i++)
		{
			if(a[i]-a[i-1]>2*d)
			{
				ans += 2;
			}
			else if(a[i]-a[i-1]==2*d)
				ans += 1;
		}
		
		System.out.println(ans);
	}

}
