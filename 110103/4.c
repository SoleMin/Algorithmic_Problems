#include <stdio.h>
#include <math.h>
int main() {
	int n, i;
	double tmp;
	double sum, result;
	double group[1000] = { 0 };
	while(1){
		scanf("%d", &n);
		if(n == 0 || n > 1000) break;
		sum = 0.0;
		for(i = 0;i < n;i++){
			scanf("%lf",&group[i]);
			if(group[i] > 10000.00 || group[i] < 0.0) exit(0);
			sum += group[i] * 100;
		}
		tmp = ceil(sum / n) / 100;
		result = 0.0;
		for(i = 0;i < n;i++){
			if(tmp < group[i]) {
				result += group[i] - tmp;
			}
		}
		printf("$%.2lf\n",result);
	}
	return 0;
}
