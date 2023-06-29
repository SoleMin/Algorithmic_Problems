#include <stdio.h>
#include <string.h>
#define BUFSIZE 1024

int main()
{
	char input[BUFSIZE];
	
	while(fgets(input, BUFSIZE, stdin) != NULL){
		int words = 0, letters = 0;
		
		for(int i=0; i < strlen(input); i++)
			if(48 <= input[i] && input[i] <= 122){
				letters++;
				if((input[i+1] == ' ') || (input[i+1] == '\t') || (input[i+1] == '\n') || (input[i+1] == '\r') || (i == strlen(input) - 1))
					words++;
			}
		printf("%d %d\n", letters, words);
	}
	return 0;
}