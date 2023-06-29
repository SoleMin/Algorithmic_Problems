#include <iostream>
#include <string>

using namespace std;

int main() {
	string key[4] = {"1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;'", "ZXCVBNM,./"};
	string line;
	while(getline(cin, line)){
		int i = 0;
		string s;
		while(line[i]){
			char c = line[i];
			if(key[0].find(c) != string::npos){
				s = s + key[0][key[0].find(c) - 1];
			}
			else if(key[1].find(c) != string::npos){
				s = s + key[1][key[1].find(c) - 1];
			}
			else if(key[2].find(c) != string::npos){
				s = s + key[2][key[2].find(c) - 1];
			}
			else if(key[3].find(c) != string::npos){
				s = s + key[3][key[3].find(c) - 1];
			}
			else{
				s = s + " ";
			}
			i++;
		}
		cout << s << endl;
	}
	
	return 0;
}