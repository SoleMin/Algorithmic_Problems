#include <bits/stdc++.h>
using namespace std;
int dp[5000001]; 

int main() {
	int n;
	dp[1] = 1;
	dp[2] = 2; 
	dp[3] = 2; 
	for(int i = 4; i <= 5000001; i++){
		dp[i] = dp[i - dp[dp[i - 1]]] + 1; 
	}
	while(cin >> n && n){
		cout << dp[n] << "\n"; 
	}
}