import java.util.*;

public class Main
{
	static int MAX = 1000;
	
	static BitSet P = new BitSet(MAX + 1);
		
	public static boolean Noldbach(int n)
	{
		n--;
		
		int j;
		
		for(int i=2; i<=n; i++)
		{
			if(!P.get(i))
			{
				j = i + 1;
				
				while(P.get(j))
					j++;
				
				if(i+j == n)
				{
					if(!P.get(i+j+1))
					{
						//System.out.println((n+1)+" = "+i+" + "+(n-i)+" + 1");
					
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner lee = new Scanner(System.in);	

		for(int i=2; i*i<=MAX; i++)
		{
		    if(!P.get(i))
		    {
		    	for(int j=i+i; j<=MAX; j+=i)
		    		P.set(j);
		    }
		}
		
		int n, k, c;
		
		n = lee.nextInt();
		k = lee.nextInt();
		
		c = 0;
		
		for(int i=2; i<=n; i++)
		{
			if(Noldbach(i))
				c++;
			
			if(c == k)
				break;
		}
		
		if(c == k)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}