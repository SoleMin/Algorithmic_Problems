#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr) -> sync_with_stdio(false)
constexpr int MAX{0x7f7f7f7f}; 
int ans = 0; 
int main() {
	fastio; 
	int t; cin>>t; 
	while(t--){
		int n, m; cin>>n>>m; 
		cin.ignore(); 
		vector<vector<int>> adj(10010); 
		map<string, int> M; 
		int num = 0; 
		for(int i = 1; i <= n; i++){
			string s; 
			getline(cin, s); 
			s = " " + s; 
			vector<int> v; 
			bool flag = 1; 
			string tmp; 
			for(int j = 0; j < s.size(); j++){
				if(s[j] == ','){
					flag ^= 1; 
					if(flag){
						j++; 
						if(!M[tmp]) M[tmp] = ++num; 
						v.push_back(M[tmp]); 
						tmp.clear(); 
						}
					}
				tmp.push_back(s[j]); 
				if(s[j] == ':'){
					tmp.pop_back(); 
					if(!M[tmp]) M[tmp] = ++num; 
					v.push_back(M[tmp]); 
					break; 
				}
			}
			for(auto u : v) for(auto v : v){
				if(u == v) continue; 
				adj[u].push_back(v); 
			}
		}
		vector<int> dist(10010, MAX); 
		auto bfs = [&](auto& dist, int st) -> void{
			dist[st] = 0; 
			queue<int> Q; 
			Q.push(st); 
			while(!Q.empty()){
				auto now = Q.front(); Q.pop(); 
				for(auto nxt : adj[now]){
					if(dist[nxt] > dist[now] + 1){
						dist[nxt] = dist[now] + 1;
						Q.push(nxt); 
					}
				}
			}
		};
		cout << "Scenario " << ++ans << "\n"; 
		auto ret = M[" Erdos, P."]; 
		bfs(dist, ret); 
		while(m--){
			string s; 
			getline(cin, s); 
			cout << s; 
			s = " " + s; 
			(dist[M[s]] == MAX ? cout << " infinity" << "\n" : cout << " " << dist[M[s]] << "\n"); 
		}
	}
}