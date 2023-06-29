#include <stdio.h>

int main() 
{
	int a1[3000];
	int len;
	while(scanf("%d", &len) == 1)
	{
		int a2[3000] = {0};
		int jolly = 1;
		for (int i = 0; i < len; i++)
		{
			int num;
			scanf("%d", &num);
			num = (num > 0) ? num: -num;
			a1[i] = num;
		}
	
		for (int i = 0; i < len-1; i++)
		{
			int dif;
			dif = a1[i+1] - a1[i];
			dif = (dif > 0) ? dif: -dif;
			a2[dif] = 1;
		}
		
		for (int i = 1; i < len; i++)
		{
			if (a2[i] != 1)
				jolly = 0;	
		}
		
		if (jolly)
			printf("Jolly\n");
		else
			printf("Not jolly\n");		
	}
	return 0;
}
