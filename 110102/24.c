#include <stdio.h>

int main() 
{
	int n, m, mine;
	int count = 0;
	
	
	scanf("%d %d",&n, &m);

	while (!(n == 0 && m == 0))
	{
		char board[n][m];
		count++;
  	for (int i = 0; i < n; i++)
		{	
			scanf("%s", board[i]);
		}
	
		printf("Field #%d:\n", count);
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (board[i][j] == '*')
					printf("%c", '*');
				else
				{
					mine = 0;
					for (int k = i - 1; k <= i + 1; k++)
					{
						for (int l = j - 1; l <= j + 1; l++)
						{
							if ((k >= 0 && l >= 0) && (k < n && l < m))
								if (board[k][l] == '*')
									mine++;
						}
					}
					
					printf("%d", mine);
				}
			}
			printf("\n");
		}	
		printf("\n");
		scanf("%d %d", &n, &m);
	}
	return 0;
}
