#include <stdio.h>
#include <string.h>
#include <malloc.h>

int main() {
	char *input;
	input = (char *)malloc(sizeof(char)*30);
	int word, letter, count;
	
	while(fgets(input, 1024, stdin) != NULL){
		word = letter= count =0;
		while(input[count] != '\n' && strlen(input) > count){
			if(input[count] != ' ' && input[count] != '\t')
				letter++;
			if((count == 0 && (input[count] != ' ' && input[count] !='\t')) || (count > 0 &&(input[count-1] ==' ' || input[count-1] =='\t') && (input[count] != ' ' && input[count] != '\t')))
				word++;
			count++;
		}
		printf("%d %d\n",letter, word);
	}
	free(input);
	return 0;
}
