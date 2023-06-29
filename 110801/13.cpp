#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int squares(int i)
{
	if ((i & 1) == 1)
		return i / 4 * 2 + 1;
	else
		return (i - 1) / 4 * 2 + 2;
}

long bishop_placements(int n, int k)
{
	if (k > 2 * n - 1)
		return 0;

	long dp[n * 2][k + 1];

	for(int i = 0; i < n * 2; i++)
	{
		for(int j = 0; j < k + 1; j++)
		{
			dp[i][j] = 0;
		}
	
	}
	for (int i = 0; i < n * 2; i++)
		dp[i][0] = 1;
	dp[1][1] = 1;

	for (int i = 2; i < n * 2; i++)
	{
		for (int j = 1; j <= k; j++)
			dp[i][j] = dp[i - 2][j]	+ dp[i - 2][j - 1] * (squares(i) - j + 1);
	}

	long result = 0;
	for (int i = 0; i <= k; i++)
	{
		result += dp[n * 2 - 1][i] * dp[n * 2 - 2][k - i];
	}

	return result;
}

int main()
{
	while(1)
	{
		int n, k;
		cin >> n;
		cin >> k;
		
		if(n == 0 && k == 0)
			break;
		
		long result = bishop_placements(n, k);
		cout << result << endl;
	}
}