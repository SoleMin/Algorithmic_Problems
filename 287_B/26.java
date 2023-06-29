import java.io.*;
import java.util.*;

public class B
{
	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(System.in);

		long n = in.nextLong();
		long k = in.nextLong();
		if(n == 1)
		{
			System.out.println(0);
			return;
		}
		if(n <= k)
		{
			System.out.println(1);
			return;
		}

		long lb = 2, ub = k;
		long sum = ((k)*(k-1))/2;
		if(sum+1 < n)
		{
			System.out.println(-1);
			return;
		}
		while(ub - lb > 1)
		{
			long mid = (lb+ub)/2;
			long s = ((mid-1)*(mid-2))/2;
			if(n - (sum-s+1) < 0)
				lb = mid;
			else
				ub = mid;
		}

		long rem = n - (sum - ((ub-1)*(ub-2))/2 + 1);
		long res = k - ub + 1;
		if(rem == 0)
		{
			System.out.println(res);
			return;
		}
		rem++;
		if(!(rem >= 2 && rem < ub))
		{
			System.out.println(-1);
			return;
		}
		System.out.println(res+1);


	}
}