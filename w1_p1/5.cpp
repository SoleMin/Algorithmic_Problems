#include <iostream>
#include <string>
using namespace std;
int main() {
	// 저장할 문장
	string line;
	
	while(getline(cin, line)) {
		// 저장할 글자수; 단어수;
		int words = 0, letters = 0;
		
		// line 탐색
		for (int i = 0; i < line.length(); i++) {
			// 첫 글자가 공백이거나, 그 외의 글자들에서 앞글자가 공백이면서, 현재글자가 문자인 경우,
			if ((i == 0 && (line[i] != ' ' && line[i] != '\t')) || (i > 0 && (line[i - 1] == ' ' || line[i - 1] == '\t') && (line[i] != ' ' && line[i] != '\t')))
				words++;
			// 공백이 아닌 문자라면
			if (line[i] != ' ' && line[i] != '\t')
				letters++;
		}
		cout << letters << " " << words << endl;
	}
	return 0;
}