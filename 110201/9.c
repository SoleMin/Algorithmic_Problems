#include <stdio.h>
#define MAX_INPUT 3001
int main() {
	int n,tmp,gap,flag,i,j,k;
	int arr[MAX_INPUT];
	int arr2[MAX_INPUT];
	
	while(scanf("%d",&n) != EOF)
	{
		for(i=0;i<n;i++)
		{
			arr[i] = 0;
			arr2[i] = 0;
		}
		for(i=0;i<n;i++)
			scanf("%d",&arr[i]);
		flag = 1;
		for(i=0;i<n-1;i++)
		{
			if(n==1)
				break;
			tmp = arr[i] - arr[i+1];
			gap = (tmp > 0) ? tmp : -tmp;
			arr2[i] = gap;
		}
		
		for(j=0;j<n-2;j++) // 정렬
			for(k=j+1;k<n-1;k++)
				if(arr2[j]>arr2[k])
				{
					tmp = arr2[j];
					arr2[j] = arr2[k];
					arr2[k] = tmp;
				}
		
		for(i=0;i<n-1;i++)
		{
			if(arr2[i]!=i+1)
			{
				flag=0;
				break;
			}
		}	
		if(flag==1)
			printf("Jolly\n");
		else
			printf("Not jolly\n");
	}

	return 0;
}
