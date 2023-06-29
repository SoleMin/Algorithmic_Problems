#include <stdio.h>
#include <string.h>

#define BUFSIZE 1024

//입력 각 줄에 있는 단어 수와 공백을 제외한 글자 수 출력
//단어 사이 공백 여러 개 가능
//처음과 끝에 공백 가능

int main() {
	
	char line[BUFSIZE];
	
	while (fgets(line, BUFSIZE, stdin) != NULL) {
		int words=0, letters=0, i=0;
		while (line[i] != '\n' && strlen(line) > i) {
			if ((i==0 && (line[i] != ' ' && line[i] != '\t'))
					|| (i > 0 && (line[i-1] == ' ' || line[i-1] == '\t')
						 && (line[i] != ' ' && line[i] != '\t')))
				words++;
			if (line[i] != ' ' && line[i] != '\t')
				letters++;
			i++;
		}
		printf("%d %d\n", letters, words);
	}
	return 0;
}
