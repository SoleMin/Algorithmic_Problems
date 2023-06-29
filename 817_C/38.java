import java.io.*;
import java.util.*;

public class C
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long n = Long.parseLong(in.next());
		long s = Long.parseLong(in.next());
		if(!check(n, s)){
			System.out.println(0);
		}
		else
		{
			long min = 1;
			long max = n;
			while(min != max)
			{
				long mid = (min + max) / 2;
				if(check(mid, s))
				{
					max = mid;
				}
				else
				{
					min = mid + 1;
				}
			}
			//System.out.println("found: " + min);
			System.out.println((n - min + 1));
		}
	}
	public static boolean check(long x, long s)
	{
		if(x - sumd(x) < s)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static long sumd(long x)
	{
		long sum = 0;
		while(x != 0)
		{
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}
}
