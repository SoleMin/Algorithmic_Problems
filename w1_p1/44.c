#include <stdio.h>
#define BUF_SIZE 1024

// \n, \t, 
// 글자수 chCount, 단어수 wordCount
int main() {
	char words[BUF_SIZE];
	
	while(gets(words) != NULL) {	// null 아닐 때까지 입력받기
		int chCount = 0, wordCount = 0, i = 0;	// 초기화
		// 공백 만나면 wordCount++
		// 공백 만나지 않으면 chCount++
		while (words[i] != '\n' && i < strlen(words)) {	// words 길이만큼 돌리다가 \n 만나면 그만.
			// \t, sp
			// i == 0 , i > 0
			if ( words[i] != ' ' && words[i] != '\t' ) {
				chCount++;
				if (i == 0) wordCount++;
			}
			if ( i > 0 && (words[i-1] == ' ' || words[i-1] == '\t') && (words[i] != ' ' && words[i] != '\t') ) {
				// i > 0이고, 이전 문자가 공백이고, 현재 문자가 공백이 아니면 wordCount++ 
				// $문제점$ ( w != ' ' || w != '\t' ) $해결$ ( w != ' ' && w != '\t' )
				wordCount++;
			}
			i++;
		}
		printf("%d %d\n", chCount, wordCount);
	}
	
	return 0;
}
