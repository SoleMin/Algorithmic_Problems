#include <iostream>
#include <string>
using namespace std;

int main(void) {
	string line = "`1234567890-=QWERTYUIOP[]\ASDFGHJKL;'ZXCVBNM,./";
	string s;
	
	while (getline(cin, s)) {
		for (unsigned int len = 0; len < s.length(); len++) {	// s 길이만큼
			if (s.at(len) == ' ') {
				cout << ' '; continue;
			}
			for (unsigned int i = 0; i < line.length(); i++) {	// line의 문자와 비교
				if (s.at(len) == line.at(i)) {	// 같으면
					cout << line.at(i-1); break;
				}
			}
 		}
		cout << endl;
	}
	
	return 0;
}