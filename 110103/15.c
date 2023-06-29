#include <stdio.h>
#include <math.h>

int main() {
	int n;
	double input[1000];
	
	while(scanf("%d", &n) == 1){
		if(n == 0) break;
		
		double total=0;
		double result=0;
		for(int i=0; i<n; i++){
			scanf("%lf", &input[i]);
			total += input[i];
		}
		total = total/n + 0.009;
		total = floor(total*100.0f)/100.0f;
		
		for(int i=0; i<n; i++){
			if(input[i]>total)
				result = result + input[i] - total;
		}
		
		printf("$%.2lf\n", result);
	}
	
	return 0;
}
