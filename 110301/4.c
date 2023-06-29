#include <stdio.h>
#include <string.h>

int main() {
	char input[50];
	char a[] = {"`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./"};
	char *p;
	int index;
	
	while (gets(input) && *input) {
		for (int i = 0; i < strlen(input); i++) {
			if (input[i] == ' ')
				printf(" ");
			else if (input[i] != '`' && input[i] != 'Q' && input[i] != 'A' && input[i] != 'Z'){
				p = strchr(a, input[i]);
				index = (int)(p-a);
				printf("%c", a[index-1]);
			}
			else if (input[i] == '`' || input[i] == 'Q' || input[i] == 'A' || input[i] == 'Z') {
				p = strchr(a, input[i]);
				index = (int)(p-a);
				printf("%c", a[index]);
			}
		}
		putchar('\n');
	}
	
	return 0;
}
