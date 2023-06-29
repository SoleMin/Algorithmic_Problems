#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
	unordered_map<char, char> map;
	for (char i = '1'; i <= '8'; i++)
		map.insert({i + 1, i});
	map.insert({'0', '9'});
	map.insert({'-', '0'});
	map.insert({'=', '-'});
	map.insert({'W', 'Q'});
	map.insert({'E', 'W'});
	map.insert({'R', 'E'});
	map.insert({'T', 'R'});
	map.insert({'Y', 'T'});
	map.insert({'U', 'Y'});
	map.insert({'I', 'U'});
	map.insert({'O', 'I'});
	map.insert({'P', 'O'});
	map.insert({'[', 'P'});
	map.insert({']', '['});
	map.insert({'\\', ']'});
	map.insert({'S', 'A'});
	map.insert({'D', 'S'});
	map.insert({'F', 'D'});
	map.insert({'G', 'F'});
	map.insert({'H', 'G'});
	map.insert({'J', 'H'});
	map.insert({'K', 'J'});
	map.insert({'L', 'K'});
	map.insert({';', 'L'});
	map.insert({'\'', ';'});
	map.insert({'X', 'Z'});
	map.insert({'C', 'X'});
	map.insert({'V', 'C'});
	map.insert({'B', 'V'});
	map.insert({'N', 'B'});
	map.insert({'M', 'N'});
	map.insert({',', 'M'});
	map.insert({'.', ','});
	map.insert({'/', '.'});
	map.insert({' ', ' '});
	
	string s;
	while (getline(cin, s)) {
		string ans = "";
		int length = s.length();
		for (int i = 0; i < length; i++)
			ans += map[s[i]];
		cout << ans << "\n";
	}
	
	return 0;
}