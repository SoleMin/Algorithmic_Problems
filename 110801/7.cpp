#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;
using ll = long long;
ll dp[16][64];

inline ll f(int i, int j){
    ll ret;
    if(i & 1) ret =  i / 4 * 2 + 1;
    else ret = (i - 1) / 4 * 2 + 2;
    return ret - j + 1;
}

ll sol(int n, int k){
    for(int i = 0; i < 2 * n; i++) dp[i][0] = 1;
    dp[1][1] = 1;
    for(int i = 2; i < 2 * n; i++){
        for(int j = 1; j <= k; j++){
            dp[i][j] = dp[i - 2][j] + dp[i - 2][j - 1] * f(i, j);
        }
    }
}

int main(){
    fastio;
    int n, k;
    while(cin >> n >> k && n && k){
        memset(dp, 0, sizeof dp);
        sol(n, k);
        ll ans = 0;
        for(int i = 0; i <= k; i++){
            ans += dp[2 * n  - 1][i] * dp[2 * n - 2][k - i];
        }
        cout << ans << "\n";
    }
}
