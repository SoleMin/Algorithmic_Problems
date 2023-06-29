#include <stdio.h>
#define PEOPLE 1000

double pay[PEOPLE];

int main(void) {
	int n, i;
	double sum, avgPay, diffSumLess, diffSumMore;
	
	while (scanf("%d", &n) && n != 0) {	
		// 변수 초기화
		sum = 0.0; avgPay = 0.0; diffSumLess = 0.0, diffSumMore = 0.0;
		for (i = 0; i < n; i++) {	// 지출 금액 구하기
			scanf("%lf", &pay[i]);
			sum += pay[i];	// 금액 합계 구하기 -> 일단 다 더하기
			//printf("pay[%d]: %lf, sum: %lf\n", i, pay[i], sum);
		}
		avgPay = (int)(((int)(sum/(double)n*1000)+5)/10.0)/100.0;
		//avgPay = ((int)(sum/(double)n*100))/100.0;	// 지출 평균 : 소수 둘째자리 수까지 (둘째자리 이후 버림)
		//printf("sum: %lf, avgPay: %lf\n", sum, avgPay);
		for (i = 0; i < n; i++) {
			if (avgPay >= pay[i]) {	// pay[i]는 센트(소수 둘째자리)까지 입력받음
				// 적게 낸 사람들이 지불해야하는 금액 누적
				diffSumLess += avgPay - pay[i];
				//printf("avg-pay: %lf, diffSumLess : %lf\n", avgPay-pay[i], diffSumLess);
			}
			else {
				// 많이 낸 사람들이 받아야하는 금액 누적
				diffSumMore += pay[i] - avgPay;
				//printf("pay-avg: %lf, diffSumMore : %lf\n", pay[i]-avgPay, diffSumMore);
			}
		}
		// 최소 액수 구하기
		printf("$%.2lf\n", diffSumLess < diffSumMore ? diffSumLess : diffSumMore);
	}
	// headache...
	return 0;
}
