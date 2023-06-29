#include <stdio.h>
int main() {
	char num[1024];
	while(fgets(num, sizeof(num), stdin) != NULL){
		if(strstr(num, "0x") == NULL){
			int n = strtol(num, NULL, 10);
			printf("0x%X\n", n);
		}
		else{
			int n = strtol(num, NULL, 16);
			printf("%d\n", n);
		}
	}
}
