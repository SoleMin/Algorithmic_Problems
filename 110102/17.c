#include <stdio.h>
#define max 100
int main() {
	char buf[max];
	int mine[max][2];
	int x, y, mapCount = 1, mineCount;
	while(scanf ("%d %d", &y, &x) == 2)
	{
		if (x == 0 && y == 0)
			break;
		int answer[max][max] = {0, };
		mineCount = 0;
		for (int i = 0; i < y; i++)
		{
			scanf("%s", &buf[0]);
			for(int j = 0; j<x; j++)
				if(buf[j] == '*')
				{
					mine[mineCount][0] =j;
					mine[mineCount++][1] =i;
				}
		}
		
		for (int i = 0; i < mineCount; i++)
		{
			answer[mine[i][0]][mine[i][1]] = -1; //지뢰가 존재하는칸
			//주변 칸 탐색
			for (int bufx = -1; bufx <= 1; bufx++)
			{
				if (mine[i][0] + bufx < 0 || mine[i][0] + bufx >= x)
					continue;
				for (int bufy = -1; bufy <= 1; bufy++)
				{
					if (mine[i][1] + bufy < 0 || mine[i][1] + bufy >= y || answer[mine[i][0] + bufx][mine[i][1] + bufy] == -1)
						continue;
					answer[mine[i][0] + bufx][mine[i][1] +bufy]++;
				}
			}
		}
		
		printf("Field #%d:\n", mapCount++);
		for (int i = 0; i < y; i++)
		{
			for (int j = 0; j < x; j++)
			{
				if (answer[j][i] == -1)
					printf("*");
				else
					printf("%d", answer[j][i]);
			}
				printf("\n");
		}
		printf("\n");
	}
	return 0;
}
