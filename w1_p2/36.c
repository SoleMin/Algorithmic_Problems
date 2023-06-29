#include <stdio.h>
#define MAX_NUMBER 1024
int main(void) {
	char input[MAX_NUMBER];
	
	while(fgets(input, MAX_NUMBER, stdin) != NULL) {
		if(input[0] == '0') {
			int hex = 0;
			sscanf(input + 2, "%x", &hex);
			printf("%d\n", hex);
		}
		else {
			int dec = 0;
			sscanf(input, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
		
	return 0;
}
