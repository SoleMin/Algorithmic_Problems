#include <bits/stdc++.h>

#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;
using ll = long long;

int state[8];
int k, n;
string s;

bool check(int i){
    vector<int> v(s.size());
    string ans; ans.resize(s.size());
    for(int j = 0, t = i; t; j++, t >>= 1){
        if(t & 1) v[j] = 1;
    }
    for(int j = 0; j < s.size(); j++){
        auto ret = 0;
        if(j == 0){
            ret = 4 * v[s.size() - 1] + 2 * v[0] + v[1];
        }
        else if(j == s.size() - 1){
            ret = 4 * v[s.size() - 2] + 2 * v[s.size() - 1] + v[0];
        }
        else{
            ret = 4 * v[j - 1] + 2 * v[j] + v[j + 1];
        }
        ans[j] = state[ret] + '0';
    }
    if(ans == s) return 1;
    return 0;
}

int main() {
    fastio;
    while(cin >> k >> n >> s){
        memset(state, 0, sizeof state);
        for (int i = 0, t = k; t; i++, t >>= 1) {
            if (t & 1) state[i] = 1;
        }
        bool flag = 0;
        for(int i = 0; i < (1 << s.size()); i++){
            if(check(i)) {
                flag =1;
                break;
            }
        }
        cout << (flag ? "REACHABLE" : "GARDEN OF EDEN") << "\n";
    }
}
