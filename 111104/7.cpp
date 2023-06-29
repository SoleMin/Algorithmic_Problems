#include<bits/stdc++.h>

#define fastio cin.tie(nullptr) -> sync_with_stdio(false)
using namespace std;
using pii = pair<int, int>;
vector<pii> v;
int dp[5610];
const int MAX = 0x7f7f7f7f;

int main(){
    fastio;
    int a, b;
    while(cin >> a >> b){
		if(b < a) continue; 
        v.push_back({a, b});
    }
    memset(dp, 0x7f, sizeof dp);
    sort(v.begin(), v.end(), [&](const pii& a, const pii& b) -> bool{
        return a.second ^ b.second ? a.second < b.second : a.first > b.first; 
    });
    dp[0] = 0;
	int cnt = 0; 
    for(int i = 0; i < v.size(); i++){
        for(int j = v.size() - 1; j >= 1; j--){
            if(dp[j - 1] + v[i].first <= v[i].second){
                dp[j] = min(dp[j], dp[j - 1] + v[i].first);
            }
            if(dp[j] < MAX){
                cnt = max(cnt, j);
            }
        }
    }
    cout << cnt << "\n";
}