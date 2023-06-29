#include <stdio.h>
#define SIZE 1025
int main() {
	
	char str[SIZE];
	
	while(fgets(str, SIZE, stdin) != '\0') {
		int i=0, chacs=0, words=0;
		while(str[i] != '\n'){
		if(i==0 && (str[i]!=' '&& str[i]!='\t') || (i>0 && (str[i-1] == ' ' || str[i-1] =='\t') && (str[i]!=' ' && str[i]!='\t'))) 
			words++;
		if(str[i]!=' '&& str[i]!='\t')
			chacs++;
		i++;
		}
	
	printf("%d %d\n", chacs, words);
	}
	
	
	return 0;
}
