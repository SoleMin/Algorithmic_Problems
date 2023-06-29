#include <stdio.h>

int main(void)
{
	int n=-1 , m=-1, count=1;
	
	while(!(n==0 && m==0)) //n,m이 0일때 입력 종료.
	{
		scanf("%d %d", &n,&m);
		if(n==0 && m==0) continue;
		char boom[n][m]; //입력받은 크기만큼의 지뢰찾기 판생성
		
		for(int i=0; i<n; i++)
		{
			scanf("%s", boom[i]); //지뢰입력
		}
		
		for(int i=0; i<n;i++)
		{
			for(int j=0; j<m; j++)
			{
				if(boom[i][j]=='.')
				{
					boom[i][j]='0'; //지뢰가 아닐경우 0으로 최과하여 주변 지뢰개수를 계산할준비.
				}
			}
		}
	
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				if(boom[i][j]=='*')
				{
					for(int x=i-1; x<=i+1; x++)
					{
						for(int y=j-1; y<=j+1; y++)
						{
							if(x<0 || y<0 || x>=n || y>=m || boom[x][y]=='*')
							{
								continue; //판을 벗어나거나 지뢰위치와 같거나 지뢰인것은 제외.
							}
							boom[x][y]+=1; //지뢰를 중심으로 지뢰가 아닌것에 +1을 수행.
						}
					}
				}
			}
		}
		printf("Field #%d:\n", count++);
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				printf("%c", boom[i][j]);
			}
			printf("\n");
		}
		printf("\n");
	}
}