#include <iostream>

using namespace std;

int k, n;
int chopsticks[5000];
int dp[5001][1010];

int main() {
	int T;
	cin >> T;
	while (T--) {
		cin >> k >> n;
		for (int i = n; i >= 1; i--)
			cin >> chopsticks[i];
		
		int a = chopsticks[1];
		int b;
		for (int i = 2; i <= n; i++) {
			b = chopsticks[i];
			chopsticks[i] = (a - b) * (a - b);
			a = b;
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k + 8; j++)
				dp[i][j] = 2147483647;
			dp[i][0] = 0;
		}
		
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k + 8; j++) {
				dp[i][j] = dp[i - 1][j];
				if (i >= j * 3)
					dp[i][j] = min(dp[i][j], dp[i - 2][j - 1] + chopsticks[i]);
			}
		
		cout << dp[n][k + 8] << endl;
	}
}