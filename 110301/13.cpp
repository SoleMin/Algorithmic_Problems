#include <iostream>
#include <string>
using namespace std;
int main() {
	
	string keyboard[4] = {"`1234567890-=", "QWERTYUIOP[]", "ASDFGHJKL;'", "ZXCVBNM,./"};
	string str;
	string line = "";
	char word;
	
	while(!cin.eof()) {
		line = "";
		
		getline(cin, str);
		
		for(int i = 0; i < str.length(); i++) {
			word = str[i];
			if(word == ' ') {
				line += ' ';
			}
			
			for(int x = 0; x < 4; x++) {
				for(int y = 0; y < keyboard[x].length(); y++) {
					if (word == keyboard[x][y]) {
						line += keyboard[x][y-1];
					}
				}
			}
		}
		cout << line << endl;
	}
	
	return 0;
}