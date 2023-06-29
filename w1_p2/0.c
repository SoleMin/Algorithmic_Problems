#include <stdio.h>
#define BUFSIZE 1024

int main(void) {
	char line[BUFSIZE];
	
	while(fgets(line, BUFSIZE, stdin) != NULL){
		if(line[0] == '0'){
			if(line[1] == 'x'){
				int hex = 0;
				sscanf(line +2, "%x", &hex);
				printf("%d\n", hex);
			}
			else
				printf("0x0\n");
		}
		else{
			int dec = 0;
			sscanf(line, "%d", &dec);
		  printf("0x%X\n", dec);
		}
	}
	return 0;
}
