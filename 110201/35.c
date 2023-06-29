#include <stdio.h>
#define abs(x) ((x) < 0 ? (-(x)) : (x))

void main(void) 
{
	int sequence[3000];
	int n, i, prev, curr, diff, jolly;
	char line[5000];
	
	while (scanf("%d", &n) == 1)
	{
		jolly = 1;
		for (i = 1; i <= n; i++)
		{
			sequence[i] = 0;
		}
		scanf("%d", &prev);
		for (i = 1; i < n; i++)
		{
			scanf("%d", &curr);
			diff = abs(curr - prev);
			if (diff <= 0 || diff >= n || sequence[diff] == 1)
			{
				jolly = 0;
				break;
			}
			sequence[diff] = 1;
			prev = curr;
		}
		gets(line);
		puts(jolly ? "Jolly" : "Not jolly");
	}
}
