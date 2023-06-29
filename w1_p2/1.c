#include <stdio.h>
#include <stdlib.h>

int main() {
	char buffer[1024];
	int num = 0;
	for(;scanf("%s", buffer) == 1;){
		if(buffer[0] == '0'){
			sscanf(buffer+2, "%x", &num);
			printf("%d\n", num);
		}
		else{
			sscanf(buffer, "%d", &num);
			printf("0x%X\n", num);
		}
		num = 0;
	}
	
	return 0;
}
