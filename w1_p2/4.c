#include <stdio.h>
int main(void) {
	char input[100];
	int hex, dec;
	while(fgets(input, 100, stdin) != NULL) {
		if(input[1] == 'x') {
			hex = 0;
			sscanf(input + 2, "%x", &hex);
			printf("%d\n", hex);
		}
		else{
			dec = 0;
			sscanf(input, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
	return 0;
}
