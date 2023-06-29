#include <stdio.h>

int main(){
	char line[1024];
	
	while(fgets(line, 1024, stdin) != NULL){
		int words = 0;
		int letters = 0;
		int i = 0;
		while(line[i] != '\n' && strlen(line) > i){
			if((i == 0 && (line[i] != ' ' && line[i] != '\t')) || (i > 0 && (line[i - 1] == ' ' || line[i - 1] == '\t') && (line[i] != ' ' && line[i] != '\t')))
				words++;
			if(line[i] != ' ' && line[i] != '\t')
				letters++;
			i++;
		}
		printf("%d %d\n", letters, words);
	}
	
	return 0;
}