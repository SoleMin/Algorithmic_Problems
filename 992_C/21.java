import java.util.*;
import java.io.*;
public class A{
	static long mod = 1000000000+7;
	static int arr[];
	static HashMap<Long,Long> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long x = scan.nextLong();
		long k = scan.nextLong();
		if(x == 0)
		{
			System.out.println(0);
			return;
		}
		x = x%mod;
		long power = pow(2,k + 1)%mod;
		power = (power*x)%mod;
		long num = (pow(2,k) - 1 + mod)%mod;
		long ans = (power - num + mod)%mod;
		System.out.println((ans));
	}
	public static long pow(long a,long b)
	{
		if(b == 0)
			return 1;
		if(b == 1)
			return a;
		long x1,x2;
		if(map.containsKey(b - b/2))
			x1 = map.get(b - b/2);
		else
		{
			x1 = pow(a,b - b/2)%mod;
			map.put(b - b/2,x1);
		}
		if(map.containsKey(b/2))
			x2 = map.get(b/2);
		else
		{
			x2 = pow(a,b/2)%mod;
			map.put(b/2,x2);
		}
		return (x1*x2)%mod;
	}
}