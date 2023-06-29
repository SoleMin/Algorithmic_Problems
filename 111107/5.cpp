#include <iostream>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
using namespace std;
#define MAXN 5005

long long dp[MAXN], w[MAXN], c[MAXN];

int main()
{
	int t, i, j, n, k;
	cin >> t;
	while (t--) {
		cin >> k >> n;
		k += 8;
		for (i = n; i >= 1; i--)
			cin >> w[i];
		for (i = 2; i <= n; i++)
			c[i] = (w[i] - w[i - 1]) * (w[i] - w[i - 1]);
		memset(dp, 0, sizeof(dp));
		for (i = 1; i <= k; i++)
		{
			int m = 3 * i;
			for (j = n; j >= m; j--)
				dp[j] = dp[j - 2] + c[j];
			for (j = m + 1; j <= n; j++)
				if (dp[j - 1] < dp[j])
					dp[j] = dp[j - 1];
		}
		cout << dp[n] << endl;
	}
	return 0;
}