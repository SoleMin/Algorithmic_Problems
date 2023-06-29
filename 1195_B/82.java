import java.util.*;

public class B
{
	static long sumN(long n)
	{
		return n * (n + 1) / 2;
	}

	static int binSearchPuts(int n, int k)
	{
		int L = 1;
		int U = n;
		int M = (L + U) / 2;

		while(L <= U)
		{
			long left = sumN(M) - (n - M);
			
			if(left < k)
			{
				L = M + 1;
			}
			else if(left > k)
			{
				U = M;
			}
			else
			{
				break;
			}

			M = (L + U) / 2;
		}

		return M;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int k = input.nextInt();

		long ate = n - binSearchPuts(n, k);
		System.out.println(ate);
	}
}