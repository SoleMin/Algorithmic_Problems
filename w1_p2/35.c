#include <stdio.h>
#define BUFSIZE 1024
int main() {
	char input[BUFSIZE];
	
	while (fgets(input,BUFSIZE,stdin) != NULL ){
		if (input[0] == '0') {
			int hex = 0;
			sscanf(input + 2, "%x" , &hex);
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
