#include <stdio.h>
#define SIZE 1024
int main() {
	int dec=0, hex=0;
	char line[SIZE];
		
	while(fgets(line, SIZE, stdin) != NULL){
		if(line[0]=='0'){
			sscanf(line+2, "%x", &hex);
			printf("%d\n", hex);
		}
		else{
			sscanf(line, "%d", &dec);
			printf("0x%X\n", dec);
		}
	}

	return 0;
	
}
