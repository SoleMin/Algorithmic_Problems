#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, i;
	int money[1000];
	int need_money[1000];
	int sum, devide, remains, min;

	while(scanf("%d", &n) == 1) {
		sum = 0;
		remains = 0;
		min = 0;
		
		if(n == 0)
			break;
	
		for(i = 0; i < n; i++){
			double temp;
			scanf("%lf", &temp);
			money[i] = (int)(temp * 100 + 0.5);
			sum += money[i];
		}
		
		int t;
		for(i = 0; i < n; i++){
			for(int j = 0; j < n-1-i; j++){
				if(money[j] < money[j+1]){
					t = money[j];
					money[j] = money[j+1];
					money[j+1] = t;
				}
			}
		}
		
		devide = sum / n; // 낼 돈
		
		for(i = 0; i < n; i++)
			need_money[i] = devide;
		
		remains = sum % n; // 차액
		for(i = 0; i < remains; i++)
			need_money[i]++;
		
		for(i = 0; i < n; i++) {
			if(money[i] > need_money[i])
				min += (money[i] - need_money[i]);
		}
		
		printf("$%.2f\n", (double)min/100.0);
	}
	return 0;
}
