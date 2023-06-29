#include <stdio.h>
int main() {
	double money = 0, moneyflow = 0, sum = 0, average = 0;
	int people = 0;
	while(1){
		money = 0, moneyflow = 0, sum = 0, average = 0;
		people = 0;
		double moneylist[1000] = {0,};
		scanf("%d", &people);
		if(people == 0)
			break;
		else{
			for(int i = 0; i<people; i++){
				scanf("%lf", &money);
				moneylist[i] = money;
				sum += money;
			}
			average = sum/people;
			average = ceil(average*100)/100;
			for(int j = 0; j<people; j++){
				if(moneylist[j]>average)
					moneyflow += moneylist[j] - average;
			}
		}
		printf("$%0.2lf\n", moneyflow);
	}
}
