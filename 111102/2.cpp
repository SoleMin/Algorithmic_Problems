#include <bits/stdc++.h>

#define fastio cin.tie(0) -> sync_with_stdio(0)
using namespace std;
constexpr int MX = 0x7f7f7f7f;
using ll = long long;

int main(){
    fastio;
    int t; cin >> t;
    while(t--){
        string a, b; cin >> a >> b;
        vector<ll> dp(b.size() + 1);
        dp[0] = 1;
        for(int i = 1; i <= a.size(); i++){
            for(int j = b.size(); j >= 1; j--){
                if(a[i - 1] ^ b[j - 1]) continue;
                dp[j] += dp[j - 1];
            }
        }
        cout << dp[(int)b.size()] << "\n"; 
    }
}