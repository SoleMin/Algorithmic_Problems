#include <stdio.h>
#include <string.h>
char *keyboard="1234567890-=QWERTYUIOP[]ASDFGHJKL;'ZXCVBNM,./";
int main() {
	char input[100]={};
	int key=strlen(keyboard);
	while(gets(input)){
		for(int i=0;i<strlen(input);i++){
			for(int j=0;j<key;j++){
				if(input[i]==' ')
					break;
				else if(keyboard[j]==input[i]){
					input[i]=keyboard[j-1];
					break;
				}
			}
		}
		printf("%s\n",input);
	}
	return 0;
}
