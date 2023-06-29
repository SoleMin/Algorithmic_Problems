#include <iostream>
using namespace std;

int main() {
	char ch[1025] = {0, };
	while (cin.getline(ch, 1025)) {
		int word = 0, character = 0, i = 0;
		while (ch[i] != '\0' && ch[i] != '\r' && ch[i] != '\n') {
			if (ch[i] != ' ' && ch[i] != '\t') {
				character++;
			}
			if ((i == 0 && (ch[i] != ' ' && ch[i] != '\t')) || (i > 0 && (ch[i-1] == ' ' || ch[i-1] == '\t') && (ch[i] != ' ' && ch[i] != '\t'))) {
				word++;
			}
			i++;
		}
		cout << character << " " << word << "\n";
	}
	return 0;
}