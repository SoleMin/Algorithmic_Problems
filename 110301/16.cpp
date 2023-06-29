# include <iostream>
# include <string>
# include <map>

using namespace std;

map<char, char> m;

/*
	하드코딩하기 싫은데...
	해답은 보였지만 좀 더 훌륭한 방법이 필요하다.
	근데 그거 고민할 시간에 코드 적으면 이미 끝냈겠다.
*/

int main(void) {
	
	string error_first = "234567890-=";
	string fixed_first = "1234567890-";
	
	string error_second = "WERTYUIOP[]\\";
	string fixed_second = "QWERTYUIOP[]";
	
	string error_third = "XCVBNM,./";
	string fixed_third = "ZXCVBNM,.";
	
	string error_fourth = "SDFGHJKL;'";
	string fixed_fourth = "ASDFGHJKL;";
	
	for(int i = 0; i < error_first.size(); i++) {
		m.insert({error_first[i], fixed_first[i]});
	}
	for (int i = 0; i < error_second.size(); i++) {
		m.insert({error_second[i], fixed_second[i]});
	}
	for (int i = 0; i < error_third.size(); i++) {
		m.insert({error_third[i], fixed_third[i]});
	}
	for (int i = 0; i < error_fourth.size(); i++) {
		m.insert({error_fourth[i], fixed_fourth[i]});
	}
	
	string input;
	while(getline(cin, input)) {
		if (input == "") {
			break;
		}
		
		for(int i = 0; i < input.size(); i++) {
			if(input[i] == ' '){
				cout << ' ';
			}
			else {
				cout << m.find(input[i])->second;
			}
		}
		cout << '\n';
	}
	
	
	
	return 0;
}