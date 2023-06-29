#include <stdio.h>
int main() {
	char input[100];
	int num;
	while(fgets(input, 100, stdin)){
		if(input[1] == 'x'){ // 16진수
			sscanf(&input[2], "%x", &num);
			printf("%d\n", num);
		}
		else{
			sscanf(input, "%d", &num);
			printf("0x%X\n", num);
		}
	}
	return 0;
}
