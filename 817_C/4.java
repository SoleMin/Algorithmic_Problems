import java.util.Arrays;
import java.util.Scanner;

public class P817C
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long s = scan.nextLong();
		long ans = 0;
		if (s > n)
		{
			System.out.println(0);
			return;
		}
		if (n > s+200)
		{
			ans += n-(s+200);
			n = s+200;
		}
		for (long i = s; i <= n; i++)
		{
			char[] num = (""+i).toCharArray();
			int sum = 0;
			for (int j = 0; j < num.length; j++)
				sum += num[j] - '0';
			if (i - sum >= s)
				ans++;
		}
		System.out.println(ans);
	}
}