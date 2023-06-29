#include <stdio.h>
#include <ctype.h>
#include <string.h>

void main() {
	
	char input[100];
	char key[100] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=',
									'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\',
									'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'',
									'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
	int i;
	char c;
	
	while(gets(input)) {
		int count = 0;
		while(input[count]) {
			if (islower(input[count])) 
				input[count] = toupper(input[count]);
			count++;
		}
		
		count = 0;
		while(input[count]) {
			for (i = 0; i < strlen(key); i++)
				if (input[count] == key[i]) {
					input[count] = key[i-1];
					break;
				}
			count++;
		}
		printf("%s\n", input);
	}
}
