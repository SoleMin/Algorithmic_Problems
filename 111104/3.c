#include <stdio.h>

int main(){
	int turtle[5610] = {0,};
	int weight[5610] = {0,};
	int hp[5610] = {0,};
	int list[5610] = {0,};
	int sum[5610] = {0,};
	int cnt = 0, max = -1;
	int tmp;
	int result = 0;
	while(scanf("%d %d ", &weight[cnt], &hp[cnt]) != EOF){
		turtle[cnt] = hp[cnt] - weight[cnt];
		cnt++;
	}
	
	for(int i=0;i<cnt;i++)
		for(int j=0;j<cnt+1;j++)
		{
			if(turtle[i]<turtle[j])
			{
				tmp = turtle[i];
				turtle[i] = turtle[j];
				turtle[j] = tmp;
				tmp = weight[i];
				weight[i] = weight[j];
				weight[j] = tmp;
				tmp = hp[i];
				hp[i] = hp[j];
				hp[j] = tmp;
			}
		}

	for(int i=0;i<cnt;i++)
	{
		if(hp[i] >= weight[i])
			list[i] = 1;
		sum[i] = weight[i];	
	}
	
	for(int i=1;i<cnt;i++)
		for(int j=0;j<i;j++)
		{
			if(hp[i]>=(sum[j]+weight[i]) && list[i] < (list[j]+1))
			{
				list[i] = list[j] +1;
				sum[i] = sum[j] + weight[i];
			}
		}
	
	for(int i=0;i<cnt;i++)
	{
		if(max<list[i])
			max = list[i];
	}
	printf("%d\n", max);

	return 0;
}

