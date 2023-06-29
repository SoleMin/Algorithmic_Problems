#include <iostream>
#include <string>

using namespace std;

string ans = "the quick brown fox jumps over the lazy dog";
string s[101];
char m[30];

int main() {
	int t; cin >> t;
	cin.get();
	cin.get();
	while(t--) {
		// initial
		for(int i = 0; i < 30; i++)
			m[i] = 0;
		for(int i = 0; i < 101; i++)
			s[i] = "";
		
		int len = 0;
		for(int i = 0; i < 100; i++) {
			getline(cin, s[i]);
			if(s[i] == "") break;
			len++;
		}
		
		bool isAnsExist = false;
		for(int i = 0; i < len; i++) {
			if(s[i].length() != ans.length()) continue;
			bool isAns = true;
			for(int j = 0; j < ans.length(); j++) {
				if(ans[j] == ' ' && s[i][j] != ' ') {
					isAns = false;
					break;
				}
				if(ans[j] == ' ') continue;		// 공백은 패스
				
				int curChar = s[i][j] - 'a';
				if(!m[curChar])
					m[curChar] = ans[j];
				else if(m[curChar] != ans[j]) {
					isAns = false;
					break;
				}
			}
			if(isAns) {
				isAnsExist = true;
				break;
			}
		}
		
		// print
		if(!isAnsExist)
			cout << "No solution.\n";
		else {
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < s[i].length(); j++) {
					if(s[i][j] == ' ') {
						cout << ' ';
						continue;
					}
					int curChar = s[i][j] - 'a';
					cout << m[curChar];
				}
				cout << '\n';
			}
		}
		cout << '\n';
	}
	
	
	return 0;
}