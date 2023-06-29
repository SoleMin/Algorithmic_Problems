#include <bits/stdc++.h>
using namespace std;
using ll = long long; 
ll dp[10001];

int main() {
	int n; 
	memset(dp, 0x7f, sizeof dp); 
	dp[1] = 1; 
	dp[2] = 3; 
	for(int i = 3; i <= 10000; i++){
		for(int j = 1; j < min(40, i); j++){
			dp[i] = min<ll>(dp[i - j] * 2 + (1LL << j) - 1, dp[i]); 
		}	
	}
	while(cin >> n){
		cout << dp[n] << "\n"; 
	}
}