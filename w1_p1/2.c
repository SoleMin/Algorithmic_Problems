#include <stdio.h>
#define BUFSIZE 1024

void Func(char input[]);

char input[1024];

int main() {
	Func(input);
	
	return 0;
}

void Func(char input[]) {
	while( fgets(input, BUFSIZE, stdin) != NULL ) {
		int words = 0, nbsp = 0, i = 0;
			while(1) {
				if(input[i] == ' ' || input[i] == '\t') {
					if(i == 0) {// 첫 글자가 공백인 경우.
						i++;
						continue;
					}
					if(input[i - 1] == ' ' || input[i - 1] == '\t') { // 공백이 연속된 경우
						i++;
						continue;
					}
					nbsp++;
					i++;
				}
				else if(input[i] == '\n') {
					if(input[i - 1] == ' ' || input[i - 1] == '\t')
						break;
					nbsp++;
					break;
				}
				else {
					words++;
					i++;
				}
			}
		printf("%d %d\n", words, nbsp); // 출력..
	}
}