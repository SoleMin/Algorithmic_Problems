#include <iostream>
#include <string>

using namespace std;

/*
* 문자를 만나면 플래그를 세우고
* 공백을 만나면 플래그를 제거하면서
* 글자와 단어의 수를 카운트
*/

int main() {
	string line;
	
	while (getline(cin, line)) {
		int words = 0;
		int letters = 0;
		int flag = 0; 
		int count = 0;
		for (int i = 0; i < line.size(); i++) {
			if (!flag && line[i] != ' ' && line[i] != '\t') {
				flag = 1;
				count++;
				if (i == line.size() - 1) {
					words++;
					letters++;
				}
			}
			else if (flag) {
				if (line[i] == ' ' || line[i] == '\t') {
					flag = 0;
					words++;
					letters += count;
					count = 0;
				}
				else if (i == line.size() - 1) {
					count++;
					words++;
					letters += count;
				}
				else
					count++;
			}
		}
		cout << letters << " " << words << "\n";
	}
	return 0;
}