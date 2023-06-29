#include <stdio.h>

int main()
{
	long upper, upperOrg;
	long lower, lowerOrg;
	int count = 1;
	
	while(scanf("%ld %ld",&lower, &upper)==2)
	{
		upperOrg = upper;
		lowerOrg = lower;
		
		if(upper < lower)
		{
			long tempt = upper;
			upper = lower;
			lower = tempt;
		}
		
		count = 1;
		
		for(int i = lower ; i<=upper ; i++)
		{
			long n = i;
			long tempCount = 1;
			
			while(n != 1)
			{
				if(n & 1)
				{
					n = 3*n+1;
					tempCount++;
				}
				else{
					n=n>>1;
					tempCount++;
				}
			}
			if(tempCount > count)
				count = tempCount;
		}
		printf("%ld %ld %ld\n",lowerOrg ,upperOrg,count);
	}
	
	
}