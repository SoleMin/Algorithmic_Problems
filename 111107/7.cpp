#include <bits/stdc++.h>

#define fastio cin.tie(0) -> sync_with_stdio(0)
using namespace std;
constexpr int MX = 1 << 17;
using ll = long long;
ll dp[5001][1001];

int main() {
    fastio;
    int t;
    cin >> t;
    while (t--) {
        int k, n;
        cin >> k >> n;
        vector<int> v(n);
        for (auto &i : v) cin >> i;
        //v.push_back(0);
        sort(v.begin(), v.end());
        memset(dp, 0x7f, sizeof dp);
        dp[0][0] = 0;
        //for(int i = 0; i < n; i++) dp[0][i] = 0;
        for (int i = 1; i <= k + 8; i++) {
            for (int j = 3 * i - 1; j < n; j++) {
                dp[i][j] = min({ dp[i][j - 1], dp[i - 1][j - 2] + (v[j] - v[j - 1]) * (v[j] - v[j - 1])});
            }
        }
        cout << dp[k + 8][n - 3] << '\n';
    }
}
