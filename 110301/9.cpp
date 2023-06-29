#include <iostream>
#include <string>

using namespace std;

string s;
string key[4] = {
	"`1234567890-=",
	"QWERTYUIOP[]\\",
	"ASDFGHJKL;'",
	"ZXCVBNM,./"
};

int main() {
	
	while(getline(cin, s)) {
		//getline(cin, s);
		//if(cin.eof()) break;
		
		string out = "";
		for(int word = 0; word < s.length(); word++) {
			if(s[word] == ' ') {
				out.push_back(s[word]);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < key[i].length(); j++) {	
					if(key[i][j] == s[word]) {
						out.push_back(key[i][j - 1]);
					}
				}
			}
		}
		cout << out << '\n';	
	}
	
	return 0;
}