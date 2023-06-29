#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

const string plain_text = "the quick brown fox jumps over the lazy dog";
	
bool isKey(string);

int main() {
	int T;
	cin >> T;
	cin.ignore();
	cin.get();
	while (T-- != 0) {
		vector<string> encrypted;
		unordered_map<char, char> map;
		string key = "";
		string s;
		while (getline(cin, s)) {
			if (s[0] < '0')
				break;
			if (isKey(s))
				key = s;
			encrypted.push_back(s);
		}
		
		if (key == "") {
			cout << "No solution.\n\n";
			continue;
		}
		
		int length = plain_text.length();
		for (int i = 0; i < length; i++)
			map.insert({ key[i], plain_text[i]});
		
		int size = encrypted.size();
		for (int i = 0; i < size; i++) {
			length = encrypted[i].length();
			for (int j = 0; j < length; j++)
				cout << map[encrypted[i][j]];
			cout << "\n";
		}
		cout << "\n";
	}
	return 0;
}

bool isKey(string s) {
	if (s.length() != plain_text.length())
		return false;
	else {
		string ans = "";
		unordered_map<char, char> map;
		int length = plain_text.length();
		for (int i = 0; i < length; i++)
			map.insert({ s[i], plain_text[i]});
		for (int i = 0; i < length; i++)
			ans += map[s[i]];
		if (ans == plain_text)
			return true;
	}
	return false;
}