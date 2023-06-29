#include <stdio.h>
#define MAX_WORK 1000


typedef struct _work {
	float result;
	int num;
} work;

int main(void) {
	int cas;
	int n;
	int i, j;
	double num1, num2;
	work plan[MAX_WORK];
	work tmp;
	
	scanf("%d", &cas);
	while(cas--) {
		scanf("%d", &n);
		for(i = 0; i < n; i++) {
			scanf("%lf %lf", &num1, &num2);
			plan[i].result = num2 / num1;
			plan[i].num = i + 1;
			//printf("%lf ", plan[i].result);
		}
		for(i = 0; i < n; i++) {
			for(j = 0; j < n - i - 1; j++) {
				if(plan[j].result < plan[j + 1].result) {
					tmp = plan[j + 1];
					plan[j + 1] = plan[j];
					plan[j] = tmp;
				} else if(plan[j].result == plan[j + 1].result) {
					if(plan[j].num > plan[j + 1].num) {
						tmp = plan[j + 1];
						plan[j + 1] = plan[j];
						plan[j] = tmp;
					}
				}
			}
		}
		for(i = 0; i < n; i++) {
			printf("%d ", plan[i].num);
		}printf("\n");
		printf("\n");
	}
	
	return 0;
}