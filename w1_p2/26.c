/* Idea: long strtol(const char* str, char** endptr, int base);
str: string you want to change it to numeric value
endptr: pointer that stores last conversion spot.
base: base system
*/

#include <stdio.h>

int main(void) {
	char num[1024];
	while (fgets(num, 1024, stdin) != NULL) {
		long conv_num;
		if (num[0] == '0') {
			conv_num = strtol(num, NULL, 16);
			printf("%d\n", conv_num);
		}
		else {
			conv_num = strtol(num, NULL, 10);
			printf("0x%X\n", conv_num);
		}
	}
	return 0;
}