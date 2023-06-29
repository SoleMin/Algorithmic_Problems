#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	int i, j, cnt;
	int* expenses;
	double input;
	int sum; int avg; int mod;
	int asum;
	
	while (1)
	{
		scanf("%d", &cnt);
		if (cnt == 0) break; 
		sum = 0;
		asum = 0;
		expenses = (int*)malloc(sizeof(int) * cnt);
		for (i = 0; i < cnt; i++)
		{
			scanf("%lf", &input);
			expenses[i] = (int)(input * 100 + 0.5);
			sum += expenses[i];
		}
		
		for (i = 0; i < cnt; i++)
			for(j = i + 1; j < cnt; j++)
			{
				if (expenses[i] < expenses[j])
				{
					expenses[i] ^= expenses[j];
					expenses[j] ^= expenses[i];
					expenses[i] ^= expenses[j];
				}
			}
		avg = sum / cnt;
		mod = sum % cnt;
		for (i = 0; i < cnt; i++)
			asum += abs(expenses[i] - (avg + (i < mod ? 1 : 0)));
		asum >>= 1; free(expenses);
		printf("$%.02lf\n", asum / 100.);
	}
	return 0;
}