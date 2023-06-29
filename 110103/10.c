#include <stdio.h>

int main()
{
	int count =0;
	double average =0;
	double answer =0;
	
	while(scanf("%d",&count))
	{
		if(count ==0)
			return 0;
		
		double money[1000]={0,};
		average =0;
		answer =0;
		
		for(int i=0;i<count;i++)
		{
			scanf("%lf",money+i);
			average += money[i];
		}
		average =average/count;
		
		for(int i=0;i<count;i++)
		{
			if(money[i]<average)
				answer = answer + average - money[i];
		}
		answer = (int)(answer*100);
		answer /=100;
		printf("$%.2f\n",answer);
	}
	return 0;
}