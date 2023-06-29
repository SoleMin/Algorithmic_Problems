#include <bits/stdc++.h>
using namespace std;

struct info{
	int t, s, k; 
	bool operator<(const info& i) const {
		return t * i.s ^ i.t * s ? t * i.s < i.t * s : k < i.k; 
	}
}; 

int main() {
	int t; cin>>t; 
	while(t--){
		vector<info> v; 
		int n; cin >>n; 
		for(int i = 1; i <= n; i++){
			int a, b; cin>>a>>b; 
			v.push_back({a, b, i}); 
		}
		sort(v.begin(), v.end()); 
		for(auto [t, s, k] : v){
			cout << k << " "; 
		}
		cout << "\n" <<"\n"; 
	}
}