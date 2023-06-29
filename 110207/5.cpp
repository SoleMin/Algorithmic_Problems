#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr) -> sync_with_stdio(false); 

struct info{
	int n, k, t; 
	char c; 
	bool operator<(const info& i) const{
		if(t == i.t) return c > i.c; 
		return t < i.t; 
	}
};
struct info2{
	int n, m, t, p; 
	bool operator<(const info2& i) {
		if(m == i.m){
			if(p == i.p){
				return n < i.n; 
			}
			return p < i.p; 
		}
		return m > i.m;
	}
};

int main() {
	fastio; 
	int t; cin>>t; cin.ignore(); 
	while(t + 1){
		vector<info> v; 
		while(1){
			string s; 
			vector<int> w; 
			getline(cin, s); 
			if(s == ""){t--; break;}
			string tmp; 
			char c; 
			for(int i = 0; i < s.size(); i++){
				if(s[i] == ' ') {
					w.push_back(stoi(tmp)); 
					tmp.clear(); 
				} 
				if(isdigit(s[i]))tmp.push_back(s[i]); 
				if(s[i] == 'I' || s[i] == 'C' || s[i] == 'R' || s[i] == 'L' || s[i] == 'E') c = s[i]; 
			}
			v.push_back({w[0], w[1], w[2], c}); 
			w.clear(); 
		}
		if(!v.empty()){
			sort(v.begin(), v.end());
			map<int, pair<int, int>> M; 
			vector<vector<int>> arr(101, vector<int>(10)); 
			vector<vector<int>> arr2(101, vector<int>(10)); 
			vector<int> k(101); 
			for(int i = 0; i < v.size(); i++){
				if(v[i].c == 'C'){
					if(arr2[v[i].n][v[i].k])continue; 
					M[v[i].n].first++; 
					M[v[i].n].second += (v[i].t + arr[v[i].n][v[i].k]); 
					k[v[i].n] += arr[v[i].n][v[i].k]; 
					arr2[v[i].n][v[i].k]++; 
				}
				else if(v[i].c == 'I'){
					arr[v[i].n][v[i].k] += 20; 
					M[v[i].n]; 

				}
				else{
					M[v[i].n].first = 0; 
					M[v[i].n].second = 0; 
				}
			}
			vector<info2> T; 
			for(auto i : M){
				T.push_back({i.first, i.second.first, i.second.second, k[i.first]}); 
			}
			sort(T.begin(), T.end()); 
			for(auto [a, b, c, d] : T){
				cout << a << " " << b << " " << c << "\n"; 
			}
			cout << "\n"; 
		} 
	}
}