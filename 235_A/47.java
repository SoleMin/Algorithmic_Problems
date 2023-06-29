import java.util.*;
public class LCMChallenge {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		if(n == 1l)
			System.out.println(1);
		else if(n == 2l)
			System.out.println(2);
		else
		{
			long c1 = n*(n-1)*(n-2);
			long c2 = n*(n-1)*(n-3);
			long c3 = (n-1)*(n-2)*(n-3);
			if(n%2==0)
				c1/=2;
			else
				c3/=2;
			if(n%3==0)
				c2/=3;
			long ans = Math.max(c1, c2);
			ans = Math.max(ans, c3);
			System.out.println(ans);
		}
	}
}
