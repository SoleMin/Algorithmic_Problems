import java.util.*;
import java.io.*;
import java.math.*;
import javax.script.*;

public class Noldbach {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		boolean[] sieve=new boolean[1001];
		sieve[2]=false;
		ArrayList<Integer> primes=new ArrayList<Integer>();
		for(int x=2;x<1001;x++)
			if(!sieve[x])
			{
				primes.add(x);
				for(int y=x;y<1001;y+=x)
					sieve[y]=true;
			}
		int sum=0;
		for(int x=2;x<=n;x++)
		{
			if(primes.contains(x))
			{
			int need=x-1;
			for(int y=0;y<primes.size()-1;y++)
			{
				if(primes.get(y)+primes.get(y+1)==need)
				{
					sum++;
					break;
				}
			}
			}
			if(sum==k)break;
		}
		if(sum==k)System.out.println("YES");
		else System.out.println("NO");
		
	}
	
}