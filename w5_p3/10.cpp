#include <bits/stdc++.h>
using namespace std;
#define fastio cin.tie(nullptr)->sync_with_stdio(false)

struct KMP{
	vector<int> match(const string& s, const string& k){
		const auto table = make_table(k); 
		const int n = s.size(), m = k.size(); 
		vector<int> ret; 
		for(int i = 0, j = 0; i < n; i++){
			while(j && s[i] != k[j]) j = table[j - 1]; 
			if(s[i] == k[j] && ++j == m){
				ret.push_back(i - m + 1); 
				j = table[m - 1]; 
			} 
		}
		return ret; 
	}
	vector<int> make_table(const string& s){
		vector<int> ret(s.size()); 
		for(int i = 1, j = 0; i < (int)s.size(); i++){
			while(j && s[i] != s[j]) j = ret[j - 1]; 
			if(s[i] == s[j]) ret[i] = ++j; 
		}
		return ret; 
	}
};
int main() {
	fastio; 
	string a, b; 
	getline(cin, a); 
	getline(cin, b); 
	KMP kmp; 
	auto ret = kmp.match(a, b); 
	cout << ret.size() << "\n"; 
	for(auto i : ret){
		cout << i + 1 << " "; 
	}
	cout << "\n"; 
}