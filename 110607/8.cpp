#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
		while (cin >> n) {
			if (n == 0)
				break;
			vector<int> dp(3);
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 2; dp[i] <= n; i++) {
					dp.push_back(dp[i] + upper_bound(dp.begin(), dp.begin() + i + 1, i) - dp.begin() - 1);
			}
			cout << (dp.size() - 2) << "\n";
		}
    return 0;
}