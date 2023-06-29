#include <stdio.h>
#define SIZE 1024

int main() {
	char input[SIZE];
	
	while(fgets(input, SIZE, stdin) != NULL){
		int num=0;
		if(input[1] == 'x'){
			sscanf(input+2, "%x", &num);
			printf("%d\n", num);
		}
		else{
			sscanf(input, "%d", &num);
			printf("0x%X\n", num);
		}
	}
	
	return 0;
}