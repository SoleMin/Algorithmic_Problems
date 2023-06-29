#include <stdio.h>

int main() {
	int i, n = 0;
	int dollar, cent;
	double x[1000];
	double sum, avg, tmp1, tmp2, result;
	while(scanf("%d",&n) != EOF)
	{
		sum = avg = tmp1 = tmp2 = result = 0.0;
		if(n == 0 || n >1000)
			break;
		for(i=0;i<n;i++)
		{
			scanf("%d.%d", &dollar,&cent);
			x[i] = dollar * 100 + cent;
			sum = sum + x[i];
		}
		avg = sum / n;
			
		for(i=0;i<n;i++)
		{
			if((x[i]-avg) < 0)
				tmp1 += (long)(x[i] - avg)/100.0;
			else
				tmp2 += (long)(x[i] - avg)/100.0;
		}
		result = tmp1 > tmp2 ? tmp1 : tmp2;
		printf("$%.2lf\n", result);
		 
		
		for(i=0;i<n;i++)
			x[i] = 0;
	}
	return 0;
}
