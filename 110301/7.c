#include <stdio.h>
void main() {
	char key[46] = "`1234567890-QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./ ";
	char input[100];
	int correct;
	
	while(gets(input)) {
		
		
		for(int i = 0; input[i] != NULL; i++) {
			
			if(input[i] == 32)
				printf(" ");
			else {
				for(int j = 0; j<46; j++) {
					if(input[i] == key[j]) {
						correct = j - 1;
						break;
					}
				}
				printf("%c", key[correct]);
			}
				
			
		}
		
		printf("\n");
	}
}
