#include <stdio.h>
int main() {
	long st,end,st1,end1;
	long i,q,m,t;
	
	while(scanf("%ld %ld",&st ,&end) == 2)
	{
		st1=st;
		end1=end;
		if(st<1||end>1000000)
		{
			break;
		}
		
		m=0;
		
		if(st>end)
		{
			t=st;
			st =end;
			end=t;
		}
		
		for(i=st; i<end+1; i++)
		{
			int k=1;
			q= i;

			while(q !=1)
			{
				if(q%2==1)
				{
					q = 3*q+1;

					while(q %2 == 0)
					{
						q /= 2;
						k++;
					}	

				}
				else 
					q /= 2;	

				k++;
			}

			if(m<k)
			{
				m =k;
			}
		}
	printf("%ld %ld %ld\n",st1 ,end1 ,m);
	}
	
	
	
	return 0;
}
