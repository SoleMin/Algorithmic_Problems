#include<bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
using namespace std;
using pii = pair<int, int>;

int main(){
    fastio;
    int t; cin >> t;
    while(t--){
        int dist[501];
        int k, n; cin >> k >> n;
        vector<int> fs;
        for(int i =0; i < k; i++){
            int a; cin >> a;
            fs.push_back(a);
        }
        vector<vector<pii>> v(n + 1);
        for(int i = 1; i <= n; i++){
            int a, b, c; cin >> a >> b >> c;
            v[a].push_back({b, c});
            v[b].push_back({a,c});
        }
        auto dijkstra = [&](int i) -> int{
            memset(dist, 0x3f, sizeof dist);
            priority_queue<pii, vector<pii>, greater<pii>> P;
            for(auto V : fs){
                dist[V] = 0;
                P.push({0, V});
            }
            dist[i] = 0;
            P.push({0, i});
            while(!P.empty()){
                auto [cost, now] = P.top(); P.pop();
                if(dist[now] < cost) continue;
                for(const auto& [nxt, w] : v[now]){
                    if(dist[nxt] > cost + w){
                        dist[nxt] = cost + w;
                        P.push({cost + w, nxt});
                    }
                }
            }
            int ret = 0;
            for(int j = 1; j <= n; j++){
                ret = max(ret, dist[j]);
            }
            return ret;
        };
        pii ans = {1 << 21, -1};
        for(int i = 1; i <= n; i++){
            if(find(fs.begin(), fs.end(), i) == fs.end()){
                auto ret = dijkstra(i);
                if(ans.first > ret) {
                    ans.first = ret;
                    ans.second = i;
                }
            }
        }
        cout << ans.second << "\n" << "\n";
    }
}