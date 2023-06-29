#include <iostream>
#include <cstring>
using namespace std;

#define MAX_LEN 1000

int main(void) {
	char a[MAX_LEN + 1];
	char b[MAX_LEN + 1];
	int letter_a[26] = {0, };
	int letter_b[26] = {0, };
	char ch;
	int count;
	while (cin.getline(a, MAX_LEN + 1) && cin.getline(b, MAX_LEN + 1)) {
		// 어떤 철자가 있는지
		for (unsigned int i = 0; i < strlen(a); i++) {
			letter_a[a[i] - 'a']++;	// a에 들어있는 철자 얻기
		}
		for (unsigned int j = 0; j < strlen(b); j++) {
			letter_b[b[j] - 'a']++;	// b에 들어있는 철자 얻기
		}
		
		// 출력
		for (int k = 0; k < 26; k++) {	// 영어 소문자 char 범위 검사 [a-z]
			if (letter_a[k] && letter_b[k]) {	// a, b 모두 철자를 가지고 있으면
				ch = 97 + k;	// a, b, c, ..., z : 현재 문자
				count = letter_a[k] <= letter_b[k] ? letter_a[k] : letter_b[k];	// 더 적은 개수
				for (int c = 0; c < count; c++)	// count만큼
					cout << ch;	// 문자 출력
			}
		}
		
		// 초기화
		for (int i = 0; i < 26; i++) {
			letter_a[i] = 0;
			letter_b[i] = 0;
		}
		cout << endl;
	}
	
	return 0;
}