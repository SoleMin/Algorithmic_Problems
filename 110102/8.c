#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

char F[101][101];
char Result[101][101];

void main(void)
{
	int Field = 1;
	int M, N, i, j;
	
	while (scanf ("%d %d", &N, &M) == 2)
	{
		if (M == 0 && N == 0) return;
		
		for (i = 0; i < 100; i++)
		{
			memset(F[i], 0, sizeof(char) * 100);
		}
		
		for (i = 0; i < N; ++i)
		{
			scanf("%s", F[i]);
		}
		
		for (i = 0; i < N; ++i)
		{
			for (j = 0; j < M; ++j)
			{
				int num = 0;
				if( F[i][j] == '*')
				{
					Result[i][j] = '*';
					continue;
				}
				if (i - 1 >= 0 && j - 1 >= 0 && F[i - 1][j - 1] == '*') num ++;
				if (i - 1 >= 0 && j >= 0 && F[i - 1][j] == '*') num++;
				if (i - 1 >= 0 && j + 1 <= M && F[i - 1][j + 1] == '*') num++;
				if (i >= 0 && j + 1 <= M && F[i][j + 1] == '*') num++;
				if (i >= 0 && j - 1 >= 0 && F[i][j - 1] == '*') num++;
				if (i + 1 <= N && j + 1 <= M && F[i + 1][j + 1] == '*') num++;
				if (i + 1 <= N && j >= 0 && F[i + 1][j] == '*') num++;
				if (i + 1 <= N && j - 1 >= 0 && F[i + 1][j - 1] == '*') num++;;
				Result[i][j] = num + '0';
			}
		}
		puts("");
		printf("Field #%d:\n", Field++);
		for (i = 0; i < N; ++i)
		{
			for (j = 0; j < M; ++j)
			{
				printf("%c", Result[i][j]);
			}puts("");
		}
	}
}
