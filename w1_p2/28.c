#include <stdio.h>
int main() {
	char input[100];
	int count, temp, a;
	while(fgets(input, 100, stdin) != NULL){
		count= temp = 0;
		if(input[count] != '0'){
			sscanf(input +count ,"%d", &temp);
			printf("0x%X\n",temp);
		}
		else{
			count = count +2;
			sscanf(input + count, "%x", &temp);
			printf("%u\n",temp);
		}
	}
	
}

