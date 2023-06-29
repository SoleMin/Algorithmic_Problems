#include<bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr) -> sync_with_stdio(false)

const int mn = 201;
int a[mn];
int adj[mn][mn];

int main(){
    fastio;
    int n, m;
    while(cin >>n&& n){
        cin >>m;
        memset(adj, 0, sizeof adj);
        memset(a, 0, sizeof a);
        for(int i =0; i < m; i++){
            int u, v; cin >> u >>v;
            adj[v][u] = adj[u][v] = 1;
        }
		bool flag = 1; 
        auto dfs = [&](int now, int c, auto&& dfs) -> void{
            a[now] = c;
            for(int i =0; i < n; i++){
                if(adj[now][i] == 0) continue;
                if(a[i] == 0) dfs(i, c % 2 + 1,dfs);
                else{
                    if(a[i]== c) {flag = 0; return;}
                }
            }
        };
        dfs(0, 1, dfs); 
		flag ? cout << "BICOLORABLE." << "\n" : cout << "NOT BICOLORABLE." << "\n";
    }
}