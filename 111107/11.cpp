# include <iostream>
# include <string>
# include <algorithm>
# define MAX_CHOP (5000)
# define MAX_HUMAN (1000)
# define MAX_VALUE (142857)

using namespace std;

static int chopsticks[MAX_CHOP + 1];
static int dp[MAX_CHOP][MAX_HUMAN + 1];
static int n, k;

void get_input() {
	cin >> k >> n;
	for (int i = n; i >= 1; i--) {
		cin >> chopsticks[i];
	}
}

void init() {
	for (int r = 0; r <= n; r++) {
		for (int c = 0; c <= n; c++) {
			dp[r][c] = MAX_VALUE;

			if (c == 0) {
				dp[r][0] = 0;
			}
		}
	}
}

void solve() {
	init();

	for (int r = 1; r <= n; r++) {
		for (int c = 1; c <= k + 8; c++) {
			dp[r][c] = dp[r - 1][c];
			if (r >= c * 3) {
				dp[r][c] = min(dp[r][c], dp[r - 2][c - 1] + (chopsticks[r] - chopsticks[r - 1]) * (chopsticks[r] - chopsticks[r - 1]));
			}
		}
	}
}

int main() {
	int test_case;
	cin >> test_case;

	while (test_case-- > 0) {
		get_input();
		solve();

		cout << dp[n][k + 8] << endl;
	}

	return 0;
}