#include <stdio.h>
#define BUFSIZE 1024
int main() {
	char line[BUFSIZE];
	while(fgets(line, BUFSIZE, stdin) != NULL) {
		if(line[0] == '0') { // 16진수면 
			int hex = 0;
			sscanf(line + 2, "%x", &hex); // lin의 0x 문자 스킵
			printf("%d\n", hex); // 정수형으로 출력
		}
		else {
			int dec = 0;
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
}
