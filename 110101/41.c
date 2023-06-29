#include <stdio.h>

int main() 
{
	long low; 		// 입력값 중 작은 수
	long high;		// 입력값 중 큰 수
	long lowOrg;
	long highOrg;
	long tmp;			// low high 설정을 위한 변수
	long length;	// 사이클 길이
	long max; 		// 최대 사이클
	long i;
	long j;

	while (scanf("%ld %ld", &low, &high) == 2)
  {
		max = 0;
		lowOrg = low;
		highOrg = high;
		if (low > high)
		{
			tmp = low;
			low = high;
			high = tmp;
		}
	
		for (i = low; i <= high; i++)
		{
			j = i;
			length = 1;
			while (j != 1)
			{
				if (j % 2 == 1)
				{
					j = 3 * j + 1;
					length++;
				}
				while (j % 2 != 1)
				{
					j >>= 1;
					length++;
				}
			}	
			if (length > max)
				max = length;
		}		
		printf("%ld %ld %ld\n", lowOrg, highOrg, max);
	}
	return 0;
}

