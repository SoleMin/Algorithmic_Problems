#include <stdio.h>
#include <math.h>
#define MAX_DEST 7
#define MAX_STU 1000
int main() {
	int i, j=0, k=0;
	int n[MAX_DEST];
	float average, temp;
	float sum[MAX_DEST]={0.0, };
	float cost[MAX_DEST][MAX_STU];
	
	while(1){
		scanf("%d",&n[j]);
		
		for(i = 0; i < n[j]; i++)
			scanf("%f",&cost[j][i]);
		
		if(n[j]==0.0) break;
		j++;
	}
	
	while(k<j){
		average = 0;
		
		for(i = 0; i < n[k]; i++)
			average+=(cost[k][i]/n[k]);
		
		for(i = 0; i < n[k]; i++){
			temp = fabs(cost[k][i] - average);
			sum[k] += floorf(temp * 100) / 100;
		}
		
		temp = sum[k]/=2.0;
		sum[k] = roundf(temp * 100) / 100;
		k++;
	}
	
	for(i = 0; i < k; i++)
		printf("$%.2f\n",sum[i]);
	
	return 0;
}
