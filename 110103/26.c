#include <stdio.h>
#include <math.h>
int main() {
	int n,i;
	float st[1001],sum,aver,q,w;
	
	while(scanf("%d",&n)==1)
	{
		sum=0;
		q=0;
		w=0;
		
		if(n==0)
		{
			break;
		}
		
		for(i=0; i<n; i++)
		{
			scanf("%f",&st[i]);
			sum = sum + st[i];
		}
		
		aver = round(sum/n*100)/100;
		
		for(i=0; i<n; i++)
		{
			if(st[i] -aver >= 0)
			{
				q= q+st[i]-aver;
			}
			else
			{
				w= w+aver-st[i];
			}
		}
		if(q>w)
		{
		printf("$%.2f\n",w);
		}
		else
			printf("$%.2f\n",q);
		
	}
	
	return 0;
}
