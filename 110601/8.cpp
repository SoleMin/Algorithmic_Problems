#include <bits/stdc++.h>
using namespace std;

string dp[1112] = {"0", "1"}; 

bool operator<=(const string& a, const string& b){
	bool flag = 0; 
	if(a.size() == b.size()){
		for(int i = 0; i < a.size(); i++){
			if(a[i] == b[i]) continue; 
			return a[i] < b[i]; 
		}
		return 1; 
	}
	return a.size() < b.size(); 
}

string f(string a, string b){
	string ret; 
	int tmp = 0; 
	while(!a.empty() || !b.empty()){
		if(!a.empty()) {tmp += a.back() - '0'; a.pop_back();}
		if(!b.empty()) {tmp += b.back() - '0'; b.pop_back();}
		ret.push_back((tmp % 10) + '0'); 
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
	string n, m; 
	for(int i = 2; i <= 1111; i++){
		dp[i] = (f(dp[i - 1], dp[i - 2])); 
	}
	while(cin >>n>>m && n != "0" && m != "0"){
		int ans = 0; 
		for(int i = 2; i <= 1111; i++){
			if(n <= dp[i] && dp[i] <= m) ans++; 
		}
		cout << ans << "\n"; 
	}
}