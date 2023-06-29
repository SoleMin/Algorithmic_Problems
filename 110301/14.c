#include <stdio.h>
#include <string.h>

#define MAX 100 

int main() {
	char input[MAX];
	char key[]="`1234567890-=QWERTYUIOP[]\ASDFGHJKL;'ZXCVBNM,./";
	int key_length=strlen(key);
	int i, j;
	while(fgets(input, MAX, stdin)!=NULL){
		int input_length=strlen(input);
		for(i=0; i<MAX; i++){
			if(input[i]=='Q' || input[i]=='A' || input[i]=='Z' || input[i]=='`') break;
		}
		for(i=0; i<input_length; i++){
			for(j=0; j<key_length; j++){
				if(input[i]==key[j]){
					input[i]=key[j-1];
					break;
				}
			}
		}
		printf("%s", input);
	}
}
