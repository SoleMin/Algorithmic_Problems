#include <stdio.h>
#define MAXN 2000000

static unsigned long long arr[MAXN];

int main()
{
	unsigned long long n, i;
	unsigned long long result,k,index;

	while (scanf("%lld",&n) && n !=0)
	{
		result = 3;
		index = 3;
		k = 2;
		for (i = 3; i < MAXN; i++)
		{
			arr[i] = k;
			result += k;
			if (result >= n)
				break;

			if (i == index) 
			{
				k++;
				index += arr[k];
			}
		}
		if (n == 1)
			i = 1;
		else if(n <= 3)
			i = 2;

		printf("%lld\n", i);
	}

	return 0;
}