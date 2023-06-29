/* Idea: coin can't be smaller than 0.00. be sure to round */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int main(void) {
	while (true) {
		int num;
		scanf("%d", &num);
		if (!num)
			break;
		double* moneys = malloc(sizeof(double) * num);
		double sum = 0;
		for (int i = 0; i < num; i++) {
			scanf("%lf", &moneys[i]);
			sum += moneys[i];
		}
		double avg = (long)(((sum / num) + 0.005) * 100.0) / 100.0;
		double giver = 0;
		double taker = 0;
		for (int i = 0; i < num; i++) {
			if (moneys[i] > avg)
				giver += (moneys[i] - avg);
			else
				taker += (avg - moneys[i]);
		}
		double min = taker > giver ? giver : taker;
		printf("$%.2lf\n", min);
		free(moneys);
	}
	return 0;
}