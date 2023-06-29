#include <stdio.h>
#include <string.h>

int main() {
	char input1[1000];
	char input2[1000];

	
	while (gets(input1) && *input1 && gets(input2) && *input2) {
		int output[26] = {0};
		
		for (int i = 0; i < strlen(input1); i++)
			output[input1[i]-97] += 1000;
		
		for (int i = 0; i < strlen(input2); i++)
			output[input2[i]-97] += 1;
	
		for (int i = 0; i < 26; i++) {
			int x = output[i] / 1000;
			int y = output[i] % 1000;
			while (x != 0 && y != 0) {
				printf("%c", i+97);
				x--;
				y--;
			}
		}
		putchar('\n');
	}
	
	return 0;
}
