#include <stdio.h>
#define BUFSIZE 1024

int main() {
	char line[BUFSIZE];
	while (fgets(line, BUFSIZE, stdin) != NULL ) {
		int words = 0, letters = 0, i = 0;
		while (line[i] != '\n' && strlen(line) > i) {
			if ((i == 0 && (line[i] !=' ' && line[i] != '\t')) || (i >0 && (line[i-1] == ' ' || line[i-1] == '\t') && (line[i] != ' ' && line[i] != '\t')))
					words++;
				if(line[i] != ' ' && line[i] != '\t') 	letters++;
			i++;
					}
					printf("%d %d\n", letters, words);				
	}	
	return 0;
	}
					//첫주 과제는 한번 받아쓰기 해보고 내용을 이해하기위해 노력해봤습니다. 다만 테스트에서 안되는 이유를 모르겠습니다. ㅎㅎ 그냥 입력하면 값이 나옵니다.근데 왜 실행결과가 실행결과가 불일치인지 잘모르겠습니다.

