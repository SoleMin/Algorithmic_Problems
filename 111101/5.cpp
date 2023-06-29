#include<bits/stdc++.h>

#define fastio cin.tie(nullptr) -> sync_with_stdio(false)
using namespace std;
using pii = pair<int, int>;
constexpr int MAX = 0x7f7f7f7f;
#define compress(v) sort(all(v)), (v).erase(unique(all(v)), (v).end())
int dp[1001];
pii path[1001];

struct info{
    int a, b, c;
    bool operator < (const info& i) const{
        return (a ^ i.a ? a < i.a : b > i.b);
    }
};


int lis(const vector<info>& v, int cur) {
    int& ret = dp[cur];
    if (ret != -1) return ret;
    ret = 1;
    for (int nxt = cur + 1; nxt < v.size(); nxt++) {
        if(v[cur].a < v[nxt].a && v[cur].b > v[nxt].b) {
            auto temp = lis(v, nxt) + 1;
            if (temp > ret || (temp == ret && path[cur].second > v[nxt].c)) {
                ret = temp;
                path[cur].first = nxt;
                path[cur].second = v[nxt].c;
            }
        }
    }
    return ret;
}
int main(){
    fastio;
    vector<info> v;
    int a, b, cnt = 1;
    while(cin >> a >> b && a){
        v.push_back({a, b, cnt++});
    }
    sort(v.begin(), v.end());
    memset(dp, -1, sizeof(dp));
    int ans = 0, st;
    for(int i = 0; i < cnt; i++){
        auto ret = lis(v, i);
        if(ans < ret){
            ans = ret;
            st = i;
        }
    }
    cout << ans << "\n";
    for(int i = 0; i < ans; i++){
        cout << v[st].c << "\n";
        st = path[st].first;
    }
}