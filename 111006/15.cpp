#include<bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
using namespace std;
using ll = unsigned int;

int test = 1;
const int N = 101;
int disc[N], low[N];
string name[N];
int t = 0;

int main(){
    fastio;
    int n;
    while(cin >> n && n){
        memset(disc, 0, sizeof disc);
        memset(low, 0, sizeof low);
        vector<int> adj[N];
        set<string> S;
        map<string, int> M;
        auto dfs = [&](int now, int prev, auto&& dfs) -> int{
            int child = 0;
            low[now] = disc[now] = ++t;
            for(const auto& nxt : adj[now]){
                if(nxt == prev) continue;
                if(disc[nxt] == 0){
                    ++child;
                    dfs(nxt, now, dfs);
                    if(prev != -1 && disc[now] <= low[nxt]) S.insert(name[now]);
                    low[now] = min(low[now], low[nxt]);
                }else{
                    low[now] = min(low[now], disc[nxt]);
                }
            }
            return child;
        };

        for(int i = 1; i <= n; i++){
            string s; cin >> s;
            M[s] = i;
            name[i] = s;
        }
        int m; cin >> m;
        while(m--){
            string a, b; cin >> a >> b;
            adj[M[a]].push_back(M[b]);
            adj[M[b]].push_back(M[a]);
        }
        for(int i = 1; i <= n; i++){
            if(disc[i] == 0){
                if(dfs(i, -1, dfs) > 1) S.insert(name[i]);
            }
        }
        cout << "City map #" << test++ << ": " << S.size() << " camera(s) found" << "\n";
        for(const auto& i : S){
            cout << i << "\n";
        }
		cout << "\n"; 
    }
}