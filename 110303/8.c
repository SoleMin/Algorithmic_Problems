#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_BUF 1000

void search(char l_str[], char s_str[], int result[]); // long_str, short_str
void set_arr(char arr[], int length);
void set_num(int result[]);
void print(int result[]);

int main() {
	char a[MAX_BUF];
	char b[MAX_BUF];
	int result[26]; // 배열의 번호는 a~z 26, 알파벳을 0(a)~25(z)로 저장
	int i;
	
	while(fgets(a, MAX_BUF, stdin) != NULL) { // a 입력
		fgets(b, MAX_BUF, stdin);               // b 입력
		set_num(result);
		//printf("Hello?\n");
		(strlen(a) / sizeof(char)) > (strlen(b) / sizeof(char)) ? search(a, b, result) : search(b, a, result);
		
		print(result);
		
		set_arr(a, strlen(a)); // 배열 a 초기화
		set_arr(b, strlen(b)); // 배열 b 초기화
	}
	
	return 0;
}

void search(char l_str[], char s_str[], int result[]) {
	int l_length = strlen(l_str) / sizeof(char);
	int s_length = strlen(s_str) / sizeof(char);
	int i, j;
	int num;
	
	for(i = 0; i < s_length; i++) {
		for(j = 0; j < l_length; j++) { // j는 작은 길이의 배열
			if(s_str[i] == NULL || l_str[j] == NULL) // 같은 단어로 인해 빠진 문자열의 위치라면 continue
				continue;
			else { // 같은 단어 빠진 문자열에서 찾기
				if(s_str[i] == l_str[j]) { // 소문자 a의 ASCII 코드 번호는 97
					num = (int)s_str[i] - 97;
					result[num]++;
					l_str[j] = NULL; // 찾은 단어 제외하기, s_str은 할 필요 X
					break;
				}
			}
		}
	}
}

void set_arr(char arr[], int length) {
	int i;
	for(i = 0; i < length; i++) {
		arr[i] = NULL;
	}
}

void set_num(int result[]) {
	int i;
	for(i = 0; i < 26; i++) {
		result[i] = 0;
	}
}

void print(int result[]) {
	int i;
	for(i = 0; i < 26; i++) {
		while(result[i] > 0) {
			printf("%c", 'a' + i);
			result[i]--;
		}
	}
	printf("\n");
}