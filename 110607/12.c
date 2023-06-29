#include <stdio.h>
#define ARRSIZE 1000000

static long seq[ARRSIZE];

void main(void)
{
	int i, n , count, f, sum;
	
	while(scanf("%d", &n),n != 0)
	{
		seq[1] = 1;
		seq[2] =2;
		count = 3;
		f = 2;
		sum = 3;
		for(i = 3; ARRSIZE; i++)
		{
			seq[i] = f;
			sum += f;
			if(sum >= n)
				break;
			if(i == count)
			{
				f++;
				count += seq[f];
			}
		}
		if(n == 1)
			i = 1;
		else if(n <= 3)
			i = 2;
		
		printf("%d\n", i);
	}
}