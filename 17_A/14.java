import java.io.*;
import java.util.*;

public class Noldbach
{
	public Scanner in = new Scanner(System.in);
	public PrintStream out = System.out;

	public boolean[] yes;
	public int n, k;
	
	public void main()
	{
		n = in.nextInt();
		k = in.nextInt();
		
		genPrime();
		int i;
		
		yes = new boolean[n+1];
		
		int x;
		for(i=0;i+1<prime.length;++i)
		{
			x = prime[i]+prime[i+1]+1;
			if(x <= n && fac[x] == x) yes[x] = true;
		}
		
		int count = 0;
		for(i=0;i<yes.length;++i) if(yes[i]) ++count;
		
		out.println((count>=k?"YES":"NO"));
	}//end public void main()

	//Generating Primes
	public int N = 100000+100;
	public int[] fac, rest;
	public int[] prime;

	public void genPrime()
	{
		ArrayList<Integer> ap = new ArrayList<Integer>();
		fac = new int[N];
		rest = new int[N];
		
		int x,y;
		for(x=0;x<N;++x)
		{
			fac[x] = x;
			rest[x] = 1;
		}
		
		for(x=2;x<N;++x)
		if(fac[x]==x)
		{
			ap.add(x);
			for(y=x+x;y<N;y+=x)
			if(fac[y]==y)
			{
				fac[y] = x;
				rest[y] = y/x;
			}
		}
		
		prime = new int[ap.size()];
		for(int i=0;i<prime.length;++i) prime[i] = ap.get(i);
	}
	
	
	
	public static void main(String[] args)
	{
		(new Noldbach()).main();
	}
}

