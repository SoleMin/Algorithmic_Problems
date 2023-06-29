#include <stdio.h>
#include <string.h>
#define BUFSIZE 1024

int main() {
	char input[BUFSIZE];
	
	while(fgets(input, BUFSIZE, stdin) != NULL)
	{
		int wd = 0;
		int lt = 0;
		int i=0;
		while(input[i] != '\n' && strlen(input) > i)
		{
			if((i == 0 &&(input[i] != ' ' && input[i] != '\t')) || (i > 0 && (input[i-1] == ' ' || input[i-1] == 		'\t') && (input[i] != ' ' && input[i] != '\t')))
			{
				wd++;
			}
			if(input[i] != ' ' && input[i] != '\t')
			{
				lt++;
			}
			i++;
		}
		printf("%d %d\n", lt, wd);
	}
	
	return 0;
}
