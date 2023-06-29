#include <iostream>
#include <string>
#include <vector>
using namespace std;
vector<string> split(string s);
int main() {
	string s, fmt;
	while(true) {
		getline(cin, s);
		if(cin.eof()) break;
		vector<string> str = split(s);
		
		if(s.empty()) {
			if(!fmt.empty()) cout << fmt << endl << endl;
			fmt = "";
		} else {
			for(auto i: str) {
				if(fmt.length() + i.length() > 72) {
					if(!fmt.empty()) cout << fmt << endl;
					fmt = "";
				}
				fmt.append(i + ' ');
			}
		}
	}
	cout << fmt;
	if(!s.empty()) cout << s;
	return 0;
}

vector<string> split(string s) {
	string temp;
	vector<string> str;
	for(char i: s) {
		if(i == ' ') {
			str.push_back(temp);
			temp = "";
		} else temp += i;
	}
	str.push_back(temp);
	return str;
}