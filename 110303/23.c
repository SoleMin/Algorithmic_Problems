#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void main() {
	
	char line[1000];
	int i, j;
	
	while(gets(line)) {
		char case1[1000];
		char case2[1000];
		char result[1000];
		int count = 0;
		char temp;
		
		strcpy(case1, line);
		gets(case2);
		
		for (i = 0; i < strlen(case1); i++) {
			for (j = 0; j < strlen(case2); j++) {
				if(case1[i] == case2[j]) {
					result[count] = case1[i];
					case2[j] = "0";	// 입력받는 문자열에 포함되지 않는 문자열로 치환 / 중복방지
					count++;
					break;
				}
			}
		}
		result[count] = '\0';
		
		for (i = 0; i < strlen(result)-1; i++) {
			for (j = 0; j < strlen(result)-1; j++) {
				if(result[j] > result[j+1]) {
					temp = result[j];
					result[j] = result[j+1];
					result[j+1] = temp;
				}
			}
		}
		
		printf("%s\n", result);
	}
}
