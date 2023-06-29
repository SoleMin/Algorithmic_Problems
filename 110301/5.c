#include <stdio.h>
#include <string.h>
int main() {
	char input[100];
	char upup[20] = "`1234567890-=";
	char up[20] = "QWERTYUIOP[]\\";
	char mid[20] = "ASDFGHJKL;'";
	char down[20] = "ZXCVBNM,./";
	int count;
	input[0]='1';
	while(gets(input)) {
		if(input[0] == 0) break;
		for(int i = 0; i < strlen(input); i++) {
			for(int j = 0; j < strlen(upup); j++) {
				if(input[i] == upup[j]) {
					input[i] = upup[j-1];
					break;
				}
			}
			for(int j = 0; j < strlen(up); j++) {
				if(input[i] == up[j]) {
					input[i] = up[j-1];
					break;
				}
			}
			for(int j = 0; j < strlen(mid); j++) {
				if(input[i] == mid[j]) {
					input[i] = mid[j-1];
					break;
				}
			}
			for(int j = 0; j < strlen(down); j++) {
				if(input[i] == down[j]) {
					input[i] = down[j-1];
					break;
				}
			}
			
		}
		printf("%s\n", input);
	}
	return 0;
}
