#include <stdio.h>

int main() {
	int hex = 0, dec = 0;
	char buf[11];	// int값 2,147,483,647 ...
	
	while (gets(buf)) {
		if (buf[0] == '0') {	// hex -> dec
			//memcpy(buf, buf+2, strlen(buf) + 1);	// 16진수로 받으면 '0x' 이후의 문자열 복사
			memmove(buf, buf+2, strlen(buf) + 1);		// ㄴㅇㄱ!! memcpy가 마음에 걸려 찾아보다가 발견
			sscanf(buf, "%x", &dec);	// 16진수 정수로 dec에 받기
			printf("%d\n", dec);	// 10진수로 출력
		}
		else {	// hex -> dec
			sscanf(buf, "%d", &hex);
			printf("0x%X\n", hex);	// 0x도 함께 출력하고 대문자.
		}
	}
	
	return 0;
}
