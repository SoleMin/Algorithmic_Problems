#include <bits/stdc++.h>
using namespace std;

string board[51]; 


void check(int n, int m, string s){
	for(int i = 0; i < n; i++) for(int j = 0; j < m; j++){
		if(board[i][j] == s[0]){
			bool flag = 1; 
			for(int k = 0; k < s.size(); k++) if((board[i][k + j] != s[k] && k + j < m) || k + j >= m) flag = 0; 
			if(flag) {cout << i + 1 << " " << j + 1 << "\n"; return; }
			for(int k = 0; k < s.size(); k++) if((board[i + k][j] != s[k] && i + k < n) || i + k >= n) flag = 1; 
			if(!flag) {cout << i + 1 << " " << j + 1 << "\n"; return; }
			for(int k = 0; k < s.size(); k++) if((board[i + k][j + k] != s[k] && i + k < n && j + k < m) || i + k >= n || j + k >= m) flag = 0; 
			if(flag) {cout << i + 1 << " " << j + 1 << "\n"; return; }
			for(int k = 0; k < s.size(); k++) if(board[i + k][j - k] != s[k] && i + k < n && j - k >= 0 || i + k >= n || j - k < 0) flag = 1; 
			if(!flag) {cout << i + 1 << " " << j + 1 << "\n"; return; }
		}
		if(board[i][j] == s[s.size() - 1]){
			reverse(s.begin(), s.end()); 
			bool flag = 1; 
			for(int k = 0; k < s.size(); k++) if(board[i][j + k] != s[k] && k + j < m || k + j >= m) flag = 0; 
			if(flag) {cout << i + 1 << " " << j + s.size() << "\n"; return; }
			for(int k = 0; k < s.size(); k++) if(board[i + k][j] != s[k] && i + k < n || i + k >= n) flag = 1; 
			if(!flag) {cout << i + s.size() << " " << j + 1 << "\n"; return; }
			for(int k = 0; k < s.size(); k++) if(board[i + k][j + k] != s[k] && i + k < n && j + k < m || i + k >= n || j + k >= m) flag = 0; 
			if(flag) {cout << i + s.size() << " " << j + s.size() << "\n"; return; }
			for(int k =0; k < s.size(); k++) if(board[i + k][j - k] != s[k] && i + k < n && j - k >= 0 || i + k >= n || j - k < 0) flag = 1; 
			if(!flag) {cout << i + s.size() << " " << j - s.size() + 2 << "\n"; return; }
			reverse(s.begin(), s.end()); 
		}
	}
}
int main() {
	int t; cin>>t; 
	while(t--){
		int n, m; cin>>n>>m; 
		for(int i = 0; i < n; i++) {
			cin>>board[i]; 
			for(int j = 0; j < m; j++) board[i][j] = tolower(board[i][j]); 
		}
		int k; cin>>k; 
		for(int i = 0; i < k; i++){
			string s; cin>>s; 
			for(auto& i : s) i = tolower(i); 
			check(n, m, s); 
		}
		cout << "\n"; 
	}
}