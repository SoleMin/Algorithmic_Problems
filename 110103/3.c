#include <stdio.h>
#include <math.h>

int main()
{
	int N, i;
	double arr[1000];
	double sum, total;
	
	while(1){
		scanf("%d", &N);
		if(N == 0)
			break;
		sum=0, total=0;
		for(i=0; i<N; i++){
			scanf("%lf", &arr[i]);
			sum += arr[i];
		}
		sum /= N;
		sum = ceil(sum*100)/100;
		
		for(i=0; i<N; i++){
			if(arr[i] > sum)
				total += arr[i] - sum;
		}
		printf("$%.2f\n", total);
	}
	return 0;
}