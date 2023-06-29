import java.io.*;
import java.util.*;

public class a
{
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		solve(N);
		
		
	}
	
	static void solve(int a)
	{
		if((a-8)%3==0)
		{
			System.out.println(8+" "+(a-8));
			return ;
		}
		if((a-4)%3==0)
		{
			System.out.println(4+" "+(a-4));
			return ;
		}
		if((a-6)%3==0)
		{
			System.out.println(6+" "+(a-6));
			return ;
		}
	}
		
}