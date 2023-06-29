#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
	char input[1024];
	int lets, wrds, i;
	
	while(fgets(input, 1024, stdin) != NULL) {
		wrds = 0, lets = 0, i = 0;
		if(input[0] == '.') break;
		while(input[i] != '\n' && strlen(input) > i) {
			if((i ==0 && (input[i] != ' ' && input[i] != '\t')) || (i > 0 && (input[i - 1] == ' ' || input[i - 1] =='\t') && (input[i] != ' '&& input[i] != '\t')))
				wrds++;
			if(input[i] != ' ' && input[i] != '\t')
				lets++;
			i++;
		}
		printf("%d %d\n", lets, wrds);	
  }
	return 0;
}
