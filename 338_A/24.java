import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A
{
	private static final long MOD = 1000000009L;
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
	    long n = in.nextInt();
		long m = in.nextInt();
		long k = in.nextInt();

		long w = n-m;

		long c = w*k;
		if(c >= n)
		{
			System.out.println(m);
			return;
		}

		long rem = n-c;
		long h = rem/k;

		long p = power(2, h+1);
		p -= 2;
		p += MOD;
		p %= MOD;
		p *= k;
		p %= MOD;

		long point = p + m - (h*k) % MOD;
		point += MOD;
		point %= MOD;

		System.out.println(point);



	}

	private static long power(int num, long power)
	{
		if(power == 0)
			return 1;
		long res = power(num, power/2);
		res = (res*res)%MOD;
		if(power % 2 != 0)
			res *= num;

		res%=MOD;

		return res;
	}
}
