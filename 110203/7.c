#include <stdio.h>

int main()
{
	int T=0;
	int N=0;
	int P=0;
	int answer=0;
	
	scanf("%d",&T);
	
	for(int i=0;i<T;i++)
	{
		scanf("%d",&N);
		scanf("%d",&P);
		int H[100]={0,};
		
		for(int i=0;i<P;i++)
		{
			scanf("%d",H+i);
		}
		
		for(int i=1;i<=N;i++)
		{
			if(i%7==6 || i%7==0)
				continue;
			for(int j=0;j<P;j++)
			{
				if(i%H[j]==0)
				{
					answer++;
					break;
				}
				
			}
		}
		
		printf("%d\n",answer);
		answer=0;
	}
	return 0;
}