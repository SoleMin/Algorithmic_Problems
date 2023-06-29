#include <bits/stdc++.h>
using namespace std;

int dp[101][2]; 

int main() {
	int t; cin>>t; 
	while(t--){
		memset(dp, 0, sizeof dp); 
		int n; cin>>n; 
		vector<int> v; 
		for(int i = 0; i < n; i++){
			int a; cin>>a; 
			v.push_back(a); 
		}
		sort(v.begin(), v.end()); 
		int ans = 0; 
		for(int i = n - 1; i >= 3; i -= 2){
			if(v[1] * 2 >= v[0] + v[i - 1]) continue; 
			ans += v[0] + v[1] + v[i] + v[1]; //1, 2가고, 1, 오고, 5, 10, 가고, 2 온다. 
			v.pop_back();
			v.pop_back(); 
		}
		for(int i = v.size() - 1; i >= 2; i--){
			ans += v[0] + v[i]; 
		}
		cout << ans  + v[1] << "\n" << "\n"; 
	}
}