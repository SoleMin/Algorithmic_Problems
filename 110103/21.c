#include <stdio.h>
#include <stdlib.h>

int compare(const void *a,const void *b) {
	int a1, a2;
	a1= *(int*)a;
	a2= *(int*)b;
	return (a2 - a1);
}
int main() {
	int money_must_spent[1000];
	int money_spent[10000];
	while(1) {
		int n, i;
		int all_money_spent = 0;
		int each_money_spent;
		int money_exchange = 0;
		
		scanf("%d", &n);
		if(n == 0) break;
		
		for(i = 0; i < n; i++) {
			double t;
			scanf("%lf", &t);
			money_spent[i] = (int)(t*100+0.5);
			all_money_spent += money_spent[i];
		}
		
		qsort((void*)money_spent,(size_t)i,sizeof(int),compare);
		each_money_spent = all_money_spent/n;
		for(i = 0; i < n; i++)
			money_must_spent[i] = each_money_spent;
		all_money_spent %= n;
		for (i = 0; i < all_money_spent; i++)
			money_must_spent[i]++;
		for (i = 0; i < n; i++)
			money_exchange += abs(money_spent[i] - money_must_spent[i]);
		money_exchange /= 2;
		printf("$%.2f\n", money_exchange/100.0);
		}
}
