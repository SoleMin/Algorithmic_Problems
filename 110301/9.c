#include <stdio.h>
#include<string.h>

char* yspell = "1234567890-=QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./";

void main(){
	char input[1000];
	
	while(gets(input)){
		int spellyes = strlen(yspell);
		int inputnum = strlen(input);
		
		for(int i = 0; i < inputnum; i++){
			for(int j = 0; j < yspell; j++){
				if(input[i] == ' ')
					break;
				else if(yspell[j] == input[i]){
					input[i] = yspell[j - 1];
					break;
				}
			}
		}
		printf("%s\n", input);
	}
}