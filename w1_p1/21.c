#include <stdio.h>
#include <string.h>
#define SIZE 1024

int main() {
	char input[SIZE];
	
	while(fgets(input, SIZE, stdin) != NULL){
		int w=0, l=0, i=0;
		while(input[i]!='\n' && strlen(input)>i){
			if(i==0 && input[i]!=' ' && input[i]!='\t')
				w++;
			
			if(i!=0 && (input[i-1]==' ' || input[i-1]=='\t') && (input[i]!=' ' && input[i]!='\t'))
				w++;
				
			if(input[i]!=' ' && input[i]!='\t')
				l++;
			
			i++;
		}
		printf("%d %d\n", l, w);
	}	
	
	return 0;
}
