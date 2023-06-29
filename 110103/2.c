#include <stdio.h>
#include <stdlib.h>
#define MAX_STU 1000    // 학생 수
#define MAX_MONEY 10000 // 사용 가능한 돈의 크기 (단위: $)

int money_spent[1000];      // 지출한 돈
int money_must_spent[1000]; // 

int compare(const void *n1, const void *n2) {
	int p1, p2;
	p1 = *(int*)n1;
	p2 = *(int*)n2;

	return (p2-p1);
}

int main(void) {
	while(1) {
		int i, n;
		int all_money = 0;       // 총 돈의 양
		int each_money;          // 총 돈의 평균
		int money_exchange = 0;
		
		scanf("%d", &n);
		if(n == 0) break;
		
		for(i = 0; i < n; i++) {
			double t;
			scanf("%lf", &t);
			money_spent[i] = (int)(t*100+0.5);  // 소수 셋째에서 반올림/
			all_money += money_spent[i];
		}
		
		qsort( (void*)money_spent, (size_t)i, sizeof(int), compare);
		
		each_money = all_money / n;
		for(i = 0; i < n; i++)
			money_must_spent[i] = each_money;
		
		all_money %= n;
		for(i = 0; i < all_money; i++)
			money_must_spent[i]++;
		
		for(i = 0; i < n; i++)
			money_exchange += abs(money_spent[i] - money_must_spent[i]);
		
		money_exchange /= 2;
		printf("$%.2f\n", money_exchange/100.0);
		
	}
}