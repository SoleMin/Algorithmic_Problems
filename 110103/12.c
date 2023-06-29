#include <stdio.h>
int main() {
	long money[1000],avgSum, avg, sum, minorCent;
	double buf;
	int people, low, high;
	while(scanf("%d", &people) == 1)
	{
		sum = 0, avgSum = 0 , avg = 0;
		if (people == 0)
			break;
		for (int i = 0; i < people; i++)
		{
			scanf("%lf", &buf);
			money[i] = (long)((buf + 0.005) * 100);
			avgSum += money[i];
		}
		avg = avgSum / people;
		minorCent = avgSum % people;
		for (int i = 0 ; i < people; i++)
		{
			if (avg < money[i])
			{
				sum += money[i] - avg;
				if (minorCent > 0)
					sum--;
			}
		}
		buf = sum;
		printf("$%.2f\n", (double)buf/100);
	}
	
}
