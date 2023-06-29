#include <stdio.h>
#define BUFSIZE 1024

int main() {
	char input[BUFSIZE];
	
	while (fgets(input, BUFSIZE, stdin) != NULL) {
		int words = 0, letters = 0, i = 0;
		while (input[i] != '\n' && strlen(input) > i) {
			if ((i == 0 && (input[i] != ' ' && input[i] != '\t')) || (i > 0 && (input[i-1] == ' ' || input[i-1] == '\t') && (input[i] != ' ' && input[i] != '\t')))
				words++;
			if (input[i] != ' '  && input[i] != '\t') letters++;
			i++;
		}
		printf("%d %d\n", letters, words);
	}
	return 0;
}
