#include <stdio.h>
#define diff(x, y) x > y ? x-y : y-x	// 차이
#define sap(x) (x-1)*(x)/2	// 1~(n-1)까지의 합

int main(void) {
	int n, i, current, next, isJolly, diff, sum;
	
	while (scanf("%d", &n) == 1) {
		isJolly = 1, sum = 0;
		scanf("%d", &current);	// 제일 처음 값
		
		for (i = 1; i < n; i++) {
			scanf("%d", &next);
			diff = diff(current, next);
			sum += diff;
			if ( diff >= n || diff <= 0) {
				isJolly = 0;
			}
			
			current = next;	// 비교할 현재, 다음 값 한 칸씩 뒤로
		}
		
		// Jolly 출력
		//printf("sum: %d, sap(n): %d\n", sum, sap(n));
		if ( isJolly && (sum == sap(n)))
			printf("Jolly\n");
		else
			printf("Not jolly\n");
	}
	
	return 0;
}
