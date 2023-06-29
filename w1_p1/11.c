#include <stdio.h>
#include <string.h>
int main() {
	char input[1024];
	
	while(fgets(input, sizeof(input), stdin) != NULL){
		int letters = 0, words = 0, i=0;
		if(input[0] != ' ' && input[0] != '\t')
			words++;
		while(input[i] != '\n' && strlen(input) > i ){
				if((input[i-1] == ' ' || input[i-1] =='\t') && (input[i] != ' ' && 						input[i] != '\t'))
					words++;
				if(input[i] != ' ' && input[i] != '\t')
					letters++;	
			i++;
	}
		printf("%d %d\n",letters, words);
	}
	

	
	return 0;
}
