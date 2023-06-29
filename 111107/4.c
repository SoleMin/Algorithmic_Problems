#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_N 5000
#define MAX_K 1000
#define INF 2147483647

int DP[MAX_K + 1][MAX_N + 1];
int L[MAX_N + 1], not[MAX_N + 1];

int cmp(const void *a, const void *b);
int min(int a, int b);
int search_DP(int k, int n);

int main(void) {
	int t, n, k, i, j;
	
	scanf("%d", &t);
	
	while(t--) {
		scanf("%d %d", &k, &n);
		for(i = 1; i <= n; i++)
			scanf("%d", &L[i]);
		
		k += 8;
		
		qsort(L + 1, n, sizeof(int), cmp);
		
		for(i = 2; i <= n; i++)
			not[i] = (L[i] - L[i - 1]) * (L[i] - L[i - 1]);
		
		for(i = 0; i <= k; i++)
			for(j = 0; j <= n; j++)
				DP[i][j] = -1;
		printf("%d\n", search_DP(k, n));
	}
	
	return 0;
}

int cmp(const void *a, const void *b) {
	return *(int *) b - *(int *)a;
}

int min(int a, int b) {
	return a < b ? a : b;
}



int search_DP(int k, int n) {
	if(DP[k][n] != -1)
		return DP[k][n];
	if(n < 3 * k) {
		DP[k][n] = INF;
	} else if(k == 0) {
		DP[k][n] = 0;
	} else {
		DP[k][n] = min(search_DP(k, n - 1), search_DP(k - 1, n - 2) + not[n]);
	}
	return DP[k][n];
}

