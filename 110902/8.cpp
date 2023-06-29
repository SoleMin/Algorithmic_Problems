#include<bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr)->sync_with_stdio(false)

const int mn = 10001;
int main(){
    fastio;
    int t; cin >> t;
    while(t--){
        vector<int> st, en;
        for(int i =0; i < 4; i++) {
            int a; cin >> a;
            st.push_back(a);
        }
        for(int i =0; i < 4; i++){
            int a; cin >> a;
            en.push_back(a);
        }
        int n; cin >> n;
        vector<vector<int>> v(n);
        for(int j =0; j < n; j++){
            vector<int> ret;
            for(int i =0; i < 4; i++){
                int a; cin >> a;
                ret.push_back(a);
            }
            v[j] = ret;
        }
        map<vector<int>, bool> M;
        auto bfs = [&](vector<int>& st, vector<int>& en) -> int{
            queue<pair<int, vector<int>>> Q;
            Q.push({0, st});
            int ret = -1;
            while(!Q.empty()){
                auto [num, now] = Q.front(); Q.pop();
                if(now == en){
                    return num;
                }
                for(int i =0; i < 4; i++){
                    auto p = now, r = now;
                    if(p[i] == 9) p[i]= 0;
                    else if(p[i] + 1 <= 9) p[i] += 1;
                    if(find(v.begin(), v.end(), p) == v.end() && M[p] == 0){
                        Q.push({num + 1, p});
                        M[p] = 1;
                    }
                    if(r[i] == 0) r[i] = 9;
                    else if(r[i] - 1 >= 0) r[i] -= 1;
                    if(find(v.begin(), v.end(), r) == v.end() && M[r] == 0){
                        Q.push({num + 1, r});
                        M[r] = 1;
                    }
                }
            }
            return ret;
        };
        cout << bfs(st, en) << "\n";
    }
}