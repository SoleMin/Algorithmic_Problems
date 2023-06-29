#include <stdio.h>
#define BUFSIZE 1024
int main(void) {
	char line[BUFSIZE];
	
	// 연속으로 여러줄 입력받기
	while (fgets(line, BUFSIZE, stdin) != NULL){
		if(line[0] == '0'){ // 16진수는 0으로 시작하므로
			int hex = 0;
			sscanf(line+2, "%x", &hex); //0x 이후의 숫자를 입력받아서
			printf("%d\n", hex); //10진수로 표현
		}
		else{ //0으로 시작하지 않는 경우
			int dec = 0;
			sscanf(line, "%d", &dec); //line에 있는거 바로 입력받아서
			printf("0x%X\n", dec); //16진수로 표현
		}
	}
	return 0;
}
