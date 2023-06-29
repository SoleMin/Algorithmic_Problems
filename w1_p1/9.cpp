#include <iostream>
#include <string>

using namespace std;
int main() {
	string s;
	while(getline(cin, s)) {
		int word = 0, letter = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s[i] != ' ' && s[i] != '\t')
				letter++;
			if((i > 0 && (s[i] == ' ' || s[i] == '\t') && (s[i - 1] != ' ' && s[i - 1] != '\t')) || (i == s.length() - 1) && (s[i] != ' ' && s[i] != '\t'))
				word++;
		}
		cout << letter << ' ' << word << endl;
	}	
	
	return 0;
}