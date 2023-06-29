#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int main() {
	int weight[5608], measure[5608];
	int dp[5608];
	int i, j, n, tmp, k;
	n = 1;
	while(scanf("%d %d", &weight[n], &measure[n]) == 2){
		n++;
	}
	--n;
	for(i = 1; i <= n;i++){
		for(j = 1; j <= n - i; j++){
			if(measure[j] > measure[j + 1]){
				tmp = weight[j];
				weight[j] = weight[j + 1];
				weight[j + 1] = tmp;
				tmp = measure[j];
				measure[j] = measure[j + 1];
				measure[j + 1] = tmp;	
			}
			else if(measure[j] == measure[j + 1] && weight[j] > weight[j + 1]){
				tmp = weight[j];
				weight[j] = weight[j + 1];
				weight[j + 1] = tmp;	
			}
		}
	}
	dp[0] = 0;
	k = 0;
	memset (dp, -1, sizeof(dp));
	dp[0] = 0;
	for (i = 1; i <= n; i++){
		for (j = n; j >= 1; j--){
			if (dp[j-1] < 0) continue;
			if (dp[j-1] + weight[i] <= measure[i] && (dp[j] < 0 || dp[j] > dp[j-1] + weight[i])){
				dp[j] = dp[j-1] + weight[i];
				if (j > k) k = j;
			}
		}
	}
	/*for(i = 1; i <= n; i++)
		printf("%d %d\n", weight[i], measure[i]);*/ 

	printf("%d\n", k);
	return 0;
}
