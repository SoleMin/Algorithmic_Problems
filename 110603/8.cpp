#include <bits/stdc++.h>
using namespace std;
using ull = unsigned long long; 
constexpr int MOD = 1e9 + 7; 
string dp[1001] = {"0", "2", "5", "13"}; 

string f(string a, string b){
	string ret; 
	int tmp = 0; 
	while(!a.empty() || !b.empty()){
		if(!a.empty()) {tmp += a.back() - '0'; a.pop_back(); }
		if(!b.empty()) {tmp += b.back() - '0'; b.pop_back(); }
		ret.push_back(tmp % 10 + '0'); 
		tmp /= 10; 
	}
	while(tmp){
		ret.push_back(tmp % 10 + '0'); 
		tmp /= 10; 
	}
	reverse(ret.begin(), ret.end()); 
	return ret; 
}

int main() {
	int n; 
	for(int i = 4; i < 1001 ; i++) dp[i] = f(f(dp[i - 1], dp[i - 2]), f(dp[i - 1], dp[i - 3]));  
	while(cin >> n){
		cout << dp[n] << "\n"; 
	}
}