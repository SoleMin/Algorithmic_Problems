#include <iostream>
#include <string>
#include <map>
using namespace std;

string sentence = "the quick brown fox jumps over the lazy dog";
int blankarr[8] = {3, 9, 15, 19, 25, 30, 34, 39};

int main() {
	int t, index, blankcount;
	map<char, char> m;
	cin >> t;
	cin.ignore();
	string line;
	getline(cin, line);
	while (t--) {
		string lines[100] = {"",};
		m.clear();
		index = 0;
		while (getline(cin, line)) {
			blankcount = 0;
			if (line.empty())
				break;
			lines[index++] = line;
			if (line.length() == sentence.length()
					&& line.at(2) == line.at(28) && line.at(28) == line.at(33)
				 	&& line.at(1) == line.at(32) && line.at(11) == line.at(29)
				 	&& line.at(0) == line.at(31) && line.at(5) == line.at(21)
				 	&& line.at(12) == line.at(17) && line.at(17) == line.at(26)
				 	&& line.at(26) == line.at(41)) {
				for (int i = 0; i < 8; i++) 
					if (line.at(blankarr[i]) == sentence.at(blankarr[i])) {
						blankcount++;
					}
				if (blankcount != 8)
					continue;
				else {
					for (int i = 0; i < line.length(); i++)
						if (line.at(i) != ' ' && !m.count(line.at(i))) {
							m.insert({line.at(i), sentence.at(i)});
						}
				}
			}
		}
		if (m.empty() || m.size() < 26)
			cout << "No solution." << endl;
		else {
			for (int i = 0; i < index; i++) {
				for (int j = 0; j < lines[i].length(); j++) {
					if (lines[i][j] != ' ') 
						lines[i][j] = m.find(lines[i][j])->second;
				}
			}
			for (int i = 0; i < index; i++)
				cout << lines[i] << endl;
		}
		cout << endl;
	}
	
	return 0;
}