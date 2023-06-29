#include <iostream>
#include <string>
using namespace std;
int main() {
	
	string str;
	
	while(getline(cin, str)) {
		int letter_cnt = 0;
		int word_cnt = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if ((i > 0 && (str[i-1] == ' ' || str[i-1] == '\t') && (str[i] != ' ' && str[i] != '\t')) || (i == 0 && str[i] != ' ' && str[i] != '\t')) {
				word_cnt += 1;
			}
			
			if(str[i] != ' ' && str[i] != '\t') {
				letter_cnt += 1;
			}
		}
		
		cout << letter_cnt << " " << word_cnt << endl;
		
	}
	
	return 0;
}