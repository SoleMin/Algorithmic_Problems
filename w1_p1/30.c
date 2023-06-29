#include <stdio.h>
int main() {
	char input[1024];
	while(fgets(input,1024,stdin) != NULL){
		int letter = 0, word = 0 , i = 0;
		while(input[i] != '\n' && strlen(input) > 1){
			if (input[i] != ' ' && input[i] != '\t') {
				letter++;
			}
			if ((i == 0 && (input[i] != ' ' && input[i] != '\t')) || (i > 0 && (input[i-1] == ' ' || input[i-1] == '\t') && (input[i] != ' ' && input[i] != '\t'))){
				word++;
			}
			i++;
		}
		printf("%d %d\n", letter, word);
	}
	return 0;
}
