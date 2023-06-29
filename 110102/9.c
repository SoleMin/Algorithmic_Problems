#include <stdio.h>
int main() 
{
	char mine[101][101];
	int n,m;
	int fieldCount =1;
	int mineCount=0;
	
	while(scanf("%d %d",&n, &m)==2)
	{
		if(n==0 && m==0)
			return 0;
		
		getchar();
		
		for(int i=0;i<n;i++)
		{
			fgets(mine[i],sizeof(char)*(m+1),stdin);
			getchar();
		}
		
		printf("Field #%d:\n",fieldCount++);
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(mine[i][j]=='*')
				{
					printf("*");
					continue;
				}
				
				else
				{
					if(i-1 >=0 && j-1>=0 && mine[i-1][j-1]=='*')
						mineCount++;
					if(i-1 >=0 && mine[i-1][j]=='*')
						mineCount++;
					if(i-1>=0 && j+1<m && mine[i-1][j+1]=='*')
						mineCount++;
					if(j-1 >=0 && mine[i][j-1]=='*')
						mineCount++;
					if(j+1<m && mine[i][j+1]=='*')
						mineCount++;
					if(i+1<n&&j-1>=0 && mine[i+1][j-1]=='*')
						mineCount++;
					if(i+1 <n&&mine[i+1][j]=='*')
						mineCount++;
					if(i+1<n&&j+1<m&&mine[i+1][j+1]=='*')
						mineCount++;
				}
				printf("%d",mineCount);
				mineCount=0;
			}
			printf("\n");
		}
		printf("\n");
		
	}
	
	
}
