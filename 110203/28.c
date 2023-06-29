#include <stdio.h>

int main() 
{
	int time, len, party;
	int para[100];
	scanf("%d", &time);
	
	while (time > 0)
	{
		int lostDays = 0;
		scanf("%d", &len);
		scanf("%d", &party);
		
		for (int i = 0; i < party; i++)
			scanf("%d", &para[i]);
		
		for (int i = 1; i <= len; i++)
		{
			if ((i % 7) != 6 && (i % 7) != 0)
			{
				for (int j = 0; j < party; j++)
				{
					if (i % para[j] == 0)
					{
						lostDays++;
						break;
					}
				}
			}
		}		
		printf("%d\n", lostDays);
	
		time--;
	}
	return 0;
}
