#include <iostream>
#include <string>
#include <map>
using namespace std;
int main() {
	string s;
	char word[] = {'`','1','2','3','4','5','6','7','8','9','0','-','=',
								 'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
								 'A','S','D','F','G','H','J','K','L',';','\'',
								 'Z','X','C','V','B','N','M',',','.','/'
								};
	map<char, char> keyboard;
	
	for(int i = 1; i < 47; ++i)
		keyboard.insert({word[i], word[i - 1]});
	
	while(!cin.eof()) {
		getline(cin, s);
		for(auto i: s) {
			if(i == ' ') cout << ' ';
			else cout << keyboard[i];
		}
		
		cout << endl;
	}
	return 0;
}