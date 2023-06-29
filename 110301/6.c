#include <stdio.h>
#include <string.h>
const char *k = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

int main() {
	char input[1000];
	
	while(gets(input)) {
		for(int i = 0; input[i]; i++) {
			if (input[i] == ' ') {
				putchar(' ');
				continue;
			}
			for(int j = 0; k[j+1]; j++)
				if(k[j+1] == input[i])
					putchar(k[j]);
		}
		puts("");
	}
	return 0;
}
