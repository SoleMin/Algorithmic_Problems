#include <stdio.h>
#define MAX_N 3000
#define abs(x) ((x) < 0 ? (-(x)):(x))

int main()
{
	int n=0;
	
	while(scanf("%d",&n)==1)
	{
		int jolly=1;
		int index=0;
		int arr[MAX_N]={0,};
		int diff[MAX_N]={0,};
		
		for(int i=0;i<n;i++)
		{
			scanf("%d",arr+i);
		}
		
		for(int i=1 ;i<n;i++)
		{
			index = abs(arr[i-1]-arr[i]);
			diff[index]=1;
		}
		
		for(int i=1;i<n;i++)
		{
			if(diff[i]==0)
			{
				jolly=0;
				break;
			}
		}
		
		if(jolly==1)
			printf("Jolly\n");
		else if(jolly==0)
			printf("Not jolly\n");
		
	}
	
	return 0;
}