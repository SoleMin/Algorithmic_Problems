#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
	string a;
	string b;
	string result;
	
	while(cin >> a >> b) {
		int ab[2][27] = {0};
		for(char i: a) ab[0][i-97]++;
		for(char i: b) ab[1][i-97]++;
		
		for(int i = 0; i < 27; ++i) {
			if(ab[0][i] && ab[1][i]) {
				int count = min(ab[0][i], ab[1][i]);
				while(count--) result += (char) (i + 97);
			}
		}
		if(!result.empty()) cout << result;
		result = "";
		cout << endl;
	}
	return 0;
}