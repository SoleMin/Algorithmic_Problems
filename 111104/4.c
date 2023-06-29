#include <stdio.h>
#define size 5607
int main(){
	int health[size], weight[size];
	int sorted_health[size], sorted_weight[size];
	int cnt=0;
	int n,i,j,max_health,min_weight,min,tmp;
	int result =0;
	while(scanf("%d %d",&weight[cnt],&health[cnt])==2)
	{
		cnt++;
	}
	n=cnt;
	for(i=0;i<n;i++)
	{
		min = i;
		for(j=i+1;j<n;j++)
		{
			if (weight[j]<weight[min])
				min=j;
		}
		tmp=weight[min];
		weight[min]=weight[i];
		weight[i]=tmp;
	}
	
	
	for(i=0;i<n;i++)
	{
		for(j=i;j<n;j++)
		{
			if (health[i]<health[j])
			{
				tmp=health[i];
				health[i]=health[j];
				health[j]=tmp;
			}
		}
	}
	
	max_health=health[0];
	i=0;
	while(1)
	{
		max_health=max_health - weight[i];
		if(max_health<0)
			break;
		result++;
		i++;
	}
	printf("%d",result);
	return 0;
}
