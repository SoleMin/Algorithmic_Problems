#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr)->sync_with_stdio(false)

string str{" QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./1234567890-="}; 

int main() {
	fastio; 
	string s; 
	while(getline(cin, s)){
		string ans; 
		for(int i = 0; i < s.size(); i++){
			auto ret = s[i]; 
			for(int j = 0; j < str.size(); j++){
				if(ret == ' '){
					ans.push_back(ret); 
					break; 
				}
				if(ret == str[j]) {
					ret = str[j - 1]; 
					ans.push_back(ret); 
				}
			}
		}
		cout << ans << "\n"; 
	}
}