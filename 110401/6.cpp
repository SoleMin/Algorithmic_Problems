#include <bits/stdc++.h>
using namespace std;
int main() {
	int t; cin>>t; 
	while(t--){
		int n; cin>>n; 
		vector<int> v; 
		for(int i = 0; i < n; i++){
			int a; cin>>a; 
			v.push_back(a); 
		}
		sort(v.begin(), v.end()); 
		int ans = 0x7f7f7f7f; 
		for(int i = 0; i < n; i++){
			auto tmp = 0; 
			for(int j = 0; j < n; j++){
				tmp += abs(v[i] - v[j]);
			}
			if(ans > tmp){
				ans = tmp; 
			}
		}
		cout << ans << "\n"; 
	}
}