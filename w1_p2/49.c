#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#define BUFSIZE 1024 
int main() {
	char s[BUFSIZE];
	char **p;
	while(fgets(s,BUFSIZE,stdin) != NULL) {                         
		
		if(s[1] == 'x') {
			printf("%d\n",strtol(s,&p,16));
		}
		else {
			printf("0x%X\n",atoi(s));
		}
	}
	

}



