#include <stdio.h>
int main() {
	int t;
	int i, j, k, n, m;
	int chop[5001];
	int dp[5001], w[5001];
	scanf("%d", &t);
	while(t--){
		scanf("%d %d", &k, &n);
		k += 8;
		for(i = n; i >= 1; i--)
			scanf("%d", &chop[i]);
		for(i = 2; i <= n; i++)
			w[i] = (chop[i] - chop[i - 1]) * (chop[i] - chop[i - 1]);
		for(i = 0; i < 5001; i++)
			dp[i] = 0;
		
		for(i = 1; i <= k; i++){
			m = 3 * i;
			for(j = n; j >= m; j--)
				dp[j] = dp[j - 2] + w[j];
			for(j = m + 1; j <= n; j++)
				if(dp[j - 1] < dp[j])
					dp[j] = dp[j - 1];
		}
		printf("%d\n", dp[n]);
	}
}
