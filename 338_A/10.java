import java.util.*;
import java.io.*;
public class Quiz
{
	public static final int MOD = 1000000009;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		long n = in.nextInt();
		long m = in.nextInt();
		long k = in.nextInt();
		
		long low = Math.min(n - (k * (n - m)), m);
		
		if(low < 0)
		{
			low = 0;
		}
		
		long result = 0;
		if(low >= k)
		{
			long b = low / k;
			
			result += fastExp(2, b + 1);
			result -= 2;
			if(result < 0)
			{
				result += MOD;
			}
			
			result *= k;
			result %= MOD;
		}
		
		result += low % k;
		result %= MOD;
		
		result += m - low;
		result %= MOD;
		
//		System.out.println(low);
		
		System.out.println(result);
	}
	
	public static long fastExp(int x, long pow)
	{
		if(pow == 0)
		{
			return 1;
		}
		
		long result = fastExp(x, pow / 2);
		result *= result;
		result %= MOD;
		
		if(pow % 2 == 1)
		{
			result *= x;
			result %= MOD;
		}
		
		return result;
	}
}
