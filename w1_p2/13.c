#include <stdio.h>
#define BUFSIZE 1024

int main() {
	char line[BUFSIZE];
	int hex, dec;
	
	while(fgets(line, BUFSIZE, stdin) != NULL){
		if(line[0] == '0'){
			sscanf(line + 2, "%x", &hex);
			printf("%d\n", hex);
		} else{
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}
	return 0;
}
