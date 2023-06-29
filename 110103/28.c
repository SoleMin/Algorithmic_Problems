#include <stdio.h>
#include <stdlib.h>
#define MAX_N 1000
#define MAX_MONEY 10000

int compare(const void *arg1, const void *arg2)
{
	int p1, p2;
	p1 = *(int*)arg1;
	p2 = *(int*)arg2;
	return(p2-p1);
}

int money_spent[1000];
int money_must_spent[1000];

int main()
{
	while(1)
	{
		int i,n;
		int all_money_spent = 0;
		int each_money_spent;
		int money_exchange = 0;
		
		scanf("%d", &n);
		if(n==0)break;
		
		for(i=0; i<n; i++)
		{
			double t;
			scanf("%lf",&t);
			money_spent[i]=(int)(t*100+0.5);
			all_money_spent+=money_spent[i];
			}
		
		qsort((void*)money_spent,(size_t)i,sizeof(int),compare);
		
		each_money_spent=all_money_spent/n;
		for(i=0; i<n; i++)
			money_must_spent[i]=each_money_spent;
			all_money_spent%=n;
		for(i=0; i<all_money_spent; i++)
			money_must_spent[i]++;
		for(i=0; i<n; i++)
			money_exchange +=abs(money_spent[i] - money_must_spent[i]);
			money_exchange /= 2;
		printf("$%.2f\n",money_exchange/100.0);
	}
}
